package fr.isen.gambini.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.gambini.androiderestaurant.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.categoryTitle.text = intent.getStringExtra(MainActivity.CATEGORY_KEY)
        binding.categoryList.layoutManager = LinearLayoutManager(this)
        binding.categoryList.adapter = CategoryAdapter(arrayListOf<String>("salut", "aurevoir"))


    val retAcceuil = findViewById<TextView>(R.id.return_Acceuil)

    retAcceuil.setOnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
     }
    }
}