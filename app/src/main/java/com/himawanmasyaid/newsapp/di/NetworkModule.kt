package com.himawanmasyaid.newsapp.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.himawanmasyaid.newsapp.services.NewsService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okio.Timeout
import org.koin.android.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {


    single { GsonBuilder().setLenient().create() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

    // services
    single { providesNewsServices(get()) }


}

private const val GENERAL_TIMEOUT: Long = 20 * 1000

private fun provideOkHttpClient() : OkHttpClient {

    val builder = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)

    return builder.build()

}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
): Retrofit {

    var gson = GsonBuilder()
        .setLenient()
        .create()

    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://newsapi.org/v2/")
        .client(okHttpClient)
        .build()
}

private fun providesNewsServices(retrofit: Retrofit): NewsService {
    return retrofit.create(NewsService::class.java)
}




