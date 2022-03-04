package fr.isen.gambini.androiderestaurant

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

//    private val CATEGORY_KEY = "category"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entrees = findViewById<TextView>(R.id.bp_Entrees)
        val plats = findViewById<TextView>(R.id.bp_Plats)
        val desserts = findViewById<TextView>(R.id.bp_Desserts)

        entrees.setOnClickListener {
            startCategory(getString(R.string.bp_EntreesTxt))
        }
        plats.setOnClickListener {
            startCategory(getString(R.string.bp_PlatsTxt))
        }
        desserts.setOnClickListener {
            startCategory(getString(R.string.bp_DessertsTxt))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","L'activité est détruite")
    }

    private fun startCategory(category: String) {
        val intent = Intent(this, CategoryActivity::class.java)
        intent.putExtra(CATEGORY_KEY, category)
        startActivity(intent)
    }
    companion object{
        const val CATEGORY_KEY = "category"
    }
}
