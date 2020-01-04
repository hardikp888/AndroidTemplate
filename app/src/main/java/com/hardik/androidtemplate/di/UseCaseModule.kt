package com.hardik.androidtemplate.di

import com.hardik.androidtemplate.usecase.GetHeroesUseCase
import com.hardik.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun providesGetHeroesUseCase(repository: Repository) : GetHeroesUseCase {
        return GetHeroesUseCase(repository)
    }
}