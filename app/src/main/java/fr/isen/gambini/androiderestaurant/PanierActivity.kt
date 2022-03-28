package fr.isen.gambini.androiderestaurant
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.isen.gambini.androiderestaurant.databinding.MenuPanierBinding
import android.annotation.SuppressLint
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager

class PanierActivity: AppCompatActivity() {
    private lateinit var binding: MenuPanierBinding

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MenuPanierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.panierRecycler.layoutManager = LinearLayoutManager(this)

        binding.panierRecycler.adapter = PanierAdapter(PanierUser.content){
            val item  = it.copy()
            if (item.quantity>1){
            item.quantity = -1
            PanierUser.update(item)}
            //setBadgeCount(this)
            updateTotal()
            binding.panierRecycler.adapter?.notifyDataSetChanged()

        }


        updateTotal()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTotal(){
        binding.totalPanier.text = "Payer ${PanierUser.content.sumOf { (it.quantity*it.unit_price).toDouble() }} €"
    }
}