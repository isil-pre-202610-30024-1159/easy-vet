package pe.isil.easyvet.features.home.domain.repositories

import kotlinx.coroutines.flow.Flow
import pe.isil.easyvet.features.home.domain.model.Product

interface ProductRepository {

   suspend fun getProducts(): Flow<List<Product>>
   suspend fun syncProducts()

}