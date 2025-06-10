package com.avlnv.booksappcompose.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avlnv.booksappcompose.data.RepositoryImpl
import com.avlnv.booksappcompose.domain.model.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

class BookListViewModel : ViewModel() {

    private val repository: Repository = RepositoryImpl() // TODO

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

}