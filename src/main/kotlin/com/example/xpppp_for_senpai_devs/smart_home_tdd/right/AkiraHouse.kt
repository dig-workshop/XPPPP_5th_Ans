package com.example.xpppp_for_senpai_devs.smart_home_tdd.right
//Step3までの実装が終わった状態です。
//wrongのコードの状態からここまで作ってもらおうと思ってます。
interface Switch {
    fun isOnCounter():Int
    fun isOnCounterReset()
    fun isOn():Boolean
}
interface Bulb {
    fun turnOn()
    fun turnOff()
}
interface InfoDisplay {
    fun displayBulbWarning()
}

class AkiraHouse (
    private val bulb: Bulb,
    private val switch: Switch,
    private val infoDisplay: InfoDisplay
): SmartHome {
    override var bulbWarning = false
    override fun run() {
            lighting()
            if(switch.isOnCounter() > 4){
                bulbWarning = true
            }
            if (bulbWarning){
                infoDisplay.displayBulbWarning()
            }
    }
   private fun lighting() {
        if(switch.isOn()){
            bulb.turnOn()
        }else{
            bulb.turnOff()
        }
    }

    override fun bulbChanged() {
        switch.isOnCounterReset()
    }
}