package DIP.Wrong

import DIP.Right.RsWatanabeWheel

class AE86 {
    fun accelerator(acceleratorPosition: Int, shiftPosition: Int): Double {
        //部品を集めて車を作る
        //4AGエンジンのインスタンスを作る
        val engine = FourAGEngine()
        //T50トランスミッションのインスタンスを作る
        val transmission = T50Transmission()
        //14インチホイールのRSワタナベホイールのインスタンスを作る
        val wheel = RsWatanabeWheel(14)

        //車速を計算するロジック
        //エンジン回転数
        val engineRevolution = engine.revolution(acceleratorPosition)
        //ギヤ比
        val gearRatio = transmission.gearRatio(shiftPosition)
        //タイヤの外周
        val circumference = wheel.diameter * Math.PI / 1000
        //最後に車速(km/h)を計算して出力する
        return 60 * engineRevolution * circumference / gearRatio / 1000
    }
    fun brake() {
        TODO("Describe the process to slow down")
    }
    fun turnRight() {
        TODO("Describe the process to turn right")
    }
    fun turnLeft() {
        TODO("Describe the process to turn left")
    }
}