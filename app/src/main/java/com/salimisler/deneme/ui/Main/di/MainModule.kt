package com.salimisler.deneme.ui.Main.di

import com.salimisler.deneme.app.di.ActivityScope
import com.salimisler.deneme.ui.Main.*
import com.salimisler.deneme.ui.Main.api.MainApi
import com.salimisler.deneme.ui.Main.data.MainRepo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class MainModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit) = retrofit.create(MainApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: MainApi) = MainRepo(api)

    @Provides
    @ActivityScope
    fun router(activity: MainActivity): MainContract.Router = MainRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router : MainContract.Router, interactor: MainInteractor) = MainPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: MainRepo) = MainInteractor(repository)
}