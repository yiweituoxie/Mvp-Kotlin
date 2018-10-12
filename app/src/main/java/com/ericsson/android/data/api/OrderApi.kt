package com.ericsson.android.data.api

import com.ericsson.android.data.protocol.*
import retrofit2.http.Body
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.order.data.protocol.*
import io.reactivex.Observable
import retrofit2.http.POST


/*
    订单 接口
 */
interface OrderApi {

    /*
        取消订单
     */
    @POST("order/cancel")
    fun cancelOrder(@Body req: CancelOrderReq): Observable<BaseResp<String>>

    /*
        确认订单
     */
    @POST("order/confirm")
    fun confirmOrder(@Body req: ConfirmOrderReq): Observable<BaseResp<String>>

    /*
        根据ID获取订单
     */
    @POST("order/getOrderById")
    fun getOrderById(@Body req: GetOrderByIdReq): Observable<BaseResp<Order>>

    /*
        根据订单状态查询查询订单列表
     */
    @POST("order/getOrderList")
    fun getOrderList(@Body req: GetOrderListReq): Observable<BaseResp<MutableList<Order>?>>

    /*
        提交订单
     */
    @POST("order/submitOrder")
    fun submitOrder(@Body req: SubmitOrderReq): Observable<BaseResp<String>>

}
