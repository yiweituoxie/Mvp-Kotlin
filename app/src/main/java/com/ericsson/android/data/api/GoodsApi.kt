package com.ericsson.android.data.api

import com.ericsson.android.data.protocol.GetGoodsDetailReq
import com.ericsson.android.data.protocol.GetGoodsListByKeywordReq
import com.ericsson.android.data.protocol.GetGoodsListReq
import com.ericsson.android.data.protocol.Goods
import com.kotlin.base.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import io.reactivex.Observable

/*
    商品接口
 */
interface GoodsApi {
    /*
        获取商品列表
     */
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品列表
     */
    @POST("goods/getGoodsListByKeyword")
    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品详情
     */
    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Observable<BaseResp<Goods>>
}
