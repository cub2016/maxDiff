package com.example.amazonrobotics

import android.util.Log
import java.lang.Math.abs

class MaxDifference {
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
        val numbersMaxIndex = numbers.size
        numbers.mapIndexed { index, number ->
            val subList = numbers.subList(index + 1, numbersMaxIndex)
            subList.map {
                if (Math.abs(it - number) > maxDiff) maxDiff = abs(it - number)
            }
        }

        return maxDiff
    }

    fun maxDifference3(numbers: List<Int>): Int {
        mySort(numbers)
        return abs(numbers[numbers.size - 1] - numbers[0])
    }

    fun maxDifference4(numbers: List<Int>): Int {
        val numb = numbers.sortedDescending()
        return abs(numb[numbers.size - 1] - numb[0])
    }

    fun maxDifference5(numbers: List<Int>): Int? {
        val max = numbers.maxOrNull()
        val min = numbers.minOrNull() ?: return null
        return max?.minus(min)?.let {
            abs(it)
        }
    }

    fun merge2(listL: MutableList<Int>, listR: MutableList<Int>) {

        val newList = mutableListOf<Int>()

        var iterableL = listL.listIterator()
        var iterableR = listR.listIterator()
        var iterableNew = newList.listIterator()
        while (iterableL.hasNext() && iterableR.hasNext()) {
            val l = iterableL.next()
            val r = iterableR.next()
            if (l <= r) {
                iterableNew.add(l)
                iterableR.previous()
            } else {
                iterableNew.add(r)
                iterableL.previous()
            }
        }

        while (iterableL.hasNext()) {
            iterableNew.add(iterableL.next())
        }

        while (iterableR.hasNext()) {
            iterableNew.add(iterableR.next())
        }

        iterableNew = newList.listIterator()
        iterableL = listL.listIterator()
        iterableR = listR.listIterator()
        while (iterableL.hasNext()) {
            iterableL.next()
            iterableL.set(iterableNew.next())
        }
        while (iterableR.hasNext()) {
            iterableR.next()
            iterableR.set(iterableNew.next())
        }
    }

    fun mySort(intList: List<Int>) {
        if (intList.size > 1) {
            val listL = (intList.subList(0, intList.size / 2))
            mySort(listL)

            val listR = intList.subList(intList.size / 2, intList.size)
            mySort(listR)

            merge2(listL as MutableList<Int>, listR as MutableList<Int>)
        }
    }
}
