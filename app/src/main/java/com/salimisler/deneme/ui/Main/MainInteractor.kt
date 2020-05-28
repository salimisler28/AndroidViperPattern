package com.salimisler.deneme.ui.Main

import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Main.data.MainRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainInteractor(private val repo : MainRepo) : MainContract.Interactor {
    private val compositeDisposable = CompositeDisposable()

    override fun getJokes(onSuccess: (List<Post>) -> Unit, onError: (Throwable) -> Unit) {
        val disposable = repo.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess(onSuccess)
            .doOnError(onError)
            .subscribe()

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}