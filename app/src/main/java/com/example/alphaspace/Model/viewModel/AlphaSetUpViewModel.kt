package com.example.alphaspace.Model.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.alphaspace.Model.room.entities.StoreType

class AlphaSetUpViewModel : ViewModel(){

    var storeTypes = mutableStateListOf<StoreType>()
        private set

    fun addStoreType(storeType: StoreType){
        storeTypes.add(storeType)
    }

    fun removeStoreType(storeType: StoreType){
        storeTypes.remove(storeType)
    }

}