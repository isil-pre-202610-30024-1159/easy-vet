package pe.isil.easyvet.core.di

import android.content.Context
import androidx.room.Room
import pe.isil.easyvet.MyApplication
import pe.isil.easyvet.features.home.data.local.AppDatabase
import pe.isil.easyvet.features.home.data.local.ProductDao

object LocalModule {

    fun provideAppDatabase(context: Context = MyApplication.instance): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "easyvet-db" ).build()
    }

    fun provideProductDao(database: AppDatabase = provideAppDatabase()): ProductDao {
        return database.productDao()
    }
}