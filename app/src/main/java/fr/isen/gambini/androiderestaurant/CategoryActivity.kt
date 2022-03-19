package fr.isen.gambini.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.gambini.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.gambini.androiderestaurant.model.Data
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    companion object{
        const val DETAILS_KEY = "String"
    }

    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cat = intent.getStringExtra(MainActivity.CATEGORY_KEY)
        binding.categoryTitle.text = cat
        binding.categoryRecycler.layoutManager = LinearLayoutManager(this)
        binding.categoryRecycler.adapter = CategoryAdapter(arrayListOf()) {}


        val retAcceuil = findViewById<TextView>(R.id.return_Acceuil)

        retAcceuil.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
         }
        binding.categoryRecycler.adapter = CategoryAdapter(arrayListOf()) {}
        requestPost(cat)
    }

    private fun requestPost(cat: String?) {

        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val requestBody = JSONObject("{\"id_shop\":1}")
        val req =
            object : JsonObjectRequest(Method.POST, url,requestBody,
                Response.Listener { response ->
                    Log.d("API00", "json => $response")
                    val dataLoad = Gson().fromJson(response.toString(),Data::class.java)
                    val items = dataLoad.data.firstOrNull{it.name_fr==cat}?.items
                        ?: arrayListOf()
                    binding.categoryRecycler.adapter = CategoryAdapter(items?: arrayListOf()) {
                        val intent = Intent(this, DetailsActivity::class.java)
                        intent.putExtra("item", it)
                        startActivity(intent)
                    }
                },
                Response.ErrorListener { error ->
                    Log.d("API00", "error => $error")
                }

            ){
            }
        queue.add(req)
    }

}

