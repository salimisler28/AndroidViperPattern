package com.salimisler.deneme.ui.Main

import android.app.Activity
import com.salimisler.deneme.app.data.dto.Post
import io.reactivex.Single

interface MainContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Post>)
        fun showMessage(msg: String)
        fun getClickedPost(data: Post)
    }

    interface Presenter  {
        fun bindView(view : MainContract.View)
        fun unBindView()
        fun onViewCreated()
        fun onItemClicked(post : Post)
    }

    interface Interactor  {
        fun getJokes(onSuccess: (List<Post>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router  {
        fun finish()
        fun startCommentActivity(data : Post)
    }

    interface Repo {
        fun getPosts() : Single<List<Post>>
    }
}