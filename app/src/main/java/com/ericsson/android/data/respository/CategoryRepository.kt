package com.ericsson.android.data.respository

import com.ericsson.android.data.api.CategoryApi
import com.ericsson.android.data.protocol.Category
import com.ericsson.android.data.protocol.GetCategoryReq
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import javax.inject.Inject

/*
    商品分类 数据层
 */
class CategoryRepository @Inject constructor(){
    /*
        获取商品分类
     */
    fun getCategory(parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }

}
