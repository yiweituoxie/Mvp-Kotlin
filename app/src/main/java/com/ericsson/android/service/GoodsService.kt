package com.ericsson.android.service

import com.ericsson.android.data.protocol.Goods
import io.reactivex.Observable

/*
    商品 业务层 接口
 */
interface GoodsService {

    /*
        获取商品列表
     */
    fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?>

    /*
        根据关键字查询商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?>

    /*
        获取商品详情
     */
    fun getGoodsDetail(goodsId: Int): Observable<Goods>
}
