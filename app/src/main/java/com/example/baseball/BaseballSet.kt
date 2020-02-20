package com.example.baseball

class BaseballSet(var hits: Int = 0, var balls:Int = 0, var misses: Int = 0,val expectedMax: Int){
    override fun toString(): String {
        if(misses == expectedMax)
            return "Out"
        else if(hits == expectedMax)
            return "Homerun"
        else {
            val h = if (hits > 0) "${hits}H" else ""
            val b = if (balls > 0) "${balls}B" else ""
            return "$h$b"
        }
    }
}
