package com.example.xpppp_for_senpai_devs.smart_home_tdd



import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.S9000
import junit.framework.TestCase.*
import org.junit.jupiter.api.Test

class SwitchTest {
    @Test
    fun `switchのisOnメソッドが実行された回数をswitchIsOnCounterに保存する`() {
        val switch1 = S9000()

        switch1.isOn()
        assertEquals(switch1.isOnCounter(), 1)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(), 2)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(), 3)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(), 4)
    }

    @Test
    fun `isOnCounterResetが呼ばれたらisOnCounterを0にする`() {
        val switch = S9000()

        switch.isOn()
        assertEquals(switch.isOnCounter(), 1)
        switch.isOnCounterReset()
        assertEquals(switch.isOnCounter(), 0)
    }
}