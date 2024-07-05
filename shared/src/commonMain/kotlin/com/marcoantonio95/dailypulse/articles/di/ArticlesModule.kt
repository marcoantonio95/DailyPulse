package com.marcoantonio95.dailypulse.articles.di

import com.marcoantonio95.dailypulse.articles.ArticlesService
import com.marcoantonio95.dailypulse.articles.ArticlesUseCase
import com.marcoantonio95.dailypulse.articles.ArticlesViewModel
import com.marcoantonio95.dailypulse.articles.ArticlesDataSource
import com.marcoantonio95.dailypulse.articles.ArticlesRepository
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}