package com.example.birdwatchingmvvm.model

class BirdCounter {
    var birdsSeen: Int = 0
        private set
    var backgroundColor: Int = 0
        private set

    fun seeBird() = birdsSeen++
    fun changeBackground(color: Int) {
        backgroundColor = color
    }
    fun resetCounter() {
        birdsSeen = 0
    }
}