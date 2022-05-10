package com.example.suku_hiltmvvmcoroutineretrofit.repository

import com.example.suku_hiltmvvmcoroutineretrofit.data.network.RemoteDataSource
import com.suku.network.data.model.EmployeeResponse
import com.suku.network.data.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getValues(): NetworkResult<EmployeeResponse> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getEmployees()
        }
    }
}