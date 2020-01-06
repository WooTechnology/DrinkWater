package com.crayonwriter.wootechdrinkwater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: WaterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the ViewModel.
        model = ViewModelProviders.of(this).get(WaterViewModel::class.java)

        // Create the observer which updates the UI.
        //NOTE: Can the numberOfGlasses be change to an Int?
        val nameObserver = Observer<Int> { newNumber ->
            // Update the UI, in this case, a TextView.
            numberOfGlasses.setText(newNumber)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        //NOTE: I had to change glasses to public in the viewmodel or else I got an
        //error that it couldn't be reached.
        model.glasses.observe(this, nameObserver)

        //I couldn't get the edittext to be Int. This section needs work.
        addWaterButton.setOnClickListener {
            model.incrementGlasses()
        }

        subtractWaterButton.setOnClickListener {
            model.decrementGlasses()
        }
    }


}
