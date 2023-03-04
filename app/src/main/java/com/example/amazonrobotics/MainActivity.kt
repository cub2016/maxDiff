package com.example.amazonrobotics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import java.lang.Math.abs

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun maxDifference(numbers: List<Int>): Int {
        var maxDiff = 0
        for (i in numbers.indices) {
            for (j in i + 1..numbers.size) {
                if (numbers[j] - numbers[i] > maxDiff) {
                    maxDiff = numbers[j] - numbers[i]
                }
            }
        }
        return maxDiff
    }

    fun maxDifference2(numbers: List<Int>): Int {
        var maxDiff = 0
        val numbersMaxIndex = numbers.size - 1
        numbers.mapIndexed { index, number ->
            numbers.subList(index + 1, numbersMaxIndex).map {
                if (it - number > maxDiff) maxDiff = abs(it - number)
            }

        }

        return maxDiff
    }

    fun maxDifference3(numbers: List<Int>): Int {
        numbers.sortedDescending()
        return numbers[0] - numbers[numbers.size - 1]
    }
}
