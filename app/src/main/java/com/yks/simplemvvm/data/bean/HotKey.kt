package com.yks.simplemvvm.data.bean

/**
 * @Description:
 * @Author:         Yu ki-r
 * @CreateDate:     2020/12/5 22:11
 */
 class HotKey : ArrayList<HotKeyItem>()

data class HotKeyItem(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)