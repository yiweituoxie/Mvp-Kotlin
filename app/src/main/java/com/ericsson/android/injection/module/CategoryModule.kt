package com.ericsson.android.injection.module

import com.ericsson.android.service.CategoryService
import com.ericsson.android.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/*
    商品分类Module
 */
@Module
class CategoryModule {

    @Provides
    fun provideCategoryService(categoryService: CategoryServiceImpl): CategoryService {
        return categoryService
    }

}
