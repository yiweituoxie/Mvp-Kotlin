package com.ericsson.android.data.api

import com.ericsson.android.data.protocol.*
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/*
    用户相关 接口
 */
interface UserApi{

    /*
        用户注册
     */
    @POST("user/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>

    /*
        用户登录
     */
    @POST("user/login")
    fun login(@Body req:LoginReq):Observable<BaseResp<UserInfo>>

    /*
        忘记密码
     */
    @POST("user/forgetPwd")
    fun forgetPwd(@Body req: ForgetPwdReq):Observable<BaseResp<String>>

    /*
        重置密码
     */
    @POST("user/resetPwd")
    fun resetPwd(@Body req: ResetPwdReq):Observable<BaseResp<String>>

    /*
        编辑用户资料
     */
    @POST("user/editUser")
    fun editUser(@Body req:EditUserReq):Observable<BaseResp<UserInfo>>
}
