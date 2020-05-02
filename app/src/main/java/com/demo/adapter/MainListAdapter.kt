package com.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.demo.R
import com.demo.model.TempData
import kotlinx.android.synthetic.main.row_layout.view.*

class MainListAdapter(var list : List<TempData>) : RecyclerView.Adapter<MainListAdapter.MainHolder>() {

    class MainHolder (view: View) : RecyclerView.ViewHolder(view){
        var textCity : TextView = view.textCity
        var textTemp : TextView = view.textTemp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return  MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textCity.text = list.get(position).timezone
        holder.textTemp.text = list.get(position).currently.temperature.toString()
    }

}