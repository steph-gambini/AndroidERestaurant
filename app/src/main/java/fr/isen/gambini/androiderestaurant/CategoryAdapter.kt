package fr.isen.gambini.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (val categories: ArrayList<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.category_cell,parent,false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder,position: Int) {
        holder.platTitle.text = categories[position]
    }

    override fun getItemCount(): Int = categories.size

    class CategoryViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val platTitle : TextView = itemView.findViewById(R.id.PlatTitle)
    }
}