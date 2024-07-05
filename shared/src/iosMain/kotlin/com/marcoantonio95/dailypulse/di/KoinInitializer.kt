package com.marcoantonio95.dailypulse.di

import com.marcoantonio95.dailypulse.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

public class ArticlesInjector: KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}