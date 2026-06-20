package pe.isil.easyvet.core.di

import pe.isil.easyvet.features.home.data.remote.ProductService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteModule {

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://petapi-591531460223.us-central1.run.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideProductService(retrofit: Retrofit = provideRetrofit()): ProductService {
        return retrofit.create(ProductService::class.java)
    }
}