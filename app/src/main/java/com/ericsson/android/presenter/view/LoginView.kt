package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.UserInfo
import com.kotlin.base.presenter.view.BaseView

/*
    用户登录 视图回调
 */
interface LoginView : BaseView {

    fun onLoginResult(result: UserInfo)
}
