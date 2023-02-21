package DIP.Wrong

class FourAGEngine{
    fun revolution(acceleratorPosition: Int): Int {
        return acceleratorPosition * 100
    }
}




data class Rpm (
    val revolutionPerMinute : Int
)

class FiveAGEngine{
    fun revolution(acceleratorPosition: Int): Rpm {
        return Rpm(acceleratorPosition * 120)
    }
}