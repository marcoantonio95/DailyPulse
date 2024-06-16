package com.marcoantonio95.dailypulse.di

import com.marcoantonio95.dailypulse.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)