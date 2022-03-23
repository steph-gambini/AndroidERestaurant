package fr.isen.gambini.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.gambini.androiderestaurant.model.Item

class CategoryAdapter (private val items: List<Item>, val onItemClick: (Item) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.category_cell,parent,false)

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder,position: Int) {
        holder.platTitle.text = items[position].name_fr

        Picasso.get().load(items[position].images[0].ifEmpty { null }).error(R.drawable.chef).into(holder.imageMenu);

        holder.itemView.setOnClickListener {
            onItemClick(items[position])
        }
        holder.price.text = items[position].prices[0].price + "€"
    }

    override fun getItemCount(): Int = items.size

    class CategoryViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val platTitle : TextView = itemView.findViewById(R.id.PlatTitle)
        var imageMenu : ImageView = itemView.findViewById(R.id.imageView)
        val price : TextView = itemView.findViewById(R.id.textPrice)
    }
}
