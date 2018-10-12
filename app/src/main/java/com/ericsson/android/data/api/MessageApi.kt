package com.ericsson.android.data.api

import com.ericsson.android.data.protocol.Message
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import retrofit2.http.POST

/*
    消息 接口
 */
interface MessageApi {

    /*
        获取消息列表
     */
    @POST("msg/getList")
    fun getMessageList(): Observable<BaseResp<MutableList<Message>?>>

}
