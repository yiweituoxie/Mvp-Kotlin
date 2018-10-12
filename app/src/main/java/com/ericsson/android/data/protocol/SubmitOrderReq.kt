package com.kotlin.order.data.protocol

import com.ericsson.android.data.protocol.Order

/*
    提交订单
 */
data class SubmitOrderReq(val order: Order)
