package com.hardik.androidtemplate.di

import com.hardik.androidtemplate.di.activity.MainActivityModule
import com.hardik.androidtemplate.ui.MainActivity
import com.hardik.core.di.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {


    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}