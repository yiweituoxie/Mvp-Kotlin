package com.ericsson.android.injection.component

import com.ericsson.android.injection.module.CartModule
import com.ericsson.android.injection.module.GoodsModule
import com.ericsson.android.ui.activity.GoodsActivity
import com.ericsson.android.ui.fragment.GoodsDetailTabOneFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    商品Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsModule::class, CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}
