package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val wishes: List<Wish>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {
    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val itemTv: TextView
        val storeTv: TextView
        val priceTv: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            itemTv = itemView.findViewById(R.id.itemTv)
            storeTv = itemView.findViewById(R.id.storeTv)
            priceTv = itemView.findViewById(R.id.priceTv)

            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }
    //Implement onCreateViewHolder by inflating our custom item layout wish_item.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        //Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wish_item,parent,false)
        //Return a new holder instance
        return ViewHolder(contactView, mListener)
    }
    //Implement onBindViewHolder by populating the data of a wish into the view holder:
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes.get(position)

        holder.itemTv.text = wish.item
        holder.storeTv.text = wish.store
        holder.priceTv.text = wish.price


    }
    //Implement getItemCount() by returning the number of wishes in the list of wishes
    override fun getItemCount(): Int {
        return wishes.size
    }
}