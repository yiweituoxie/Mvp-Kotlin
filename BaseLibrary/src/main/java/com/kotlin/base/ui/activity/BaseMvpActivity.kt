package com.kotlin.base.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import com.kotlin.base.R
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/*
    Activity基类，业务相关
 */
abstract open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    //Presenter泛型，Dagger注入
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent:ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(this)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始Activity Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .build()

    }

    /*
        显示加载框，默认实现
     */
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    /*
        隐藏加载框，默认实现
     */
    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    /*
        错误信息提示，默认实现1
     */
    override fun onError(text:String) {
        toast(text)
    }

    /*
        错误信息提示，默认实现2
     */
    protected var mSnackBar: Snackbar? = null
    fun snack(view: View, text: String, actionTextId: Int = 0, onClickListener: View.OnClickListener? = null) {
        val ssb = SpannableStringBuilder()
                .append(text)
        ssb.setSpan(
                ForegroundColorSpan(Color.WHITE),
                0,
                text.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        mSnackBar = Snackbar.make(view, ssb, Snackbar.LENGTH_INDEFINITE)
        mSnackBar?.view?.setBackgroundResource(R.color.common_red)
        if (actionTextId != 0) {
            mSnackBar?.setAction(actionTextId, onClickListener)
            mSnackBar?.setActionTextColor(Color.WHITE)
        }
        mSnackBar?.show()
    }

    fun dismissSnack() {
        if (mSnackBar?.isShown == true) {
            mSnackBar?.dismiss()
        }
    }
}
