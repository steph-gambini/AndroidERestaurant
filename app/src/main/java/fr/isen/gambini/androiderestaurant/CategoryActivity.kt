package fr.isen.gambini.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.gambini.androiderestaurant.databinding.ActivityCategoryBinding
import org.json.JSONObject

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
        request_Post()
    }
    private fun request_Post(){
        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"

        val requestBody = JSONObject("{\"id_shop\":1}")
        val req =
            object : JsonObjectRequest(Method.POST, url,requestBody,
                Response.Listener { response ->
                    Log.d("API00", "json => $response")
                },
                Response.ErrorListener { error ->
                    Log.d("API00", "error => $error")
                }
            ){
            }
        queue.add(req)
    }

}

