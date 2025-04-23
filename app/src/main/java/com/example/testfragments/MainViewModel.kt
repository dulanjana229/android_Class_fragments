package com.example.testfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val _userData = MutableLiveData<User>()
    val userData:LiveData<User> = _userData

    private val _userListData = MutableLiveData<List<User>>()
    val userListData:LiveData<List<User>> = _userListData

    fun setDate(user: User){
        _userData.value = user
    }

    fun getData(){
        var user = User("Dulanjana", 22, "Colombo", "dulanjana@gmail.com")
        var userList = listOf(user)
        _userListData.postValue(userList)
    }
}