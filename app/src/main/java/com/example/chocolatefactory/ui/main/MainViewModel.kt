package com.example.chocolatefactory.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.chocolatefactory.common.ScopedViewModel
import com.example.chocolatefactory.domain.OmpaWorker
import com.example.chocolatefactory.network.models.OompaLoompaWorker
import com.example.chocolatefactory.usecases.GetOmpaWorkers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val getOmpaWorkers: GetOmpaWorkers,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun refresh() {
        launch{
            _model.value = UiModel.Content(getOmpaWorkers.invoke())
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val workers: List<OmpaWorker>) : UiModel()
    }

    init {
        initScope()
    }

    fun onMovieClicked(worker: OmpaWorker) {
        Timber.e("Clicked ${worker.firstName}")
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}