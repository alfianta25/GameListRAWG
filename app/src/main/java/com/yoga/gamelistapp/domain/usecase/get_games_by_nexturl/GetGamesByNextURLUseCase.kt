package com.yoga.gamelistapp.domain.usecase.get_games_by_nexturl

import com.yoga.gamelistapp.data.remote.model.RAWGResponseGameListResult
import com.yoga.gamelistapp.domain.repository.IApiRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetGamesByNextURLUseCase @Inject constructor(
    private val repository: IApiRepository
) {
    operator fun invoke(nextURL:String):Single<RAWGResponseGameListResult>{
        return repository.getGamesByNextURL(nextURL)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}