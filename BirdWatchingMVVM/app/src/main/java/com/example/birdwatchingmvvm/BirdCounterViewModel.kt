package com.example.birdwatchingmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BirdCounterViewModel(private val birdCounter: BirdCounter): ViewModel() {

    private val _birdsSeen = MutableLiveData(birdCounter.birdsSeen)
    val birdsSeen: LiveData<Int> = _birdsSeen

    private val _backgroundColor = MutableLiveData(birdCounter.backgroundColor)
    val backgroundColor: LiveData<Int> = _backgroundColor

    fun seeBird() {
        birdCounter.seeBird()
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }

    fun changeBackground(color: Int) {
        birdCounter.changeBackground(color)
        _backgroundColor.postValue(birdCounter.backgroundColor)
    }

    fun reset() {
        birdCounter.changeBackground(R.color.white)
        _birdsSeen.postValue(0)
    }
}