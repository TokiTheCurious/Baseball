package com.example.baseball


class GameManager(val codeLength: Int) {
    private var code: List<Int> = generateCode()


    fun generateCode(): List<Int>{
        return (0..9).shuffled().take(codeLength)
    }

    fun checkGuess(guess: List<Int>): BaseballSet {
        return checkGuess(guess,code)
    }

    fun checkGuess(guess: List<Int>, code: List<Int>): BaseballSet{
        var result = BaseballSet(expectedMax = codeLength)

        for(g in guess){
            if(code.contains(g))
                if (code.indexOf(g) == guess.indexOf(g)) result.hits+=1 else result.balls+=1
            else
                result.misses++
        }
        return result
    }

    fun printCode(): String{
        return code.toString()
    }
}