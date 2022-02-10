package ru.gb.cinemawithkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gb.cinemawithkotlin.model.Repository
import ru.gb.cinemawithkotlin.model.RepositoryImpl

class CinemaViewModel(private val liveDataObserver : MutableLiveData<AppState> = MutableLiveData(),
                      val repository: Repository = RepositoryImpl()
) : ViewModel() {

    fun getLiveData() = liveDataObserver

    fun getCinema() = getDataFromLocalSource()

    fun getDataFromLocalSource(){
        Thread{
            Thread.sleep(1000)
            liveDataObserver.postValue(AppState.Success(repository.getCinemaFromLocalSource(1)))
        }.start()
    }
}