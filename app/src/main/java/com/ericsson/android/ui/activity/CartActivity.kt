package com.ericsson.android.ui.activity

import android.os.Bundle
import com.ericsson.android.R
import com.ericsson.android.R.layout.fragment_cart
import com.ericsson.android.ui.fragment.CartFragment
import com.kotlin.base.ui.activity.BaseActivity

/*
    购物车Activity
    只是Fragment一个壳
 */
class CartActivity:BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_cart)
        (fragment as CartFragment).setBackVisible(true)

    }
}
