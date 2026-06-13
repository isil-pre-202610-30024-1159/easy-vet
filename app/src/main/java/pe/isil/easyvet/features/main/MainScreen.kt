package pe.isil.easyvet.features.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.isil.easyvet.core.ui.icons.favoriteBorder
import pe.isil.easyvet.core.ui.icons.homeBorder
import pe.isil.easyvet.core.ui.theme.AppTheme
import pe.isil.easyvet.features.home.domain.model.Product
import pe.isil.easyvet.features.home.presentation.HomeScreen
import pe.isil.easyvet.features.home.presentation.ProductDetail

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    var selectedProduct by remember {
        mutableStateOf<Product?>(null)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    label = { Text("Home") },
                    icon = {
                        Icon(homeBorder, contentDescription = null)
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    label = { Text("Favorites") },
                    icon = {
                        Icon(favoriteBorder, contentDescription = null)
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                HomeScreen { product ->
                    selectedProduct = product
                    navController.navigate("product_detail")
                }
            }

            composable("product_detail") {
                selectedProduct?.let { product ->
                    ProductDetail(product = product)
                }
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AppTheme {
        MainScreen()
    }
}