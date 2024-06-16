package com.marcoantonio95.dailypulse.articles.di

import com.marcoantonio95.dailypulse.articles.ArticlesService
import com.marcoantonio95.dailypulse.articles.ArticlesUseCase
import com.marcoantonio95.dailypulse.articles.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
}