package com.marcoantonio95.dailypulse.articles

import com.marcoantonio95.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> = database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearArticles() = database.dailyPulseDatabaseQueries.removeAllArticles()


    private fun insertArticle(article: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            article.title,
            article.desc,
            article.date,
            article.imageUrl
        )
    }

    private fun mapToArticleRaw(title: String, description: String?, date: String, imageUrl: String?): ArticleRaw = ArticleRaw(title, description, date, imageUrl)
}