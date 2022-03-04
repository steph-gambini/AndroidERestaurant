package fr.isen.gambini.androiderestaurant

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import android.widget.TextView
import android.widget.Toast
import fr.isen.gambini.androiderestaurant.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bpEntrees.setOnClickListener {
            startCategory(getString(R.string.bp_EntreesTxt))
        }
        binding.bpPlats.setOnClickListener {
            startCategory(getString(R.string.bp_PlatsTxt))
        }
        binding.bpDesserts.setOnClickListener {
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
