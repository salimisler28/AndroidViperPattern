package com.salimisler.deneme.app

import android.app.Application
import com.salimisler.deneme.app.di.AppComponent
import com.salimisler.deneme.app.di.AppModule
import com.salimisler.deneme.app.di.DaggerAppComponent

class App : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}