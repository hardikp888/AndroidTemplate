package com.hardik.androidtemplate.di.activity

import androidx.lifecycle.ViewModel
import com.hardik.androidtemplate.ui.MainFragment
import com.hardik.androidtemplate.viewmodel.HeroListViewModel
import com.hardik.core.ViewModelKey
import com.hardik.core.di.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(HeroListViewModel::class)
    abstract fun heroListViewModel(heroListViewModel: HeroListViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMainFragment(): MainFragment
}