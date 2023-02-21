package com.example.xpppp_for_senpai_devs.smart_home_tdd

import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.Switch

class StubSwitch : Switch {
    var isOnCounterReturnValue = 0
    var isOnCounterResetWasCalled = false
    override fun isOnCounter(): Int {
        return isOnCounterReturnValue
    }
    override fun isOnCounterReset() {
        isOnCounterResetWasCalled = true
    }
    //これ必要ないから描きたくないんだけど書かなくて良い方法ないの？？
    override fun isOn(): Boolean {
        return true
    }
}
