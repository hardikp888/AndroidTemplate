package com.hardik.androidtemplate.di

import com.hardik.androidtemplate.TemplateApplication
import com.hardik.androidtemplate.di.activity.AppModule
import com.hardik.repository.di.ApiModule
import com.hardik.repository.di.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DatabaseModule::class,
        ApiModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
        ActivityModule::class
    ]
)

interface AppComponent : AndroidInjector<TemplateApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TemplateApplication): Builder

        fun build(): AppComponent
    }

    override fun inject(app: TemplateApplication)
}