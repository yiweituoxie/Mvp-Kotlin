package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.CartGoods
import com.kotlin.base.presenter.view.BaseView

/*
    购物车页面 视图回调
 */
interface CartListView : BaseView {

    //获取购物车列表
    fun onGetCartListResult(result: MutableList<CartGoods>?)
    //删除购物车
    fun onDeleteCartListResult(result: Boolean)
    //提交购物车
    fun onSubmitCartListResult(result: Int)
}
