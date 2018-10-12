package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.Goods
import com.kotlin.base.presenter.view.BaseView

/*
    商品列表 视图回调
 */
interface GoodsListView : BaseView {

    //获取商品列表
    fun onGetGoodsListResult(result: MutableList<Goods>?)
}
