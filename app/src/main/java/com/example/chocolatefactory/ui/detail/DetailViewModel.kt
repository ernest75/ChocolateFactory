package com.example.chocolatefactory.ui.detail

import com.example.chocolatefactory.common.ScopedViewModel
import kotlinx.coroutines.CoroutineDispatcher

class DetailViewModel(
    private val workerId: Int,
    override val uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {




    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}