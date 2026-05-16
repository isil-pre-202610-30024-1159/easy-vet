package pe.isil.easyvet.features.home.presentation

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.isil.easyvet.R
import pe.isil.easyvet.core.ui.theme.AppTheme
import pe.isil.easyvet.features.home.domain.model.Product

@Composable
fun HomeScreen() {
    val products = listOf(
        Product(
            id = 1,
            name = "Royal Canin Maxi Puppy",
            description = "Dry food for large breed puppies. Supports bone growth and digestive health.",
            image = "https://i.imgur.com/WkZEOU6.png",
            price = 29.99
        ),
        Product(
            id = 2,
            name = "Eukanuba Active Adult",
            description = "Complete nutrition with high-quality proteins for active adult dogs.",
            image = "https://i.imgur.com/guSk1sh.png",
            price = 9.99
        ),
        Product(
            id = 3,
            name = "Whiskas Adult Chicken Flavor",
            description = "Crunchy kibbles with chicken flavor for adult cats. Rich in vitamins and minerals.",
            image = "https://i.imgur.com/dRC9dEB.png",
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
                        .shadow(4.dp, CircleShape)
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