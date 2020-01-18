package com.crayonwriter.wootechdrinkwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: WaterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel
        model = ViewModelProviders.of(this).get(WaterViewModel::class.java)

        //Database instance created
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        model.setDb(db)
        
        // Create the observer which updates the UI.
        val nameObserver = Observer<Int> { newNumber ->
            // Update the UI, in this case, an EditText view.
            numberOfGlasses.setText(newNumber.toString())
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.

        model.getGlasses().observe(this, nameObserver)

        addWaterButton.setOnClickListener {
            model.incrementGlasses()
        }

        subtractWaterButton.setOnClickListener {
            model.decrementGlasses()
        }
    }


}
