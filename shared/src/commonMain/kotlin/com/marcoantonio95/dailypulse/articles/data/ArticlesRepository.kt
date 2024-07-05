package com.marcoantonio95.dailypulse.articles

class ArticlesRepository(private val dataSource: ArticlesDataSource, private val service: ArticlesService) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.clearArticles()
            return fetchArticles()
        }

        val articlesDb = dataSource.getAllArticles()
        println("Got: ${articlesDb.size} articles from db")

        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }

        return articlesDb
    }

    suspend fun fetchArticles(): List<ArticleRaw> {
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticles(fetchedArticles)
        return fetchedArticles
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        dataSource.insertArticles(articles)
    }

    fun clearArticles() = dataSource.clearArticles()
}