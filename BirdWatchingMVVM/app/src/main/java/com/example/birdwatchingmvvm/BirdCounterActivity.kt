package com.example.birdwatchingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birdwatchingmvvm.databinding.ActivityBirdCounterBinding

class BirdCounterActivity : AppCompatActivity() {

    private val birdCounter = BirdCounter()
    private val viewModel = BirdCounterViewModel(birdCounter)
    private lateinit var binding: ActivityBirdCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirdCounterBinding.inflate(layoutInflater).also {
            it.buttonBlue.setOnClickListener {
                viewModel.seeBird()
                viewModel.changeBackground(R.color.blue)
            }
            it.buttonYellow.setOnClickListener {
                viewModel.seeBird()
                viewModel.changeBackground(R.color.yellow)
            }
            it.buttonGreen.setOnClickListener {
                viewModel.seeBird()
                viewModel.changeBackground(R.color.green)
            }
            it.buttonRed.setOnClickListener {
                viewModel.seeBird()
                viewModel.changeBackground(R.color.red)
            }
            it.buttonReset.setOnClickListener {
                viewModel.reset()
            }
        }
        setContentView(binding.root)

        viewModel.birdsSeen.observe(this, {binding.tvBirdCount.text = it.toString()})
        viewModel.backgroundColor.observe(
            this, { viewModel.backgroundColor.value?.let { color ->
                binding.tvBirdCount.setBackgroundResource(
                    color
                )
            } })
    }
}