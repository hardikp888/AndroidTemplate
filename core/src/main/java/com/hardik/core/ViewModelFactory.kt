package com.hardik.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory @Inject constructor(
    private val viewModels: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        val found = viewModels.entries.find { modelClass.isAssignableFrom(it.key) }
        var creator =
            found?.value ?: throw IllegalArgumentException("unknown model class $modelClass")

        try {
            return creator.get() as T
        } catch (exception: Exception) {
            throw RuntimeException(exception)
        }
    }
}