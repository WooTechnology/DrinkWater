package com.crayonwriter.wootechdrinkwater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fivedays_rowitem.view.*

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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fivedays_rowitem, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val waterEntry = waterModelList[position]

        holder.numberOfGlassesTextView.text = waterEntry.glasses
        holder.dateTextView.text = waterEntry.date
//        holder.dayOfTheWeekTextView.text = getDayOfWeekFromDate(waterEntry.date)
    }

    // TODO Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = waterModelList.size
}

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberOfGlassesTextView = view.number_of_glasses
        val dateTextView = view.date
//        val dayOfTheWeekTextView = view.dayOfWeek


}