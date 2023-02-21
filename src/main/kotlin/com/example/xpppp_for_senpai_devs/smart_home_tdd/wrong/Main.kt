package com.example.xpppp_for_senpai_devs.smart_home_tdd.wrong
//main関数、実行するとアキラくんの家のインスタンスを作って、システムを起動する。
fun main(){
    //あきらくんの家のスマートホームシステムを起動する
    val bulb = B9000()
    val switch = S9000()
    AkiraHouse(bulb,switch).run()
}
