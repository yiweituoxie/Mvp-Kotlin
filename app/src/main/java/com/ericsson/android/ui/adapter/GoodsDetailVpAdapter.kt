package com.ericsson.android.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.ericsson.android.ui.fragment.GoodsDetailTabOneFragment
import com.ericsson.android.ui.fragment.GoodsDetailTabTwoFragment

/*
    商品详情ViewPager Adapter
 */
class GoodsDetailVpAdapter(fm:FragmentManager,context:Context)
    :FragmentPagerAdapter(fm) {

    private val titles = arrayOf("商品","详情")

    override fun getItem(position: Int): Fragment {
        return if (position == 0){
            GoodsDetailTabOneFragment()
        }else{
            GoodsDetailTabTwoFragment()
        }
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}
