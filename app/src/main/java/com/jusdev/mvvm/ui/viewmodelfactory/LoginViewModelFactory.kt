package com.jusdev.mvvm.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jusdev.mvvm.ui.repository.RepositoryLogin
import com.jusdev.mvvm.ui.viewmodel.LoginViewModel
import com.jusdev.mvvm.ui.viewmodel.MainViewModel

class LoginViewModelFactory(private val repositoryLogin: RepositoryLogin):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repositoryLogin) as T
    }
}