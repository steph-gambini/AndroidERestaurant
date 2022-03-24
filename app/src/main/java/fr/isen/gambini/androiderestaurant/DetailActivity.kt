package fr.isen.gambini.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import fr.isen.gambini.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.gambini.androiderestaurant.model.Item

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val intent = intent

        val item = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Item
        binding.titleFood.text = item.name_fr

        binding.textDetail.text = item.ingredients.joinToString(", ", transform = { it.name_fr })

        Log.i("image", item.images.toString())
        binding.viewSlider.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewSlider.adapter = DetailImagePager(this,item.images)

        val retMenu = findViewById<TextView>(R.id.return_menu)
        retMenu.setOnClickListener {
            finish()
        }
       quantiteMenu()
    }

        fun quantiteMenu(){
        var quantite = 1

        binding.bpDecr.setOnClickListener {
            if (quantite > 1){
                quantite--
            }
            refreshTextView(quantite)
        }

        binding.bpIncr.setOnClickListener {
            quantite++
            refreshTextView(quantite)
        }
    }

        fun refreshTextView(quantite : Int){
        val menu = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Item
        val price = quantite * menu.prices[0].price.toFloat()
        binding.nbQuantite.text = quantite.toString()
 //      binding.priceButton.text = price.toString() + " €"
        }
}