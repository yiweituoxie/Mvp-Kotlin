package com.ericsson.android.service.impl

import com.ericsson.android.data.protocol.Category
import com.ericsson.android.data.respository.CategoryRepository
import com.ericsson.android.service.CategoryService
import com.kotlin.base.ext.convert
import io.reactivex.Observable
import javax.inject.Inject

/*
    商品分类 业务层 实现类
 */
class CategoryServiceImpl @Inject constructor(): CategoryService {
    @Inject
    lateinit var repository: CategoryRepository

    /*
        获取商品分类列表
     */
    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {
        return repository.getCategory(parentId).convert()
    }


}
