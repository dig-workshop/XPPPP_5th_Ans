package com.example.xpppp_for_senpai_devs.smart_home_tdd.right

class B9000 : Bulb {
    override fun turnOn() {
        print("照明を点灯しました")
    }
    override fun turnOff() {
        print("照明を消灯しました")
    }
}
