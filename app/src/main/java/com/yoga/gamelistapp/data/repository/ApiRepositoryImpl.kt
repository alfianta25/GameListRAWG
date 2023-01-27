package com.yoga.gamelistapp.data.repository

import com.yoga.gamelistapp.data.remote.model.RAWGResponseGameDetails
import com.yoga.gamelistapp.data.remote.model.RAWGResponseGameListResult
import com.yoga.gamelistapp.data.remote.model.RAWGResponsePlatformsResult
import com.yoga.gamelistapp.data.remote.service.IRawgAPI
import com.yoga.gamelistapp.domain.repository.IApiRepository
import io.reactivex.Single
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val api: IRawgAPI
): IApiRepository {
    override fun getGameDetails(id: Int): Single<RAWGResponseGameDetails> {
        return api.getGameDetails(id)
    }

    override fun getPlatforms(): Single<RAWGResponsePlatformsResult> {
        return api.getPlatforms()
    }

    override fun getGamesBySearch(searchString: String): Single<RAWGResponseGameListResult> {
        return api.getGameListBySearch(search = searchString)
    }

    override fun getGamesBySearchPlatform(
        searchString: String,
        platformId: Int
    ): Single<RAWGResponseGameListResult> {
        return api.getGameListBySearchPlatform(search = searchString, platformID = platformId)
    }

    override fun getGamesByNextURL(urlString: String): Single<RAWGResponseGameListResult> {
        return api.getGamesByNextURL(urlString)
    }

}