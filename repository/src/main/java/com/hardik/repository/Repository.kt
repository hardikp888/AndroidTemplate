package com.hardik.repository

import androidx.lifecycle.MutableLiveData
import com.hardik.core.Result
import com.hardik.repository.database.AppDatabase
import com.hardik.repository.model.Hero
import com.hardik.repository.network.ApiManager
import javax.inject.Inject

class Repository @Inject constructor(
    private val database: AppDatabase,
    private val apiManager: ApiManager
) {

    suspend fun getHeroesFromNetwork(): MutableLiveData<Result<Hero>> {
        return apiManager.getAllHeroes()
    }
}