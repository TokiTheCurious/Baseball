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
        var manager = GameManager(4)
        var result = manager.checkGuess(listOf(1,2,3,4), listOf(2,3,4,5))
        val expectedResult = BaseballSet(0,3,0,4)
        assertEquals(expectedResult.toString(), result.toString())

        result = manager.checkGuess(listOf(2,3,4,5), listOf(2,3,4,5))
        assertEquals("Homerun",result.toString())

        result = manager.checkGuess(listOf(1,1,1,1), listOf(2,3,4,5))
        assertEquals("Out",result.toString())

        manager = GameManager(3)

        result = manager.checkGuess(listOf(1,2,3), listOf(1,2,3))
        assertEquals("Homerun",result.toString())

    }
}