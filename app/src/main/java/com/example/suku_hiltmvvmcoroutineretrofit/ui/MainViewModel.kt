package com.example.suku_hiltmvvmcoroutineretrofit.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.suku_hiltmvvmcoroutineretrofit.repository.Repository
import com.suku.network.data.model.EmployeeResponse
import com.suku.network.data.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var liveDataEmployees = MutableLiveData<NetworkResult<EmployeeResponse>>()

    fun callApi() {
        viewModelScope.launch {
            liveDataEmployees.postValue(NetworkResult.Loading())
            val result = repository.getValues()
            liveDataEmployees.postValue(result)
        }
    }
}