package com.yoga.gamelistapp.domain.usecase.get_wishlist_games

import android.content.Context
import com.yoga.gamelistapp.data.local.model.toUIModelListing
import com.yoga.gamelistapp.data.local.service.ModelDatabase
import com.yoga.gamelistapp.di.DefaultDispatcher
import com.yoga.gamelistapp.domain.model.UIModelListing
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWishlistGamesUseCase @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(context: Context):ArrayList<UIModelListing> =withContext(defaultDispatcher){
        val dao= ModelDatabase(context).modelDao()
        ArrayList(dao.getAllFromWishlist().map { it.toUIModelListing() })
    }
}