package com.example.exobe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.services_layout.view.*


class RecyclerServicesAdapter(val context: Context, val arrServices: ArrayList<RecyclerModel>) : RecyclerView.Adapter<RecyclerServicesAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtServiceName = itemView.tv_ServiceName
        val imgServices = itemView.iv_service
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.services_layout, parent, false))
    }


    override fun getItemCount(): Int {
        return arrServices.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtServiceName.text = arrServices[position].name
        holder.imgServices.setImageResource(arrServices[position].img)

    }

}