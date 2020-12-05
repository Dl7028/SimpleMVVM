package com.yks.simplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import android.widget.Toast
import com.yks.simplemvvm.R
import com.yks.simplemvvm.base.BaseActivity
import com.yks.simplemvvm.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun setLayoutId(): Int  = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.getHotKey()
    }

    override fun startObserve() {
        viewModel.mGeyHotKeyStatus.observe(this){
            if (it.showLoading) showProgressDialog(R.string.loading) else dismissProgressDialog()  //显示/隐藏 进度条
            if (it.showEnd) {
               Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show()  //请求成功
            }
            it.showError?.let { errorMsg ->        //请求失败
                Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show()
            }

        }
    }

}