package com.cerennnmutlu.yemekler.di

import android.content.Context
import androidx.room.Room
import com.cerennnmutlu.yemekler.data.Retrofit.ApiUtils
import com.cerennnmutlu.yemekler.data.Retrofit.SepetlerDaoRetrofit
import com.cerennnmutlu.yemekler.data.Retrofit.YemeklerDaoRetrofit
import com.cerennnmutlu.yemekler.Room.AppDatabase
import com.cerennnmutlu.yemekler.Room.FavoriYemeklerDao
import com.cerennnmutlu.yemekler.data.datasource.FavoriYemeklerDataSource
import com.cerennnmutlu.yemekler.data.datasource.SepetDataSource
import com.cerennnmutlu.yemekler.data.datasource.YemeklerLocalDataSource
import com.cerennnmutlu.yemekler.data.repository.FavoriYemeklerRepository
import com.cerennnmutlu.yemekler.data.repository.SepetRepository
import com.cerennnmutlu.yemekler.data.repository.YemekRetroRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    //Yemekler
    fun provideYemeklerRepository(yds : YemeklerLocalDataSource) : YemekRetroRepository{
        return YemekRetroRepository(yds)
    }
    @Provides
    @Singleton
    fun provideYemeklerDataSource(ydao : YemeklerDaoRetrofit) : YemeklerLocalDataSource{
        return YemeklerLocalDataSource(ydao)
    }
    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDaoRetrofit{
        return ApiUtils.getYemeklerDao()
    }
    @Provides
    @Singleton
    //Sepet
    fun provideSepetRepository(sds : SepetDataSource) : SepetRepository {

        return SepetRepository(sds)
    }
    @Provides
    @Singleton
    fun provideSepetDataSource(sdao : SepetlerDaoRetrofit) : SepetDataSource {

        return SepetDataSource(sdao)
    }
    @Provides
    @Singleton
    fun provideSepetDao() : SepetlerDaoRetrofit {

        return ApiUtils.getSepetlerDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideFavoriDao(appDatabase: AppDatabase) : FavoriYemeklerDao{
        return appDatabase.favoriYemeklerDao()
    }

    @Provides
    @Singleton
    fun provideFavoriYemeklerDataSource(favoriDao : FavoriYemeklerDao) : FavoriYemeklerDataSource{

        return FavoriYemeklerDataSource(favoriDao)


    }

    @Provides
    @Singleton

    fun provideFavoriYemeklerRepository(favorids : FavoriYemeklerDataSource) : FavoriYemeklerRepository {
        return FavoriYemeklerRepository(favorids)
    }







    










}