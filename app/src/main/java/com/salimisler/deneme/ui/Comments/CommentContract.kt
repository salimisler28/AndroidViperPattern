package com.salimisler.deneme.ui.Comments

import com.salimisler.deneme.app.data.dto.Comment
import io.reactivex.Single

interface CommentContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Comment>)
        fun showMessage(msg: String)
    }

    interface Presenter  {
        fun bindView(view : CommentContract.View)
        fun unBindView()
        fun onViewCreated(id : Int)
    }

    interface Interactor  {
        fun getComments(id: Int, onSuccess: (List<Comment>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router  {

    }

    interface Repo {
        fun getComments(id: Int) : Single<List<Comment>>
    }
}