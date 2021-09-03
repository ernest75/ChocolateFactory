package com.example.chocolatefactory.ui.detail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.lifecycle.Observer
import com.example.chocolatefactory.R
import com.example.chocolatefactory.common.formatHtml
import com.example.chocolatefactory.common.loadUrl
import com.example.chocolatefactory.databinding.ActivityDetailBinding
import com.example.chocolatefactory.databinding.ActivityMainBinding
import com.example.chocolatefactory.ui.detail.DetailViewModel.*
import com.example.chocolatefactory.ui.main.MainViewModel
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

        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(uiModel: UiModel) {

        binding.progressBarDetail.visibility = if (uiModel is UiModel.Loading) View.VISIBLE else View.GONE
        when(uiModel){
            is UiModel.Content -> {
                populateView(uiModel)
            }
        }
    }

    private fun populateView(uiModel: UiModel.Content) {

        val workerDetails = uiModel.workerDetails

        with(binding) {
            ivWorkerDetail.loadUrl(workerDetails.image)
            tvWorkerFirstName.text = workerDetails.firstName
            tvWorkerLastName.text = workerDetails.lastName
            tvWorkerGender.text = workerDetails.gender
            tvWorkerAge.text = workerDetails.age.toString()
            tvWorkerCountry.text = workerDetails.country
            tvWorkerProfession.text = workerDetails.profession
            tvWorkerEmail.text = workerDetails.email
            tvWorkerDescription.formatHtml(workerDetails.description)
            tvWorkerSong.text = workerDetails.favorite.song
            tvWorkerRandomString.text = workerDetails.favorite.randomString

        }
    }
}