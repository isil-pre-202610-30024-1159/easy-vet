package pe.isil.easyvet.features.home.data

import com.google.gson.annotations.SerializedName

data class ProductsResponseDto(
    val count: Int,
    @SerializedName("results")
    val products: List<ProductDto>
)