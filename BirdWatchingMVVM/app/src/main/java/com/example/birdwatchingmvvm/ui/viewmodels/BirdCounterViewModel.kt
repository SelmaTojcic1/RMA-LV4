package com.example.birdwatchingmvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.birdwatchingmvvm.R
import com.example.birdwatchingmvvm.model.BirdCounter

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

    fun resetCounter() {
        birdCounter.resetCounter()
        _birdsSeen.postValue(birdCounter.birdsSeen)
    }
}