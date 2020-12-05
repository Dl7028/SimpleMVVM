package com.yks.simplemvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.yks.simplemvvm.base.ResultData
import com.yks.simplemvvm.data.RemoteDataSource
import com.yks.simplemvvm.util.ListModel
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @Description:
 * @Author:         Yu ki-r
 * @CreateDate:     2020/12/5 22:31
 */
@Singleton
class MainRepository @Inject constructor(
    private val  dataSource: RemoteDataSource
) {

    suspend fun getHotKeys(listModel: MutableLiveData<ListModel<Int>>){
        listModel.postValue(ListModel(showLoading = true))
        val getHotKeyResult = dataSource.getHotKey()
        if (getHotKeyResult is ResultData.Success) {   //成功
            listModel.postValue(ListModel(showLoading = false, showEnd = true))
        } else if (getHotKeyResult is ResultData.ErrorMessage) { //失败
            listModel.postValue(ListModel(showLoading = false, showError = getHotKeyResult.message))
        }
    }
}