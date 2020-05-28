package com.salimisler.deneme.ui.Main.api

import com.salimisler.deneme.app.data.dto.Post
import io.reactivex.Single

import retrofit2.http.GET

interface MainApi {
    @GET("posts")
    fun getPosts() : Single<List<Post>>
}