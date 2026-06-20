package pe.isil.easyvet.features.home.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pe.isil.easyvet.features.home.data.local.ProductDao
import pe.isil.easyvet.features.home.data.local.ProductEntity
import pe.isil.easyvet.features.home.data.remote.ProductService
import pe.isil.easyvet.features.home.domain.model.Product
import pe.isil.easyvet.features.home.domain.repositories.ProductRepository

class ProductRepositoryImpl(private val service: ProductService, private val dao: ProductDao) :
    ProductRepository {
    override suspend fun getProducts(): Flow<List<Product>> {
        return dao.getProducts().map { entities ->
            entities.map { entity ->
                Product(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description,
                    image = entity.image,
                    price = entity.price,
                    isFavorite = entity.isFavorite
                )
            }
        }
    }

    override suspend fun syncProducts() {
        val response = service.getProducts()

        if (response.isSuccessful){
            response.body()?.let { productsResponseDto ->
                val entities = productsResponseDto.products.map { dto ->
                    ProductEntity(
                        id = dto.id,
                        name = dto.title,
                        description = dto.description,
                        image = dto.image,
                        price = dto.price,
                        isFavorite = false
                    )
                }
                dao.deleteAllProducts()
                dao.insertProducts(entities)
            }
        }
    }


}