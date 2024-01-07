package com.catnip.hotelier.di

import org.koin.core.module.Module
import org.koin.dsl.module

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
object AppModules {

    private val localModule = module {

    }

    private val networkModule = module {

    }

    private val dataSourceModule = module {

    }

    private val repositoryModule = module {

    }

    private val viewModelModule = module {

    }

    val modules: List<Module> = listOf(
        localModule,
        networkModule,
        dataSourceModule,
        repositoryModule,
        viewModelModule,
    )
}
