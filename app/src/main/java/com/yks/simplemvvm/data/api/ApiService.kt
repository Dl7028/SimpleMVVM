package com.yks.simplemvvm.data.api

import com.yks.simplemvvm.base.BaseBean
import com.yks.simplemvvm.data.bean.HotKey
import retrofit2.http.GET

/**
 * @Description:
 * @Author:         Yu ki-r
 * @CreateDate:     2020/12/5 22:07
 */
interface ApiService {


    @GET(HOT_KEY)
    suspend fun getHotKey():BaseBean<HotKey>
}