package com.avlnv.feature_booklist.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory
import com.avlnv.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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

    companion object {

        val Factory = viewModelFactory {
            addInitializer(BookListViewModel::class) {
                val repository: Repository = requireNotNull(get(ARG_REPOSITORY)) {
                    "Repository is not passed in CreationExtra"
                }
                BookListViewModel(repository)
            }
        }

        val ARG_REPOSITORY = object : CreationExtras.Key<Repository> {}
    }

}