package pe.isil.easyvet.home.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import pe.isil.easyvet.home.domain.model.Product

@Composable
fun ProductList(products: List<Product>) {

    LazyColumn {

        items(products) { product ->
            ProductItem(product)
        }
    }

}