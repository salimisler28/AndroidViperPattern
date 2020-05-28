package com.salimisler.deneme.ui.Main

import com.salimisler.deneme.app.data.dto.Post

class MainPresenter(private val router: MainContract.Router, private val interactor: MainInteractor) : MainContract.Presenter {
    var mView : MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.mView = view
    }

    override fun unBindView() {
        this.mView = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        mView?.showLoading()
        interactor.getJokes({
            mView?.hideLoading()
            mView?.publishData(it)
        }, this::onError )
    }

    override fun onItemClicked(post: Post) {

    }

    private fun onError(error : Throwable){
        mView?.hideLoading()
        error.message.let {
            mView?.showMessage(it.toString())
        }
    }

    fun postClicked(data: Post) {
        router.startCommentActivity(data)
    }
}