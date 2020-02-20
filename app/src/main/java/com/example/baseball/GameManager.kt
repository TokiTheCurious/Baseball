package com.example.baseball


class GameManager {
    private var code: List<Int> = generateCode()


    fun generateCode(): List<Int>{
        return (0..9).shuffled().take(4)
    }

    fun checkGuess(guess: List<Int>): BaseballSet {
        return checkGuess(guess,code)
    }

    fun checkGuess(guess: List<Int>, code: List<Int>): BaseballSet{
        var result = BaseballSet()

        for(g in guess){
            if(code.contains(g))
                if (code.indexOf(g) == guess.indexOf(g)) result.Hits+=1 else result.Balls+=1
        }
        return result
    }

    fun printCode(): String{
        return code.toString()
    }
}