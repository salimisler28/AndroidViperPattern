package com.salimisler.deneme.ui.Comments

import android.util.Log
import com.salimisler.deneme.app.data.dto.Comment
import com.salimisler.deneme.ui.Comments.data.CommentRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CommentInteractor(private val repo : CommentRepo) : CommentContract.Interactor {
    private val compositeDisposable = CompositeDisposable()

    override fun getComments(id: Int, onSuccess: (List<Comment>) -> Unit, onError: (Throwable) -> Unit) {
        val disposable = repo.getComments(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess(onSuccess)
            .doOnError(onError)
            .subscribe({ t1: List<Comment>?, t2: Throwable? -> Log.e("Error", t2?.message.toString()) })

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()

}