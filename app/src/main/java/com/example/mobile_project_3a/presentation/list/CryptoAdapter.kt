package com.example.mobile_project_3a.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_project_3a.R
import com.example.mobile_project_3a.presentation.detail.Detail


class CryptoAdapter(private var dataSet: List<Coin>, val listener: ((Coin) -> Unit)? = null) :
    RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.crypto_name)
        }
    }

    fun updateList(list: List<Coin>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.crypto_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val coin :Coin = dataSet[position]
        val toDisplay = ("" + coin.rank + ". "+ coin.name)
        viewHolder.textView.text = toDisplay
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(coin)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
