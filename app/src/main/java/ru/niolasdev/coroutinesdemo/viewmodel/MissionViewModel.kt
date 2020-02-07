package ru.niolasdev.coroutinesdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.niolasdev.coroutinesdemo.domain.LaunchMission
import ru.niolasdev.coroutinesdemo.network.LaunchRepository

class MissionViewModel : ViewModel() {

    private val launchRepository =
        LaunchRepository()

    var missionLaunchList: LiveData<List<LaunchMission>> = liveData(Dispatchers.IO) {
        val retrievedData = launchRepository.getPastLaunches()
        emit(retrievedData)
    }

}
