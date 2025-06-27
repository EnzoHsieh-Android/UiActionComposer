package com.enzo.uiactioncomposer.core.di

import com.enzo.uiactioncomposer.data.repository.NewsRepositoryImpl
import com.enzo.uiactioncomposer.data.repository.PostRepositoryImpl
import com.enzo.uiactioncomposer.domain.repository.NewsRepository
import com.enzo.uiactioncomposer.domain.repository.PostRepository
import com.enzo.uiactioncomposer.ui.viewmodel.HomeViewModel
import com.enzo.uiactioncomposer.ui.viewmodel.PostListViewModel
import  org.koin.core.module.dsl.*
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::PostRepositoryImpl) { bind<PostRepository>() }
    singleOf(::NewsRepositoryImpl) { bind<NewsRepository>() }
}

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::PostListViewModel)
}
