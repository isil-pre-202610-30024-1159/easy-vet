package pe.isil.easyvet.features.home.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val price: Double,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean
)
