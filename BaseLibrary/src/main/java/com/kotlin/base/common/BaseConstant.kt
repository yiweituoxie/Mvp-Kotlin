package com.kotlin.base.common

/*
    基础常量
 */
class BaseConstant{
    companion object {
//        //七牛服务地址
//        const val IMAGE_SERVER_ADDRESS = "http://osea2fxp7.bkt.clouddn.com/"
        //本地服务器地址
//        const val SERVER_ADDRESS = "http://10.28.14.168:8080"
        const val SERVER_ADDRESS = " https://www.easy-mock.com/mock/5ba49fce9d32ad37df3698c1/ericsson/"
        //SP表名
        const val TABLE_PREFS = "Kotlin_mall"
        //Token Key
        const val KEY_SP_TOKEN = "token"


        //搜索历史 本地存储
        const val SP_SEARCH_HISTORY = "search_history"
        //搜索商品类型
        const val KEY_SEARCH_GOODS_TYPE = "search_goods_type"
        //按分类搜索
        const  val SEARCH_GOODS_TYPE_CATEGORY = 0
        //按关键字搜索
        const  val SEARCH_GOODS_TYPE_KEYWORD = 1
        //商品分类ID
        const  val KEY_CATEGORY_ID = "category_id"
        //商品关键字
        const val KEY_GOODS_KEYWORD = "goods_keyword"
        //商品ID
        const  val KEY_GOODS_ID = "goods_id"
        //sku分隔标识
        const val SKU_SEPARATOR = ","
        //购物车数量
        const val SP_CART_SIZE = "cart_size"
    }
}
