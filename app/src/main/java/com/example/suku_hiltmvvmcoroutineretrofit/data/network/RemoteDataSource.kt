package com.example.suku_hiltmvvmcoroutineretrofit.data.network

import com.suku.network.data.model.EmployeeResponse
import com.suku.network.data.network.ApiService
import com.suku.network.data.network.BaseDataSource
import com.suku.network.data.network.NetworkResult
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiInterface: ApiService) :
    BaseDataSource() {

    suspend fun getEmployees(): NetworkResult<EmployeeResponse> {
        return invokeApiRequest(apiCall = {
            apiInterface.getEmployeesAsync("India")
        })
    }
}