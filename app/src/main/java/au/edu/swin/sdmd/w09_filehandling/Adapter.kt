package au.edu.swin.sdmd.w09_filehandling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val listOfStrings: List<LinesData>) : RecyclerView.Adapter<Adapter.ViewHolder>()  {

    //Create View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //set up the cells in the layout row file to show the data in the array
        val view = layoutInflater
            .inflate(R.layout.list_layout, parent, false) as View
        return ViewHolder(view)
    }

    //Get data count
    override fun getItemCount() = listOfStrings.size

    //Bind adapter and viewHolder to the data position
    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = listOfStrings[position]
        holder.bind(item)
    }

    //Set view with click listener
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //Set number view created on activity_row file TextView and RatingBar
        private val words = view.findViewById<TextView>(R.id.words)
        private val rating = view.findViewById<RatingBar>(R.id.ratingBar)

        //Bin data from data class to each view item
        fun bind(item: LinesData) {
            words.text = item.word
            rating.rating = item.number.toFloat()
        }

    }
}