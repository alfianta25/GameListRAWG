package com.yoga.gamelistapp.domain.usecase.delete_game_wishlist

import android.content.Context
import com.yoga.gamelistapp.data.local.service.ModelDatabase
import com.yoga.gamelistapp.di.DefaultDispatcher
import kotlinx.coroutines.*
import javax.inject.Inject

class DeleteGameFromWishlistUseCase @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
){
    suspend operator fun invoke(context: Context, uuid:Int)= withContext(defaultDispatcher) {
        val dao = ModelDatabase(context).modelDao()
        dao.deleteFromWishlist(uuid)
    }
}