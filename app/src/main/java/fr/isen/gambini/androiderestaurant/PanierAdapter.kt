package fr.isen.gambini.androiderestaurant

import fr.isen.gambini.androiderestaurant.model.PanierItem
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.gambini.androiderestaurant.databinding.PanierCellBinding

class PanierAdapter(private val datas : List<PanierItem>, private val listener: (PanierItem) -> Unit):RecyclerView.Adapter<PanierAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =PanierCellBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding,listener)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(datas[position])
    override fun getItemCount(): Int = datas.size

    class ViewHolder(private val binding:PanierCellBinding ,private val listener: (PanierItem) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data : PanierItem){
            Picasso.get().load(data.image.ifEmpty { null }).error(R.drawable.chef).into(binding.btPanier);
            binding.titleMenuPanier.text = data.name_fr
            binding.pricePanier.text = "${data.quantity} x ${data.unit_price}€ : ${data.unit_price*data.quantity}€"
            binding.bpDecrPanier.setOnClickListener { listener(data) }
            binding.bpIncrPanier.setOnClickListener{
                data.quantity=data.quantity+2
            listener(data)}
            binding.nbQuantitePanier.text = data.quantity.toString()
            val existElem = PanierUser.content.first{it.name_fr == data.name_fr}
            binding.btDestroyPanier.setOnClickListener{ PanierUser.content.remove(existElem)
            listener(data)}
        }
    }

}