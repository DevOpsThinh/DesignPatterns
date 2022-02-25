/**
 * State - as an opinionated strategy pattern (also known as: Objects for states) is a behavioral DP that let an object alter its behavior when it's internal state
 * changes. It appears as if the object changed it's class.
 * */
package com.forever.bee.behavioral.state

/**
 * What can happen during a snail's life.
 * */
interface LifeOfSnail {
    fun seeHero()
    fun getHit(pointsOfDamage: Int)
    fun calmAgain()
}
/**
 * Snail object.
 * */
class Snail{
    private var healthPoints = 10

   // private var mood: Mood = Still
    internal var mood: Mood = Still(this)



//    override fun seeHero() {
//        mood = when (mood) {
//            is Still -> Aggressive
//            else -> mood // No change
//        }
//    }
//
//    override fun getHit(pointsOfDamage: Int) {
//        healthPoints -= pointsOfDamage
//
//        mood = when {
//            (healthPoints <= 0) -> Dead
//            mood is Aggressive -> Retreating // is == instanceof
//            else -> mood // No change
//        }
//    }
//
//    override fun calmAgain() {
//
//    }
}
/**
 * Moods of a snail.
 * */
sealed class Mood: LifeOfSnail {
    // some abstract methods here, like draw(), for example
}

class Still(private val snail: Snail): Mood() {
    override fun seeHero() {
        println("Aggressive")
        snail.mood = Aggressive
    }

    override fun getHit(pointsOfDamage: Int)  {
        println("Retreating")
        snail.mood = Retreating
    }

    override fun calmAgain() {
        println("No change")
        // return to still state
    }

}
object Aggressive: Mood() {
    override fun seeHero() {
        //
    }

    override fun getHit(pointsOfDamage: Int) {
        //
    }

    override fun calmAgain() {
        //
    }
}

object Retreating: Mood() {
    override fun seeHero() {
        //
    }

    override fun getHit(pointsOfDamage: Int) {
        //
    }

    override fun calmAgain() {
        //
    }
}

object Dead: Mood() {
    override fun seeHero() {
        //
    }

    override fun getHit(pointsOfDamage: Int) {
        //
    }

    override fun calmAgain() {
        //
    }
}
