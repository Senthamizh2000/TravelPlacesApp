package io.example.travelguideapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var placeName: TextView
    private lateinit var btnNext: ImageButton
    private lateinit var btnPrev: ImageButton

    private val images = arrayOf(
        R.drawable.pic0,
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4
    )

    private val placeNames = arrayOf(
        "Taj Mahal",
        "India Gate",
        "Mahabalipuram",
        "Red Fort",
        "Charminar"
    )

    private var currentIndex = 0  // Keeps track of the current image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.pic0)
        placeName = findViewById(R.id.placeName)
        btnNext = findViewById(R.id.btnNext)
        btnPrev = findViewById(R.id.btnPrev)

        // Set the initial image and name
        updateImage()

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % images.size
            updateImage()
        }

        btnPrev.setOnClickListener {
            currentIndex = if (currentIndex - 1 < 0) images.size - 1 else currentIndex - 1
            updateImage()
        }
    }

    private fun updateImage() {
        imageView.setImageResource(images[currentIndex])
        placeName.text = placeNames[currentIndex]
    }
}