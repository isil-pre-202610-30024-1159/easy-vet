package pe.isil.easyvet.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.isil.easyvet.R
import pe.isil.easyvet.core.ui.theme.AppTheme
import pe.isil.easyvet.home.domain.model.Product

@Composable
fun HomeScreen() {
    val products = listOf(
        Product(
            id = 1,
            name = "Dog Food",
            description = "High quality dog food",
            image = "dog_food.png",
            price = 29.99
        ),
        Product(
            id = 2,
            name = "Cat Toy",
            description = "Fun toy for cats",
            image = "cat_toy.png",
            price = 9.99
        ),
        Product(
            id = 3,
            name = "Bird Cage",
            description = "Spacious cage for birds",
            image = "bird_cage.png",
            price = 49.99
        )
    )
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Column {
                    Text("Miraflores", fontWeight = FontWeight.Bold)
                    Text("Home")
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onPrimary)

                ) {
                    Icon(
                        painter = painterResource(R.drawable.visibility),
                        contentDescription = null,

                        )
                }
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(MaterialTheme.colorScheme.onPrimary),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.visibility_off),
                        contentDescription = null
                    )
                },
                placeholder = {
                    Text("Search")
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Christmas offer")
                    Text("25% OFF")
                    Button(
                        onClick = {}
                    ) {
                        Text("Shop now")
                    }
                }

                Image(
                    painter = painterResource(R.drawable.dog),
                    contentDescription = null,
                    modifier = Modifier.height(240.dp)
                )
            }

            ProductList(products)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}