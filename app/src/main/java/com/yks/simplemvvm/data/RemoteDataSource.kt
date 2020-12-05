package com.yks.simplemvvm.data


import com.yks.simplemvvm.base.ResultData
import com.yks.simplemvvm.data.bean.HotKey
import com.yks.simplemvvm.data.http.RetrofitClient
import com.yks.simplemvvm.util.safeApiCall
import timber.log.Timber
import javax.inject.Inject

/**
 * @Description:    数据来源
 * @Author:         Yu ki-r
 * @CreateDate:     2020/11/8 16:33
 */

class RemoteDataSource@Inject constructor() {
    private val apiImpl = RetrofitClient.getInStance().service



    //封装异常
    suspend fun getHotKey() = safeApiCall { toGetHotKeys() }

    /**
     *处理返回的数据
     *
     * @return
     */
    private suspend fun toGetHotKeys():ResultData<HotKey>{
        val getResult =apiImpl.getHotKey()
        if (getResult.errorCode==0){
            return ResultData.Success(getResult.data)
        }
        return ResultData.ErrorMessage(getResult.errorMsg)
    }

}
