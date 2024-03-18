package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.Bulb
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.InfoDisplay


class SpyBulb: Bulb {
    var turnOnWasCalled = false
    var turnOffWasCalled = false

    override fun turnOn() {
        this.turnOnWasCalled = true
    }

    override fun turnOff() {
        this.turnOffWasCalled = true
    }
}