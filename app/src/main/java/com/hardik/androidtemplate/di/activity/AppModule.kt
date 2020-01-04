package com.hardik.androidtemplate.di.activity

import android.app.Application
import android.content.Context
import com.hardik.androidtemplate.TemplateApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: TemplateApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun provideApplication(application: TemplateApplication): Application {
        return application
    }
}