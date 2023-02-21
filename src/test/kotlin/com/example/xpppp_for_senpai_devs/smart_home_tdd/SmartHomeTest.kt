package com.example.xpppp_for_senpai_devs.smart_home_tdd


import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.S9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.SmartHome
import junit.framework.TestCase.*
import org.junit.jupiter.api.Test

class SmartHomeTest {
    //本来はファイル分けた方が良いところあるけど、面倒だったのでとりあえずまとめて書いてしまった。。。
    //とりあえずStep3までの模範解答として書いたつもり。ツッコミ、修正お願いします。
    @Test
    fun `bulbWarningがTrueの時、システムを起動すると「電球を交換してください。」を表示する`(){
        val bulb = B9000()
        val switch = S9000()
        val spyInfoDisplay= SpyInfoDisplay()

        val smartHome : SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)
        smartHome.bulbWarning = true
        smartHome.run()


        assertTrue(spyInfoDisplay.displayBulbWarningWasCalled)
    }

    //スイッチのテストに書くべき
    @Test
    fun `switchのisOnメソッドが実行された回数をswitchIsOnCounterに保存する`(){
        val switch1 = S9000()

        switch1.isOn()
        assertEquals(switch1.isOnCounter(),1)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(),2)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(),3)
        switch1.isOn()
        assertEquals(switch1.isOnCounter(),4)
    }

    @Test
    fun `isOnCounterが５になったら、bulbWarningをtrueにする`(){
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay= SpyInfoDisplay()

        val smartHome : SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)
        switch.isOnCounterReturnValue = 5
        smartHome.run()

        assertTrue(smartHome.bulbWarning)
    }

    @Test
    fun `電球交換したら、isOnCounterResetをよぶ`(){
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay= SpyInfoDisplay()
        val smartHome : SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)

        smartHome.bulbChanged()

        assertTrue(switch.isOnCounterResetWasCalled)
    }

    //スイッチのテストに書くべき
    @Test
    fun `isOnCounterResetが呼ばれたらisOnCounterを0にする`(){
        val switch = S9000()
        switch.isOn()
        assertEquals(switch.isOnCounter(),1)
        switch.isOnCounterReset()
        assertEquals(switch.isOnCounter(),0)
    }

    @Test
    fun `isOnCounterが0の時、システムを起動したら、bulbWarningをfalseにする`(){
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay= SpyInfoDisplay()
        val smartHome : SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)

        switch.isOnCounterReturnValue = 0

        smartHome.run()

        assertFalse(smartHome.bulbWarning)
    }
}