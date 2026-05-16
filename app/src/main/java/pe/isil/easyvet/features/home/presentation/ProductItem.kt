package pe.isil.easyvet.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pe.isil.easyvet.features.home.domain.model.Product

@Composable
fun ProductItem(product: Product) {
    Card {
        Column {
            Text(text = product.name)
            Text(text = product.description)
            Text(text = "$ ${product.price}")
        }
    }

}