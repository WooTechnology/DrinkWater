package com.crayonwriter.wootechdrinkwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: WaterViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var viewAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(myDataset)

        recyclerView = findViewById(R.id.listWeekOfData).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

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

        val weekObserver = Observer<List<WaterEntries>> { weekListModel ->
            if (weekListModel.isEmpty()) {
                recyclerView.visibility = View.INVISIBLE
            } else {
                glassesAdapter.setWaterList(weekListModel)
            }
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
