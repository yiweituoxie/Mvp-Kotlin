package com.kotlin.base.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.R
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/*
    Fragment基类，业务相关
 */
abstract open class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initActivityInjection()
        injectComponent()

        //初始加载框
        mLoadingDialog = ProgressLoading.create(context!!)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    /*
        Dagger注册
     */
    protected abstract fun injectComponent()

    /*
        初始化Activity级别Component
     */
    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder().appComponent((activity?.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
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
        错误信息提示，默认实现
     */
    override fun onError(text:String) {
        toast(text)
    }

    protected var mSnackBar: Snackbar? = null
    fun snack(view: View, text: String, actionTextId: Int = 0, onClickListener: View.OnClickListener? = null) {
        if (!userVisibleHint) return
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
