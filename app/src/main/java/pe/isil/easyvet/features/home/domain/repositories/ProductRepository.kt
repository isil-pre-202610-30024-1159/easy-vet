package pe.isil.easyvet.features.home.domain.repositories

import pe.isil.easyvet.features.home.domain.model.Product

interface ProductRepository {

    fun getProducts(): List<Product>

}