package com.jusdev.mvvm.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jusdev.mvvm.ui.repository.RepositoryLending
import com.jusdev.mvvm.ui.repository.RepositoryLogin
import com.jusdev.mvvm.ui.viewmodel.LendingViewModel
import com.jusdev.mvvm.ui.viewmodel.LoginViewModel

class LendingVIewModelFactory(private val repositoryLending: RepositoryLending): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LendingViewModel(repositoryLending) as T
    }
}