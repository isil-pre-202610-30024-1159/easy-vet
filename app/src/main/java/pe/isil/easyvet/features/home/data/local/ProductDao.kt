package pe.isil.easyvet.features.home.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getProducts(): Flow<List<ProductEntity>>

    @Insert
    suspend fun insertProducts(products: List<ProductEntity>)

    @Query("delete from products")
    suspend fun deleteAllProducts()
}