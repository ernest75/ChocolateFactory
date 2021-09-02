package com.example.chocolatefactory.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chocolatefactory.common.ScopedViewModel
import com.example.chocolatefactory.domain.OmpaWorkerDetails
import com.example.chocolatefactory.usecases.GetOmpaWorkerDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class DetailViewModel(
    private val workerId: Int,
    private val getOmpaWorkerDetails: GetOmpaWorkerDetails,
    override val uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    init {
        initScope()
    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val workerDetails: OmpaWorkerDetails) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun refresh() {
        launch{
            _model.value = UiModel.Content(getOmpaWorkerDetails.invoke(workerId))
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}