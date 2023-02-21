package com.example.xpppp_for_senpai_devs.smart_home_tdd.right

interface SmartHome{
    var bulbWarning: Boolean
    fun bulbChanged()
    fun run()
}

fun main(){
    val bulb = B9000()
    val switch = S9000()
    val infoDisplay = D9000()
    val smartHome = AkiraHouse(bulb, switch, infoDisplay)
    smartHome.run()
}
