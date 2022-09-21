package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.Lists.allLists

class MainActivity : AppCompatActivity() {

    lateinit var item : EditText
    lateinit var store : EditText
    lateinit var price : EditText
    private val itemList= arrayListOf<String>()
    private val storeList= arrayListOf<String>()
    private val priceList= arrayListOf<String>()

    lateinit var wishes: List<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //on submit, data saved in array list, recycle view should pull data from thius array list
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener{
            item = findViewById<EditText>(R.id.editTextItem)
            store = findViewById<EditText>(R.id.editTextStore)
            price = findViewById<EditText>(R.id.editTextPrice)

            //add each entry to Array List
            itemList.add(item.text.toString())
            storeList.add(store.text.toString())
            priceList.add(price.text.toString())

            allLists(itemList,storeList,priceList)
            //clear editText once added to list
            item.setText("")
            store.setText("")
            price.setText("")

            // Lookup the RecyclerView in activity layout
            val wishesRv = findViewById<RecyclerView>(R.id.wishlistRv)
            // Fetch the list of wishes
            wishes = WishFetcher.getWishes()
            //Create adapter passing in the list of wishes
            val adapter = WishlistAdapter(wishes)
            //Attach the adapter to the RecyclerView to populate items
            wishesRv.adapter = adapter
            //Set layout manager to position the items
            wishesRv.layoutManager = LinearLayoutManager(this)
        }


    }


}