/**
 * Mediator (also known as: Intermediary, Controller) is a behavioral DP that let reduce
 * chaotic dependencies between objects. The pattern restricts direct communications
 * between the objects & forces them to collaborate only via a mediator object.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.mediator

//                                                          Interfaces
interface QA {
    fun doesMyCodeWork(): Boolean
}

interface Parrot {
    fun isEating(): Boolean
    fun isSleeping(): Boolean
}

interface Owl {
    fun isWatchingFootball(): Boolean
}

interface Copywriter {
    fun areAllTextsCorrect(): Boolean
}

interface Kiwi {
    fun areAllTranslationsCorrect(): Boolean
}

interface ProductManager {
    fun isAllGood(majorRelease: Boolean): Boolean
}

interface Canary

//                                                          Classes - Objects
class HClinton(private val productManager: ProductManager) : QA, Parrot {

    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun isSleeping(): Boolean {
        return false
    }
}

class Ronaldo(private val productManager: ProductManager) : QA, Parrot {
    //val senior = HClinton
    //val developer = Bee
    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun isSleeping(): Boolean {
        return false
    }
}

class MyCompany(private val productManager: ProductManager) {
    val thinh = Bee
    //val qa = HClinton
    //val qa2 = Ronaldo
    //val qa3 = Messi

//    fun taskCompleted() {
//        if (!qa.isEating() && !qa.isSleeping()) {
//            println(qa.doesMyCodeWork())
//        }
//        else if (!qa2.isEating() && !qa2.isSleeping()) {
//            println(qa2.doesMyCodeWork())
//        }
//        if (!qa3.isWatchingFootball()) {
//            println(qa3.doesMyCodeWork())
//        }
//    }

    fun allTasksCompleted(isMajorRelease: Boolean) {
        println(productManager.isAllGood(isMajorRelease))
    }
}

class MyMind {
    val translator = Sandra
    fun taskCompleted(isMajorRelease: Boolean) {
        if (isMajorRelease) {
            println(translator.areAllTranslationsCorrect())
        }
    }
}

/**
 * Avid football fan
 * */
object Messi : QA, Owl {
    val developer = Bee

    //val mate = HClinton
    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isWatchingFootball(): Boolean {
        return false
    }
}

object Sandra : Copywriter, Kiwi {
    override fun areAllTextsCorrect(): Boolean {
        return true
    }

    override fun areAllTranslationsCorrect(): Boolean {
        return true
    }

}

object DiegoMaradona : Canary, ProductManager {
    private val haClinton = HClinton(this)

    //private val ronaldo = Ronaldo
    override fun isAllGood(majorRelease: Boolean): Boolean {
        if (!haClinton.isEating() && !haClinton.isSleeping()) {
            println(haClinton.doesMyCodeWork())
        }
//        else if (!ronaldo.isEating() && !ronaldo.isSleeping()) {
//            println(ronaldo.doesMyCodeWork())
//        }
        return true
    }
}

/**
 *  Me: a mobile app developer
 * */
object Bee : QA, Copywriter, Kiwi, Parrot {

    override fun doesMyCodeWork(): Boolean {
        return true
    }

    override fun isEating(): Boolean {
        return false
    }

    override fun isSleeping(): Boolean {
        return false
    }

    override fun areAllTextsCorrect(): Boolean {
        return true
    }

    override fun areAllTranslationsCorrect(): Boolean {
        return true
    }

}


