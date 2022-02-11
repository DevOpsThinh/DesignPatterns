/**
 * Adapter (also known as: Wrapper) is a structural DP that allows objects with
 * incompatible interfaces to collaborate.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.adapter

/*
* With 7% battery left on your phone. Your phone charger was left in the office at the other
* end of the city. U only have an EU plug charger with a Mini USB cable. But your phone
* uses USB-C, as U had to upgrade. You're in Binh Phuoc Province (of VietNam), so all of
* your outlets are (of course) USB-A. So, what do you do? Oh, it's easy. U look for a Mini
* USB to USB-C adapter in the middle of the night & hope that U have remembered to
* bring U EU to US plug adapter as well. Only 5% battery left -time is running out!
*  ( "I changed some words from the author's context just to give me more interest :)" )
* */

//                                          package level functions

/**
 *  Bring the power value from a US power outlet to our cellphone
 * */
fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("I've Got The Power!")
    } else {
        println("No power")
    }
}

/**
 * *Power outlet exposes USPlug interface
 */
fun usPowerOutlet(): USPlug {
    return object : USPlug { // An anonymous class
        //        override val hasPower: Int
//            get() = 1
        override val hasPower = 1
    }
}

/**
 *  Charger accepts EUPlug interface & exposes UsbMini interface
 * */
fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini { // An anonymous class
        //        override val hasPower: Power
//            get() = Power.valueOf(plug.hasPower)
        override val hasPower = Power.valueOf(plug.hasPower)
    }
}

//                                                extension functions
/**
 *  adapt the US plug to work with the Eu plug
 * */
fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug {
        // Transfer power
//        override val hasPower: String
//            get() = hasPower
        override val hasPower = hasPower
    }
}

/**
 *  create a USB adapter
 * */
fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        //        override val hasPower: Boolean
//            get() = hasPower
        override val hasPower = hasPower

    }
}

//                                          enumerators
enum class Power {
    TRUE, FALSE
}

//                                          Interfaces
interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String // "True" or "False"
}

interface UsbMini {
    val hasPower: Power
}

interface UsbTypeC {
    val hasPower: Boolean
}



