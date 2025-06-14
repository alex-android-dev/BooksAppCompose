package com.avlnv.feature_booklist.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.avlnv.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class BookListViewModel(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow<ScreenStateBookList>(ScreenStateBookList.Initial)
    val state = _state.asStateFlow()

    init {
        getWantToReadBooks()
    }

    private fun getWantToReadBooks() = viewModelScope.launch {
        val result = repository.getWantToReadBooks()

        _state.value = result.fold(
            onSuccess = {
                ScreenStateBookList.Success(it)
            },
            onFailure = {
                ScreenStateBookList.Error(it.message ?: "Unknown Throwable")
            }
        )
    }

    object Factory : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return create(modelClass.kotlin, CreationExtras.Empty)
        }

        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return create(modelClass.kotlin, extras)
        }

        override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
            require(modelClass == BookListViewModel::class) {
                "BookListViewModel can only be create by BookListViewModel.Factory"
            }

            val repository: Repository = requireNotNull(extras[ARG_REPOSITORY_KEY]) {
                "Repository is not passed in CreationExtra"
            }

            return BookListViewModel(repository) as T
        }

        val ARG_REPOSITORY_KEY = object : CreationExtras.Key<Repository> {}
    }

    companion object {

    }

}