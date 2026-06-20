package pe.isil.easyvet.features.home.data.repositories

import pe.isil.easyvet.features.home.data.remote.ProductService
import pe.isil.easyvet.features.home.domain.model.Product
import pe.isil.easyvet.features.home.domain.repositories.ProductRepository

class ProductRepositoryImpl(private val service: ProductService) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = service.getProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsResponseDto ->
                return productsResponseDto.products.map { dto ->
                    Product(
                        id = dto.id,
                        name = dto.title,
                        description = dto.description,
                        image = dto.image,
                        price = dto.price,
                        isFavorite = false
                    )
                }
            }
        }

        return emptyList()
    }
}