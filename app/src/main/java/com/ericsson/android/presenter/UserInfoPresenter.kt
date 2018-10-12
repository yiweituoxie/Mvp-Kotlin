package com.ericsson.android.presenter

import com.ericsson.android.data.protocol.UserInfo
import com.ericsson.android.presenter.view.UserInfoView
import com.ericsson.android.service.UserService
import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import javax.inject.Inject

/*
    编辑用户资料Presenter
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {

    @Inject
    lateinit var userService: UserService



    fun getUploadToken(){
        if (!checkNetWork())
            return

        mView.showLoading()
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String){
        if (!checkNetWork())
            return

        mView.showLoading()
        userService.editUser(userIcon,userName,userGender,userSign).excute(object :BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                mView.onEditUserResult(t)
            }
        })
    }

}
