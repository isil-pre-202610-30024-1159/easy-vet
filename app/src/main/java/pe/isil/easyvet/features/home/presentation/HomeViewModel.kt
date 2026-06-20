package pe.isil.easyvet.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pe.isil.easyvet.core.di.LocalModule.provideProductDao
import pe.isil.easyvet.core.di.RemoteModule.provideProductService
import pe.isil.easyvet.features.home.data.repositories.ProductRepositoryImpl
import pe.isil.easyvet.features.home.domain.repositories.ProductRepository

class HomeViewModel(
    private val repository: ProductRepository = ProductRepositoryImpl(
        service = provideProductService(),
        dao = provideProductDao()

    )
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> = _uiState

    private fun getProducts() {
        viewModelScope.launch {
            repository.getProducts().collect { products ->
                _uiState.update {
                    it.copy(products = products)
                }
            }

        }

    }

    private fun syncProducts() {
        _uiState.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            try {
                repository.syncProducts()
                _uiState.update {
                    it.copy(isLoading = false)
                }
            } catch (_: Exception){
                _uiState.update {
                    it.copy(isLoading = false, message = "Exception")
                }
            }
        }
    }

    init {
        getProducts()
        syncProducts()
    }

}