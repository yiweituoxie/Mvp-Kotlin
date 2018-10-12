package com.ericsson.android.injection.component

import com.ericsson.android.injection.module.OrderModule
import com.ericsson.android.ui.activity.OrderConfirmActivity
import com.ericsson.android.ui.activity.OrderDetailActivity
import com.ericsson.android.ui.fragment.OrderFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(fragment: OrderFragment)

    fun inject(activity: OrderDetailActivity)
}
