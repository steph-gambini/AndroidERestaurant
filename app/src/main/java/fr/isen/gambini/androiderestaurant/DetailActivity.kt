package fr.isen.gambini.androiderestaurant

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import fr.isen.gambini.androiderestaurant.databinding.ActivityDetailBinding
import fr.isen.gambini.androiderestaurant.model.Item
import fr.isen.gambini.androiderestaurant.model.PanierItem

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.bp_panier -> {
            val intent = Intent(this, PanierActivity::class.java)
            //   intent.putExtra(CATEGORY_KEY, category)
            startActivity(intent)

            true
        }
        else -> super.onOptionsItemSelected(item)
    }

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
       quantiteMenu(item)
        refreshTextView(1)
    }

        fun quantiteMenu(item: Item){
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
            binding.bpAjoutPanier.setOnClickListener{
                val itemPanier  = PanierItem(item.name_fr,quantite,item.prices[0].price.toFloat(),item.images[0])
                PanierUser.update(itemPanier)
              //  setupBadge()
                Snackbar.make(binding.root,"$quantite ${item.name_fr} bien ajouté au panier", Snackbar.LENGTH_SHORT ).show()
            }
    }

        @SuppressLint("SetTextI18n")
        fun refreshTextView(quantite : Int){
        val menu = intent.getSerializableExtra(CategoryActivity.DETAILS_KEY) as Item
        val price = quantite * menu.prices[0].price.toFloat()
        binding.nbQuantite.text = quantite.toString()
       binding.bpAjoutPanier.text = "Ajouter au panier : " + price.toString() + " €"
        }

}