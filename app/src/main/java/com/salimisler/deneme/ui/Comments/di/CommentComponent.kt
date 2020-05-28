package com.salimisler.deneme.ui.Comments.di

import com.salimisler.deneme.app.di.ActivityScope
import com.salimisler.deneme.app.di.AppComponent
import com.salimisler.deneme.ui.Comments.CommentActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [CommentModule::class], dependencies = [AppComponent::class])
interface CommentComponent {
    fun inject(target: CommentActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: CommentActivity) : Builder
        fun appComponent(component: AppComponent): Builder
        fun plus(module : CommentModule) : Builder
        fun build() : CommentComponent
    }
}