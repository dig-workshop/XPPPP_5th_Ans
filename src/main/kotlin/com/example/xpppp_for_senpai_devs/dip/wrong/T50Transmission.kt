package DIP.Wrong

class T50Transmission{
    fun gearRatio(shiftPosition: Int): Int {
        return 3 * (5-shiftPosition)
    }
}
