package com.ericsson.android.injection.component


import com.ericsson.android.injection.module.MessageModule
import com.ericsson.android.ui.fragment.MessageFragment
import com.kotlin.base.injection.PerComponentScope
import com.kotlin.base.injection.component.ActivityComponent
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(MessageModule::class))
interface MessageComponent{
    fun inject(fragment: MessageFragment)
}
