package pe.isil.easyvet.features.home.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("api/products")
    suspend fun getProducts(): Response<ProductsResponseDto>
}