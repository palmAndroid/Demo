package com.demo.service

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.demo.model.TempData
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


class WebRepository {

    lateinit var observable : Observable<TempData>
    var compositeDisposable : CompositeDisposable = CompositeDisposable()
     var apiService : ServiceCall
    var tempList : MutableLiveData<List<TempData>>? = MutableLiveData<List<TempData>>()
init{
      apiService = RetrofitInstance().setUpClient()?.create(ServiceCall::class.java)
}


    fun getTempretureList() : MutableLiveData<List<TempData>>? {

        var temp_list  = ArrayList<TempData>()
        if (apiService!=null){
            observable = apiService.getTempList(
                "37.3855",
                "-122.088"
            )

            compositeDisposable.add(observable.
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(object : DisposableObserver<TempData>(){
                    override fun onNext(list: TempData) {
                        temp_list.add(list)
                    }
                    override fun onError(e: Throwable) {
                   Log.d("TAG","Error:"+e)
                    }
                    override fun onComplete() {
                        tempList?.postValue(temp_list)
                    }
                }))
        }
        return tempList
    }

}