package DIP.Right

import com.example.xpppp_for_senpai_devs.dip.right.Transmission

class T50Transmission: Transmission {
    override fun gearRatio(shiftPosition: Int): Int {
        return 3 * (5-shiftPosition)
    }
}
