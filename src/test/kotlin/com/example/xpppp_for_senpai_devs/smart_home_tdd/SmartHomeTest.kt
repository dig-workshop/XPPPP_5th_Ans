package com.example.xpppp_for_senpai_devs.smart_home_tdd


import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.AkiraHouse
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.B9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.S9000
import com.example.xpppp_for_senpai_devs.smart_home_tdd.right.SmartHome
import junit.framework.TestCase.*
import org.junit.jupiter.api.Test

class SmartHomeTest {
    @Test
    fun `bulbWarningがTrueの時、システムを起動すると「電球を交換してください。」を表示する`() {
        val bulb = B9000()
        val switch = S9000()
        val spyInfoDisplay = SpyInfoDisplay()

        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)
        smartHome.bulbWarning = true
        smartHome.run()

        assertTrue(spyInfoDisplay.displayBulbWarningWasCalled)
    }

    @Test
    fun `isOnCounterが５になったら、bulbWarningをtrueにする`() {
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()

        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)
        switch.isOnCounterReturnValue = 5
        smartHome.run()

        assertTrue(smartHome.bulbWarning)
    }

    @Test
    fun `電球交換したら、isOnCounterResetをよぶ`() {
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)

        smartHome.bulbChanged()

        assertTrue(switch.isOnCounterResetWasCalled)
    }

    @Test
    fun `isOnCounterが0の時、システムを起動したら、bulbWarningをfalseにする`() {
        val bulb = B9000()
        val switch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)
        switch.isOnCounterReturnValue = 0

        smartHome.run()

        assertFalse(smartHome.bulbWarning)
    }

    @Test
    fun `システムを起動したら、「照明を点灯しました」を表示する`() {
        val bulb = SpyBulb()
        val switch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)

        smartHome.run()

        assertTrue(bulb.turnOnWasCalled)
    }

    @Test
    fun `システムを起動したら、1秒後に「照明を消灯しました」を表示する`() {
        val bulb = SpyBulb()
        val switch = StubSwitch()
        val spyInfoDisplay = SpyInfoDisplay()
        val smartHome: SmartHome = AkiraHouse(bulb, switch, spyInfoDisplay)

        smartHome.run()
        Thread.sleep(1001)

        assertTrue(bulb.turnOffWasCalled)
    }
}