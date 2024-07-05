package com.marcoantonio95.dailypulse.articles

import com.marcoantonio95.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel(private val useCase: ArticlesUseCase) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState(loading = true))

    val articleState: StateFlow<ArticleState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticleState(loading = true, articles = _articlesState.value.articles))

            val fetchedArticles = useCase.getArticles(forceFetch)

            _articlesState.emit(ArticleState(articles = fetchedArticles))
        }
    }

}