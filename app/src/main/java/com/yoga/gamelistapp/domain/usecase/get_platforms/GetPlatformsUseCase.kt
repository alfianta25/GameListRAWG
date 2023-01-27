package com.yoga.gamelistapp.domain.usecase.get_platforms

import com.yoga.gamelistapp.data.remote.model.RAWGResponsePlatformsResult
import com.yoga.gamelistapp.domain.repository.IApiRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPlatformsUseCase @Inject constructor(
    private val repository: IApiRepository
){
    operator fun invoke(): Single<RAWGResponsePlatformsResult>{
        return repository.getPlatforms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}