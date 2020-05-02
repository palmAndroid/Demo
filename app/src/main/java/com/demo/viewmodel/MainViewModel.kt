package com.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.demo.model.TempData
import com.demo.service.WebRepository

class MainViewModel : ViewModel() {


   public fun getTempForState() : MutableLiveData<List<TempData>>? {
        return WebRepository()?.getTempretureList()
    }
}