package com.hardik.androidtemplate.viewmodel

import androidx.lifecycle.ViewModel
import com.hardik.androidtemplate.usecase.GetHeroesUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class HeroListViewModel @Inject constructor(private val getHeroesUseCase: GetHeroesUseCase) :
    ViewModel() {

    val heroList = runBlocking {
        val result = async { getHeroesUseCase.execute(Unit) }
        result.await()
    }

}