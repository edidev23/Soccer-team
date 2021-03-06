package com.edisiswanto.soccerteam.core.di

import androidx.room.Room
import com.edisiswanto.soccerteam.core.data.TeamRepository
import com.edisiswanto.soccerteam.core.data.source.local.LocalDataSource
import com.edisiswanto.soccerteam.core.data.source.local.room.TeamDatabase
import com.edisiswanto.soccerteam.core.data.source.remote.RemoteDataSource
import com.edisiswanto.soccerteam.core.data.source.remote.network.ApiService
import com.edisiswanto.soccerteam.core.domain.repository.ITeamRepository
import com.edisiswanto.soccerteam.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<TeamDatabase>().teamDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            TeamDatabase::class.java, "Soccer.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/api/v1/json/2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITeamRepository> { TeamRepository(get(), get(), get()) }
}