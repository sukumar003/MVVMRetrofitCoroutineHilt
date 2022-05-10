package com.example.suku_hiltmvvmcoroutineretrofit.ui

import com.example.suku_hiltmvvmcoroutineretrofit.util.NetworkUtils
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.suku_hiltmvvmcoroutineretrofit.R
import com.example.suku_hiltmvvmcoroutineretrofit.databinding.ActivityMainBinding
import com.example.suku_hiltmvvmcoroutineretrofit.ui.base.BaseActivity
import com.google.gson.Gson
import com.suku.network.data.network.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import com.example.suku_hiltmvvmcoroutineretrofit.util.logd
import com.example.suku_hiltmvvmcoroutineretrofit.util.showMessage

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        callDemoApi()
        observerDemoApiData()
    }

    private fun callDemoApi() {
        if (NetworkUtils.isNetWorkAvailable(applicationContext))
            mainViewModel.callApi()
        else
            showMessage(getString(R.string.no_internet))
    }

    private fun observerDemoApiData() {
        mainViewModel.liveDataEmployees.observe(this) { result ->

            when (result) {
                is NetworkResult.Loading -> showProgressBar(true)

                is NetworkResult.Success -> {
                    showProgressBar()
                    logd("RESULT DATA: ${Gson().toJson(result.data)}")
                }
                is NetworkResult.Failure -> {
                    showProgressBar()
                    showMessage("${result.message}")
                }
                else -> {
                    showProgressBar()
                    showMessage("${result.message}")
                }
            }
        }
    }

    private fun showProgressBar(isVisible: Boolean = false) {
        mainBinding.progressCircular.visibility = if (isVisible)
            View.VISIBLE
        else View.GONE
    }
}