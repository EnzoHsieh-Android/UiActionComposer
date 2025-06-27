package com.enzo.uiactioncomposer.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }

    fun showSnackbar(message: String) {
        println("顯示 Snackbar: $message")
    }

    fun navigate(route: String) {
        println("導航到: $route")
    }
}