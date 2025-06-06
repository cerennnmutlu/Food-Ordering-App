package com.cerennnmutlu.yemekler.data.repository

import com.cerennnmutlu.yemekler.data.datasource.FavoriYemeklerDataSource
import com.cerennnmutlu.yemekler.data.entity.FavoriYemekler
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriYemeklerRepository @Inject constructor(
    private val dataSource: FavoriYemeklerDataSource
) {

    suspend fun getAllFavoriYemekler(): List<FavoriYemekler> {
        return dataSource.getAllFavoriYemekler()
    }

    suspend fun favoriEkle(favoriYemek: FavoriYemekler) {
        dataSource.insertFavoriYemek(favoriYemek)
    }

    suspend fun favoriSil(favoriId: Int) {
        dataSource.deleteFavoriYemek(favoriId)
    }

    suspend fun isFavori(yemekAdi: String): Boolean {
        return dataSource.isFavori(yemekAdi)
    }
}
