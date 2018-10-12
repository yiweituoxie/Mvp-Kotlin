package com.ericsson.android.data.api

import com.ericsson.android.data.protocol.Category
import com.ericsson.android.data.protocol.GetCategoryReq
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/*
    商品分类接口
 */
interface CategoryApi {
    /*
        获取商品分类列表
     */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}
