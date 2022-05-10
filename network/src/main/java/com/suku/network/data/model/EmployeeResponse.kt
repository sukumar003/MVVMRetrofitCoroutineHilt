package com.suku.network.data.model

data class EmployeeResponse(val items: List<ListData>)

data class ListData(val name: String?, val description: String?, val owner: Owner?)

data class Owner(val avatar_url: String?)
