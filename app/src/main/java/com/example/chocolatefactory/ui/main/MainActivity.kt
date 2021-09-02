package com.example.chocolatefactory.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.chocolatefactory.R
import com.example.chocolatefactory.ui.main.MainViewModel.*
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : ScopeActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: UiModel) {

        when(uiModel){
            is UiModel.Content -> Timber.e(uiModel.workers.toString())
        }

    }
}