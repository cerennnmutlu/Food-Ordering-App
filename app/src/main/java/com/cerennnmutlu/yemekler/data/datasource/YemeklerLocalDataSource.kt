package com.cerennnmutlu.yemekler.data.datasource

import com.cerennnmutlu.yemekler.data.Retrofit.YemeklerDaoRetrofit
import com.cerennnmutlu.yemekler.data.entity.Yemekler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerLocalDataSource(private val yemeklerDao: YemeklerDaoRetrofit) {

    suspend fun yemekleriYukle(): List<Yemekler> = withContext(Dispatchers.IO) {
        return@withContext yemeklerDao.tumYemekleriYukle().yemekler
    }

}