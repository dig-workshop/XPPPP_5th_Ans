package DIP.Right

import com.example.xpppp_for_senpai_devs.dip.right.WheelAbstraction

class NormalWheel: WheelAbstraction {
    override fun rotate(): String {
        return "ノーマルホイールが回転します！"
    }
}


//class OptionWheel: WheelAbstraction {
//    private fun rotateHighSpeed(): String {
//        return "オプションホイールが超高速回転します！"
//    }
//    override fun rotate(): String {
//        return rotateHighSpeed()
//    }
//}