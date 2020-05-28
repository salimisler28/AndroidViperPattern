package com.salimisler.deneme.ui.Main.data

import com.salimisler.deneme.app.data.dto.Post
import com.salimisler.deneme.ui.Main.MainContract
import com.salimisler.deneme.ui.Main.api.MainApi
import io.reactivex.Single

class MainRepo(private val api : MainApi) : MainContract.Repo {
    override fun getPosts() : Single<List<Post>> = api.getPosts()
}