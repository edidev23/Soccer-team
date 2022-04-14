package com.edisiswanto.core.di

import androidx.room.Room
import com.edisiswanto.core.data.TeamRepository
import com.edisiswanto.core.data.source.local.LocalDataSource
import com.edisiswanto.core.data.source.local.room.TeamDatabase
import com.edisiswanto.core.data.source.remote.RemoteDataSource
import com.edisiswanto.core.data.source.remote.network.ApiService
import com.edisiswanto.core.domain.repository.ITeamRepository
import com.edisiswanto.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
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
        val passphrase: ByteArray = SQLiteDatabase.getBytes("edisiswanto".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            TeamDatabase::class.java, "Soccer.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "sni.cloudflaressl.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/Yl6IYMBnxrwtn9DWo32vSutvY3gRn56iEfWj5/66c88=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
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