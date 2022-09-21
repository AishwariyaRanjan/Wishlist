package com.example.wishlist

object Lists {
    private var itemList = ArrayList<String>()
    private var storeList = ArrayList<String>()
    private var priceList = ArrayList<String>()
    fun allLists(iList: ArrayList<String>, sList: ArrayList<String>,pList: ArrayList<String>){
        itemList = iList
        storeList = sList
        priceList = pList
    }
    fun getItemList(): ArrayList<String> {
        return itemList
    }
    fun getStoreList(): ArrayList<String> {
        return storeList
    }
    fun getPriceList(): ArrayList<String> {
        return priceList
    }
}