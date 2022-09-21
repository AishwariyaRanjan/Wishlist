package com.example.wishlist
import com.example.wishlist.Lists.getItemList
import com.example.wishlist.Lists.getStoreList
import com.example.wishlist.Lists.getPriceList
import java.util.*
import kotlin.collections.ArrayList

class WishFetcher {
    companion object{
        var item = getItemList()
        var store = getStoreList()
        var price = getPriceList()

        fun getWishes(): MutableList<Wish> {
            var wishes : MutableList<Wish> = ArrayList()
            for (i in item.indices) {
                val wish = Wish(item[i],store[i],price[i])
                wishes.add(wish)
            }
            return wishes
        }
    }
}
