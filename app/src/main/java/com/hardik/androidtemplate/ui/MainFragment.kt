package com.hardik.androidtemplate.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hardik.androidtemplate.R
import com.hardik.androidtemplate.viewmodel.HeroListViewModel
import com.hardik.core.Result
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val viewModel = viewModelFactory.create(HeroListViewModel::class.java)
        viewModel.heroList.observeForever { result ->

            when (result) {
                is Result.Loading -> {
                    Log.i("Hardik", "Loading.....................................")
                }
                is Result.Error -> {
                    Log.e("Hardik", "Error : ${result.exception?.message}", result.exception)
                }
                is Result.Success -> {
                    Log.i("Hardik", "\nPhoto ==> ${result.data} ")
                }

            }

        }

    }


}
