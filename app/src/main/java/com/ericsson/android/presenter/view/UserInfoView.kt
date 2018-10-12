package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.UserInfo
import com.kotlin.base.presenter.view.BaseView

/*
    编辑用户资料 视图回调
 */
interface UserInfoView : BaseView {



    /*
        编辑用户资料回调
     */
    fun onEditUserResult(result: UserInfo)
}
