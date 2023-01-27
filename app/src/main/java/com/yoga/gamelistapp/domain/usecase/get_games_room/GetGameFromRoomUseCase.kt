package com.yoga.gamelistapp.domain.usecase.get_games_room

import android.content.Context
import com.yoga.gamelistapp.data.local.model.toUIModelDetails
import com.yoga.gamelistapp.data.local.service.ModelDatabase
import com.yoga.gamelistapp.di.DefaultDispatcher
import com.yoga.gamelistapp.domain.model.UIModelDetails
import kotlinx.coroutines.*
import javax.inject.Inject

class GetGameFromRoomUseCase @Inject constructor(
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
){
//Dispatcher,Statehandle,Navigation-Navbar,suspend

    suspend operator fun invoke(context: Context,uuid:Int): UIModelDetails?= withContext(defaultDispatcher){
        val dao= ModelDatabase(context).modelDao()
        dao.checkIfWishlist(uuid)?.toUIModelDetails()
    }
}