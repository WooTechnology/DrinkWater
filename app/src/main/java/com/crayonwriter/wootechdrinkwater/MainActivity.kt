package com.crayonwriter.wootechdrinkwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: WaterViewModel
    var waterAdapter: waterRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = waterAdapter

        // Get the ViewModel
        model = ViewModelProviders.of(this).get(WaterViewModel::class.java)

        //Database instance created
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        model.setDb(db)

        // Create the observer which updates the UI
        val nameObserver = Observer<WaterEntries> { waterModel ->
            if (waterModel == null) {
                numberOfGlasses.setText("0")
            } else {
                numberOfGlasses.setText(waterModel.glasses)
            }
        }

        //TODO: Finish this implementation after the recyclerView/adapter is completed
        val weekObserver = Observer<List<WaterEntries>> {weekListModel ->

        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.

        model.getGlasses().observe(this, nameObserver)

        model.getWeekGlasses().observe(this, weekObserver)

        addWaterButton.setOnClickListener {
            model.incrementGlasses(numberOfGlasses.text.toString().toInt())
        }

        subtractWaterButton.setOnClickListener {
            model.decrementGlasses(numberOfGlasses.text.toString().toInt())
        }
    }

}
