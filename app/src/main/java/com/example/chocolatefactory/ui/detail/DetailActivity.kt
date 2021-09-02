package com.example.chocolatefactory.ui.detail

import android.os.Bundle
import com.example.chocolatefactory.R
import com.example.chocolatefactory.databinding.ActivityDetailBinding
import com.example.chocolatefactory.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.ScopeActivity
import org.koin.core.parameter.parametersOf
import timber.log.Timber

class DetailActivity : ScopeActivity() {

    companion object {
        const val WORKER = "DetailActivity:movie"
    }
    private lateinit var binding: ActivityDetailBinding

    private val viewModel: DetailViewModel by inject {
        parametersOf(intent.getIntExtra(WORKER, -1))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}