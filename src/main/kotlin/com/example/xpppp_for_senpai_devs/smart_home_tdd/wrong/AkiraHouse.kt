package com.example.xpppp_for_senpai_devs.smart_home_tdd.wrong
//アキラくんの家を表すクラス
class AkiraHouse(val bulb: B9000, val switch: S9000) {
    //runメソッドでスマートホームのシステムを起動する
    //今はとりあえず照明の管理だけ
    fun run(){
            lighting(bulb, switch)
    }
    //ここから下は各部屋の照明を管理するメソッド
    private fun lighting(bulb: B9000, switch: S9000){
        if(switch.isON()){
            bulb.turnOn()
        }else{
            bulb.turnOff()
        }
    }
}