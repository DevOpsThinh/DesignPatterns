/**
 * Observer  (also known as: Event-Subscriber, Listener) is a behavioral DP that let U define
 * a subscription mechanism to notify multiple objects about any events that happen to
 * the object they're observing.
 * " Core philosophy: The fundamental of reactive programming is observing a change".
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.observer

/*
 *  Some animals have decided to have a choir of their own. The Bee was elected as the
 *  conductor of the choir.
 * */
/**
 *  To describe the different types of pitches
 * */
enum class SoundPitch { HIGH, LOW }

/**
 *  To encapsulate the pitch to be used, as well as how many times the message should
 *  be repeated.
 * */
interface Message {
    val repeat: Times
    val pitch: SoundPitch
}

data class LowMessage(override val repeat: Times ): Message {
    override val pitch: SoundPitch
        get() = SoundPitch.LOW
}

data class HighMessage(override val repeat: Times ): Message {
    override val pitch: SoundPitch
        get() = SoundPitch.HIGH
}

class Goat {
    fun screech(message: Message) {
        when (message) {
            is HighMessage -> {
                for (i in 1..message.repeat) {
                    println("${message.pitch} Beee heee Beee")
                }
            }
            else -> println("Can't : (")
        }
    }
}

class Turkey {
    fun gobble(repeat: Times) {
        for (i in 1..repeat) {
            println("Gob-gob")
        }
    }
}

class Dog {
    fun bark() {
        println("Woof Woof")
    }

    fun howl() {
        println("Auhuuuu")
    }
}

typealias  Times = Int

/**
 *  The conductor of the Rehearsal
 * */
class Bee {
    private val participants = mutableMapOf<() -> Unit, () -> Unit>()
    fun joinChoir(whatToCall: () -> Unit) {
        participants[whatToCall] = whatToCall
    }

    fun leaveChoir(whatNotToCall: () -> Unit) {
        participants.remove(whatNotToCall)
    }

    fun conduct(n: Times) {
        for (p in participants.values) {
            for (i in 1..n) {
                p()
            }
        }
    }
}