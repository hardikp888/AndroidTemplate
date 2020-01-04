package com.hardik.androidtemplate.usecase

import androidx.lifecycle.MutableLiveData
import com.hardik.core.Result
import com.hardik.core.UseCase
import com.hardik.repository.Repository
import com.hardik.repository.model.Hero
import com.hardik.repository.model.User
import javax.inject.Inject

class GetHeroesUseCase @Inject constructor(private val repository: Repository) :
    UseCase<Unit, MutableLiveData<Result<Hero>>>() {

    override suspend fun execute(parameter: Unit): MutableLiveData<Result<Hero>> {
        return repository.getHeroesFromNetwork()
    }
}