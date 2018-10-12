package com.ericsson.android.injection.module

import com.ericsson.android.service.UserService
import com.ericsson.android.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/*
    用户模块Module
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }

}

