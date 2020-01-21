package com.crayonwriter.wootechdrinkwater

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WaterRecyclerViewAdapter:
    RecyclerView.Adapter<WaterRecyclerViewAdapter.MyViewHolder>() {

    private val waterModelList = mutableListOf<WaterEntries>()

    fun setWaterList(waterList: List<WaterEntries>) {
        waterModelList.clear()
        waterModelList.addAll(waterList)

        //Refresh the list and show the latest items
        notifyDataSetChanged()
    }
    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): WaterRecyclerViewAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fivedays_rowitem, parent, false) as TextView
        return MyViewHolder(textView)
    }

    // TODO
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text =
    }

    // TODO Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = WaterDao
}