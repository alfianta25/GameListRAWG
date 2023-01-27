package com.yoga.gamelistapp.domain.repository

import com.yoga.gamelistapp.common.*
import com.yoga.gamelistapp.data.remote.model.RAWGResponseGameDetails
import com.yoga.gamelistapp.data.remote.model.RAWGResponseGameListResult
import com.yoga.gamelistapp.data.remote.model.RAWGResponsePlatformsResult
import io.reactivex.Single


interface IApiRepository {

    fun getGameDetails(id:Int): Single<RAWGResponseGameDetails>

    fun getPlatforms():Single<RAWGResponsePlatformsResult>

    fun getGamesBySearch(searchString: String):Single<RAWGResponseGameListResult>

    fun getGamesBySearchPlatform(searchString: String,platformId:Int):Single<RAWGResponseGameListResult>

    fun getGamesByNextURL(urlString: String):Single<RAWGResponseGameListResult>
}