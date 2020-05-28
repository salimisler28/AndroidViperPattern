package com.salimisler.deneme.ui.Comments.di

import com.salimisler.deneme.app.di.ActivityScope
import com.salimisler.deneme.ui.Comments.*
import com.salimisler.deneme.ui.Comments.api.CommentApi
import com.salimisler.deneme.ui.Comments.data.CommentRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CommentModule {
    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(CommentApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api : CommentApi) = CommentRepo(api)

    @Provides
    @ActivityScope
    fun router(activity : CommentActivity) : CommentContract.Router = CommentRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: CommentContract.Router, interactor: CommentInteractor) = CommentPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository : CommentRepo) = CommentInteractor(repository)
}