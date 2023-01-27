package com.yoga.gamelistapp.data.remote.model

import com.yoga.gamelistapp.common.*
import com.yoga.gamelistapp.domain.model.UIModelDetails
import com.yoga.gamelistapp.domain.model.UIModelListing
import com.yoga.gamelistapp.domain.model.UIPlatforms

fun RAWGResponseGameDetails.toUIModelDetails(): UIModelDetails {
    return UIModelDetails(
        this.id,
        this.name,
        this.description,
        this.metacritic,
        this.released,
        this.website,
        this.reddit_url,
        ArrayList(this.genres.map { it.name!! }),
        ArrayList(this.developers.map { it.name }),
        this.background_image)
}
fun RAWGResponseGameListResult.toUIModelListings():Pair<String?,ArrayList<UIModelListing>>{
    val returnListing=ArrayList(
        this.results?.map {
            UIModelListing(
                it.id,
                it.name,
                it.background_image
            )}?: arrayListOf())
    return Pair(this.next, returnListing)
}

fun RAWGResponsePlatformsResult.toUIPlatforms():ArrayList<UIPlatforms>{
    return ArrayList(
        this.results.map {
            UIPlatforms(
                it.id,
                it.name
            )})
}