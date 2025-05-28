package com.cerennnmutlu.yemekler.data.Retrofit

import com.cerennnmutlu.yemekler.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDaoRetrofit {

    @GET("tumYemekleriGetir.php")
    suspend fun tumYemekleriYukle(): YemeklerCevap

}