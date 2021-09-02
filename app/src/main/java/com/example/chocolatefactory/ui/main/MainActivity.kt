package com.example.chocolatefactory.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chocolatefactory.common.TopSpaceItemDecoration
import com.example.chocolatefactory.databinding.ActivityMainBinding
import com.example.chocolatefactory.ui.adapters.WorkersAdapter
import com.example.chocolatefactory.ui.main.MainViewModel.*
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : ScopeActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var workersAdapter: WorkersAdapter
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            workersAdapter = WorkersAdapter(viewModel::onWorkerClicked)
            val topSpacingDecoration = TopSpaceItemDecoration(10)
            addItemDecoration(topSpacingDecoration)
            adapter = workersAdapter

        }

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(uiModel: UiModel) {

        binding.progress.visibility = if (uiModel is UiModel.Loading) View.VISIBLE else View.GONE

        when(uiModel){
            is UiModel.Content -> {
                workersAdapter.workers = uiModel.workers
                Timber.e(uiModel.workers.toString())
            }
        }

    }

}