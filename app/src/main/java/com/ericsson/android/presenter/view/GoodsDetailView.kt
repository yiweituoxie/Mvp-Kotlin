package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.Goods
import com.kotlin.base.presenter.view.BaseView

/*
    商品详情 视图回调
 */
interface GoodsDetailView : BaseView {

    //获取商品详情
    fun onGetGoodsDetailResult(result: Goods)
    //加入购物车
    fun onAddCartResult(result: Int)
}
