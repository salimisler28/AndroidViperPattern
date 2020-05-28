package com.salimisler.deneme.ui.Comments

class CommentPresenter(private val router: CommentContract.Router, private val interactor: CommentContract.Interactor) : CommentContract.Presenter{

    private var mView : CommentContract.View? = null

    override fun bindView(view: CommentContract.View) {
        this.mView = view
    }

    override fun unBindView() {
        mView = null
    }

    override fun onViewCreated(id : Int) {
        mView?.showLoading()
        interactor.getComments(id, {
            mView?.publishData(it)
            mView?.hideLoading()
        }, {
            mView?.showMessage(it.message.toString())
        })
    }
}