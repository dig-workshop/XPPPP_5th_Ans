package DIP.Right

import com.example.xpppp_for_senpai_devs.dip.right.Engine

class FourAGEngine : Engine {
    override fun revolution(acceleratorPosition: Int): Int {
        return acceleratorPosition * 100
    }
}



//data class Rpm (
//    val revolutionPerMinute : Int
//)
//
//class FiveAGEngine : Engine {
//    override fun revolution(acceleratorPosition: Int): Rpm {
//        return Rpm(acceleratorPosition * 120)
//    }
//}