package com.example.restApis.repositories

import com.example.restApis.models.Item

interface IShoppingItemRepository {

    fun getItemById(id: Int): Item
    fun getAllItems(): List<Item>
}