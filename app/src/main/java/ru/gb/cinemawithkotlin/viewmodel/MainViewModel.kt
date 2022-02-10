package ru.gb.cinemawithkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gb.cinemawithkotlin.model.Repository
import ru.gb.cinemawithkotlin.model.RepositoryImpl

class MainViewModel(private val liveDataObserverMain : MutableLiveData<AppStateMain> = MutableLiveData(),
val repository: Repository = RepositoryImpl()) : ViewModel() {

    fun getLiveDataMain() = liveDataObserverMain

    fun getCinemaListNowPlaying() = getDataFromLocalSourceNowPlaying()
    fun getCinemaListUpcoming() = getDataFromLocalSourceUpcoming()

    private fun getDataFromLocalSourceNowPlaying(){
        Thread{
            Thread.sleep(1000)
            liveDataObserverMain.postValue(AppStateMain.Success(repository.getCinemaListFromLocalSourceNowPlaying(), repository.getCinemaListFromLocalSourceUpcoming()))
        }.start()
    }

    private fun getDataFromLocalSourceUpcoming(){
        Thread{
            Thread.sleep(1000)
            liveDataObserverMain.postValue(AppStateMain.Success(repository.getCinemaListFromLocalSourceNowPlaying(), repository.getCinemaListFromLocalSourceUpcoming()))
        }.start()
    }
}