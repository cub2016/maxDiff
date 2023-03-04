package com.example.amazonrobotics

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val maxDifferenceClass = MaxDifference()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testMaxDifference2() {
        val list1 = listOf<Int>(2, 3, 10, 6, 4, 8, 1)

        var diff: Int? = maxDifferenceClass.maxDifference2(list1)
        assertEquals(diff, 9)
        diff = maxDifferenceClass.maxDifference3(list1)
        assertEquals(diff, 9)
        diff = maxDifferenceClass.maxDifference4(list1)
        assertEquals(diff, 9)
        diff = maxDifferenceClass.maxDifference5(list1)
        assertEquals(diff, 9)

        val list2 = IntArray(10) { Random().nextInt(1000) }.asList()
        var i = 0
//        val list2 = IntArray(100) {i++ }.asList()
//        diff = maxDifferenceClass.maxDifference3(list2)
        println("$diff")
//        assertEquals(diff, 9)
        val diff2 = maxDifferenceClass.maxDifference4(list2)
        println("$diff2")
        val diff4 = maxDifferenceClass.maxDifference5(list2)
        println("$diff4")

        //        assertEquals(diff, 9)
    }
}
