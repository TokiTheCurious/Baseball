package com.example.baseball

class BaseballSet(var Hits: Int = 0, var Balls:Int = 0){
    override fun toString(): String {
        if(Hits == 0 && Balls == 0)
            return "Strike"
        else if(Hits == 4)
            return "Homerun"
        else {
            val h = if (Hits > 0) "${Hits}H" else ""
            val b = if (Balls > 0) "${Balls}B" else ""
            return "$h$b"
        }
    }
}
