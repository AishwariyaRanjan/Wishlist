package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.wishlist.Lists.allLists

class MainActivity : AppCompatActivity() {

    lateinit var item : EditText
    lateinit var store : EditText
    lateinit var price : EditText
    private val itemList= arrayListOf<String>()
    private val storeList= arrayListOf<String>()
    private val priceList= arrayListOf<String>()

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
            itemList.add(item.toString())
            storeList.add(store.toString())
            priceList.add(price.toString())

            allLists(itemList,storeList,priceList)
        }
    }


}