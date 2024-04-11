package com.marcoantonio95.dailypulse.articles

import com.marcoantonio95.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticleState> = MutableStateFlow(ArticleState(loading = true))

    val articleState: StateFlow<ArticleState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticles = fetchArticles()

            delay(500)

            _articlesState.emit(ArticleState(articles = fetchedArticles))
        }
    }

    private suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf<Article>(
        Article(
            title = "Our Favorite Cat Toys, Litter Boxes, and Other Feline Supplies",
            desc = "We've tried dozens of litter boxes, pet cameras, and fancy cat furniture. These are our favorites.",
            date = "04-11-2024",
            imageUrl = "https://media.wired.com/photos/6616c08b630a7060d3bd0dfa/master/w_1920,c_limit/Best-Cat-Toys-Gear-GettyImages-1456903581.jpg"
            ),
        Article(
            title = "KitchenAid Semi Automatic Espresso Machine",
            desc = "KitchenAid’s new compact espresso machine is thoughtfully designed and reliable—after you tune it a bit.",
            date = "04-08-2024",
            imageUrl = "https://media.wired.com/photos/66134a7b8a3d3113f93471d2/master/w_1920,c_limit/KitchenAid-Semi-Auto-Espresso-Machine-Abstract-Background-SOURCE-KitchenAid.jpg"
        ),
        Article(
            title = "BYD Atto 3",
            desc = "Chinese EV giant BYD has arrived in Europe with the Atto 3—an acceptable and good-value alternative to better-known rivals. But beyond the funky interior there’s little to get truly excited about.",
            date = "04-08-2024",
            imageUrl = "https://media.wired.com/photos/661036fde2878b8140cb8308/master/w_1920,c_limit/BYD_ATTO3_A22002.jpg"
        )
    )
}