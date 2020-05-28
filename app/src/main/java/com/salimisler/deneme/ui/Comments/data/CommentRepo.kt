package com.salimisler.deneme.ui.Comments.data

import com.salimisler.deneme.app.data.dto.Comment
import com.salimisler.deneme.ui.Comments.CommentContract
import com.salimisler.deneme.ui.Comments.api.CommentApi
import io.reactivex.Single

class CommentRepo(private val api : CommentApi) : CommentContract.Repo {
    override fun getComments(id: Int): Single<List<Comment>> = api.getComments(id)
}