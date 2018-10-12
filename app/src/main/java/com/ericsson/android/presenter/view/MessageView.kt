package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.Message
import com.kotlin.base.presenter.view.BaseView

/*
    消息列表 视图回调
 */
interface MessageView : BaseView {

    //获取消息列表回调
    fun onGetMessageResult(result:MutableList<Message>?)
}
