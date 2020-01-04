package com.hardik.androidtemplate.di

import androidx.lifecycle.ViewModelProvider
import com.hardik.core.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


}