package com.ericsson.android.presenter


import android.util.Log
import com.ericsson.android.data.protocol.UserInfo
import com.ericsson.android.presenter.view.LoginView
import com.ericsson.android.service.UserService
import com.kotlin.base.ext.excute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseSubscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
    登录界面 Presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    /*
        登录
     */
    fun login(mobile: String, pwd: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd).excute(object : BaseSubscriber<UserInfo>(mView) {
            override fun onNext(t: UserInfo) {
                mView.onLoginResult(t)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
            }
        })
    }

}
