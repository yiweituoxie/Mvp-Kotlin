package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.Order
import com.kotlin.base.presenter.view.BaseView

/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}
