package com.example.koin.confs


import com.example.restApis.daos.UserInfoFacade
import com.example.restApis.daos.UserInfoImpl
import com.example.restApis.models.UserInfo
import com.example.restApis.repositories.IUserRepository
import com.example.restApis.repositories.UserRepository
import com.example.restApis.services.UserService
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val appModule = module {
    single {
        UserRepository(get()) as IUserRepository
    }
    single {
        UserService(get())
    }
}

val modelModules = module {
    factoryOf(::UserInfo)
}

val daoModules = module {
    single {
        UserInfoImpl() as UserInfoFacade
    }
}