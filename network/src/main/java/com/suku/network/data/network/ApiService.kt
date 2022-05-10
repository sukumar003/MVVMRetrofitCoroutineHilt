package com.suku.network.data.network

import com.suku.network.data.model.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    suspend fun getEmployeesAsync(@Query("q") query: String): Response<EmployeeResponse>
}