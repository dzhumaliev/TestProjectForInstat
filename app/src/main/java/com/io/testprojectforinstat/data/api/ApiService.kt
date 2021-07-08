package com.io.testprojectforinstat.data.api

import com.io.testprojectforinstat.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiService {
    companion object {

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {

                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)

                val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
                    .connectTimeout(30L, TimeUnit.SECONDS)
                    .readTimeout(30L, TimeUnit.SECONDS)
                    .writeTimeout(30L, TimeUnit.SECONDS)

                httpClient.addInterceptor(logging)

                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .client(httpClient.build())
                        .build()
                }
                return retrofit!!
            }
    }
}