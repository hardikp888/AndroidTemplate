package com.hardik.repository.di

import android.app.Application
import androidx.room.Room
import com.hardik.repository.DATABASE_NAME
import com.hardik.repository.Repository
import com.hardik.repository.database.AppDatabase
import com.hardik.repository.database.dao.HeroesDao
import com.hardik.repository.network.ApiManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providesHeroesDao(appDatabase: AppDatabase): HeroesDao {
        return appDatabase.heroesDao()
    }


    @Provides
    @Singleton
    fun providesRepository(appDatabase: AppDatabase, apiManager: ApiManager): Repository {
        return Repository(appDatabase, apiManager)
    }
}