package com.salimisler.deneme.ui.Main.di

import com.salimisler.deneme.app.di.ActivityScope
import com.salimisler.deneme.app.di.AppComponent
import com.salimisler.deneme.ui.Main.MainActivity
import dagger.Component
import dagger.BindsInstance

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MainModule): Builder

        fun build(): MainComponent
    }
}