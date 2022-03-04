package fr.isen.gambini.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val title = findViewById<TextView>(R.id.categoryTitle)
        title.text = intent.getStringExtra(MainActivity.CATEGORY_KEY)
    }
}