package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import io.reactivex.observers.DisposableObserver

/*
    Rx订阅者默认实现
 */
open class BaseSubscriber<T>(val baseView:BaseView): DisposableObserver<T>() {

    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        if (e is BaseException){
            baseView.onError(e.msg)
        } else {
            baseView.onError(e.message!!)
        }
    }
}
