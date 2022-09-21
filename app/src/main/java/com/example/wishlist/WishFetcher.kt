package com.example.wishlist
import com.example.wishlist.Lists.getItemList
import com.example.wishlist.Lists.getStoreList
import com.example.wishlist.Lists.getPriceList
import java.util.*
class WishFetcher {
    companion object{
        var item = getItemList()
        var store = getStoreList()
        var price = getPriceList()
        
    }
}
