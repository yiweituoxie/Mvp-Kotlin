package com.ericsson.android.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.ericsson.android.R
import com.ericsson.android.data.protocol.Message
import com.ericsson.android.injection.component.DaggerMessageComponent
import com.ericsson.android.injection.module.MessageModule
import com.ericsson.android.presenter.MessagePresenter
import com.ericsson.android.presenter.view.MessageView
import com.ericsson.android.ui.adapter.MessageAdapter
import com.kennyc.view.MultiStateView
import com.kotlin.base.ext.startLoading
import com.kotlin.base.ui.fragment.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_message.*

/*
    消息列表Fragment
 */
class MessageFragment:BaseMvpFragment<MessagePresenter>(), MessageView {

    private lateinit var mAdapter: MessageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_message,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    /*
        初始化视图
     */
    private fun initView() {
        mMessageRv.layoutManager = LinearLayoutManager(context)
        mAdapter = MessageAdapter(context!!)
        mMessageRv.adapter = mAdapter
        mLayoutSwipe.setOnRefreshListener {
            loadData()
        }
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    /*
        加载数据
     */
    private fun loadData() {
        mMultiStateView.startLoading()
        mPresenter.getMessageList()
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerMessageComponent.builder().activityComponent(mActivityComponent).messageModule(MessageModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        获取消息后回调
     */
    override fun onGetMessageResult(result: MutableList<Message>?) {
        mLayoutSwipe.isRefreshing = false
        if (result != null && result.size > 0){
            mAdapter.setData(result)
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT
        }else{
            //数据为空
            mMultiStateView.viewState = MultiStateView.VIEW_STATE_EMPTY
        }
    }

    /*
        监听Fragment隐藏或显示
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden){
        }
    }
}
