package com.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.adapter.MainListAdapter
import com.demo.model.TempData
import com.demo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        var viewModel = ViewModelProviders.of(this).get<MainViewModel>(MainViewModel::class.java)
        viewModel.getTempForState()?.observe(this, Observer<List<TempData>>() {

        })

        viewModel.getTempForState()?.observe(
            this, Observer<List<TempData>> { tempList ->
                Log.d("TAG", "List->" + tempList.size)
                inIt(tempList)
            })

    }

    private fun inIt(tempList: List<TempData>) {
        recycler_view.adapter = MainListAdapter(tempList)
    }
}