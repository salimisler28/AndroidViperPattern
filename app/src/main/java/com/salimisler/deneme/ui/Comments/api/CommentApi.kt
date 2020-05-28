package com.salimisler.deneme.ui.Comments.api

import com.salimisler.deneme.app.data.dto.Comment
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CommentApi {
    @GET("comments")
    fun getComments(@Query("postId") postId:Int) : Single<List<Comment>>

    @GET("posts/{postId}/comments")
    fun getComments2(@Path("postId") postId: Int) : Single<List<Comment>>
}