package com.ericsson.android.presenter.view

import com.ericsson.android.data.protocol.Category
import com.kotlin.base.presenter.view.BaseView

/*
    商品分类 视图回调
 */
interface CategoryView : BaseView {

    //获取商品分类列表
    fun onGetCategoryResult(result: MutableList<Category>?)
}
