import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appkasrt.R
import model.DataItem

class PemanfaatanAdapter(private val pemanfaatan: MutableList<DataItem>) :
    RecyclerView.Adapter<PemanfaatanAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {

        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pemanfaatan, parent, false)
        return ListViewHolder(view)
    }

    fun setPemanfaatan(dataItem: List<DataItem>) {
        pemanfaatan.clear()
        pemanfaatan.addAll(dataItem)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = pemanfaatan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = pemanfaatan[position]

        holder.tvPemanfaatan.text = "-" + item.kegunaan_iuran
        holder.tvTotalIuranRekap.text = item.pengeluaran_iuran.toString()

    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPemanfaatan: TextView = itemView.findViewById(R.id.itempemanfaatan)
        var tvTotalIuranRekap: TextView = itemView.findViewById(R.id.itemTotalIuran)
    }
}
