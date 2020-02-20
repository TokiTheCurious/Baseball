package com.example.baseball

import junit.framework.Assert.assertEquals
import org.junit.Test

class GameManagerTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun guess_isCorrect(){
        val manager = GameManager()
        var result = manager.checkGuess(listOf(1,2,3,4), listOf(2,3,4,5))
        val expectedResult = BaseballSet(0,3)
        assertEquals(expectedResult.toString(), result.toString())

        result = manager.checkGuess(listOf(2,3,4,5), listOf(2,3,4,5))
        assertEquals("Homerun",result.toString())

        result = manager.checkGuess(listOf(1,1,1,1), listOf(2,3,4,5))
        assertEquals("Strike",result.toString())

    }
}