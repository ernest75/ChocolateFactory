package com.example.chocolatefactory

import android.app.Application
import com.example.chocolatefactory.data.repository.WorkersRepository
import com.example.chocolatefactory.data.source.LocalDataSource
import com.example.chocolatefactory.data.source.RemoteDataSource
import com.example.chocolatefactory.ui.data.database.ChocolateFactoryDatabase
import com.example.chocolatefactory.ui.data.database.RoomDataSource
import com.example.chocolatefactory.ui.data.network.OmpaWorkersDataSource
import com.example.chocolatefactory.ui.data.network.RetrofitClass
import com.example.chocolatefactory.ui.detail.DetailActivity
import com.example.chocolatefactory.ui.detail.DetailViewModel
import com.example.chocolatefactory.ui.main.MainActivity
import com.example.chocolatefactory.ui.main.MainViewModel
import com.example.chocolatefactory.usecases.GetOmpaWorkerDetails
import com.example.chocolatefactory.usecases.GetOmpaWorkers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.get
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, scopesModule))
    }
}

private val appModule = module {
    single<CoroutineDispatcher> { Dispatchers.Main }
    single(named("baseUrl")) { "https://2q2woep105.execute-api.eu-west-1.amazonaws.com/napptilus/oompa-loompas/" }
    single { ChocolateFactoryDatabase.build(get()) }
    single { RetrofitClass(get(named("baseUrl"))) }
    factory<RemoteDataSource> { OmpaWorkersDataSource(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory { WorkersRepository(get(),get()) }

}


val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get(),get()) }
        scoped { GetOmpaWorkers(get()) }
    }

    scope(named<DetailActivity>()) {
        viewModel { (id: Int) -> DetailViewModel(id, get(), get()) }
        scoped { GetOmpaWorkerDetails(get()) }
    }

}