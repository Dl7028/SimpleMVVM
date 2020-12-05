package com.yks.simplemvvm.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yks.simplemvvm.data.repository.MainRepository
import com.yks.simplemvvm.util.ListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

/**
 * @Description:
 * @Author:         Yu ki-r
 * @CreateDate:     2020/12/5 22:25
 */
class MainViewModel@ViewModelInject constructor(
    private val mainRepository: MainRepository
): ViewModel(){
    val mGeyHotKeyStatus = MutableLiveData<ListModel<Int>>()

    fun getHotKey(){
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getHotKeys(
                mGeyHotKeyStatus
            )

        }
    }
}