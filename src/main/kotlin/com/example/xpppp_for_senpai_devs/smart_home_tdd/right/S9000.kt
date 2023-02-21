package com.example.xpppp_for_senpai_devs.smart_home_tdd.right

class S9000: Switch {
    private var numberOfCalls:Int = 0
    override fun isOnCounter() :Int {
        return numberOfCalls
    }

    override fun isOnCounterReset() {
        numberOfCalls = 0
    }

    override fun isOn():Boolean {
        numberOfCalls += 1
        return true
    }
}
