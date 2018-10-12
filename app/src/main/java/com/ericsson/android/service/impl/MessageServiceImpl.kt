package com.ericsson.android.service.impl


import com.ericsson.android.data.protocol.Message
import com.ericsson.android.data.respository.MessageRepository
import com.ericsson.android.service.MessageService
import com.kotlin.base.ext.convert
import io.reactivex.Observable
import javax.inject.Inject


/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
