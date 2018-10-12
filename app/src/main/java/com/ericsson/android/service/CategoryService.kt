package com.ericsson.android.service

import com.ericsson.android.data.protocol.Category
import io.reactivex.Observable

/*
    商品分类 业务层 接口
 */
interface CategoryService {

    /*
        获取分类
     */
    fun getCategory(parentId:Int): Observable<MutableList<Category>?>
}
