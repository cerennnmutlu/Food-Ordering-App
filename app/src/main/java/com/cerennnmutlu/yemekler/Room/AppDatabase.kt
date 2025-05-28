package com.cerennnmutlu.yemekler.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cerennnmutlu.yemekler.data.entity.FavoriYemekler


@Database (entities = [FavoriYemekler::class], version = 1)
abstract  class AppDatabase : RoomDatabase(){

    abstract fun favoriYemeklerDao() : FavoriYemeklerDao
}