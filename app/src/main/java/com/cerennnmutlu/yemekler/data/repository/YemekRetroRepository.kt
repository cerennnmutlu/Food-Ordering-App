package com.cerennnmutlu.yemekler.data.repository

import android.util.Log
import com.cerennnmutlu.yemekler.data.Retrofit.YemeklerDaoRetrofit
import com.cerennnmutlu.yemekler.data.datasource.YemeklerLocalDataSource
import com.cerennnmutlu.yemekler.data.entity.Yemekler
import javax.inject.Inject

class YemekRetroRepository (var yds : YemeklerLocalDataSource) {

    suspend fun tumYemekleriGetir() : List<Yemekler> = yds.yemekleriYukle()









}
