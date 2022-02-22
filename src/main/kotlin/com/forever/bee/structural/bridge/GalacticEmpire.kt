/**
 * Bridge (also known as: Handle/Body) is structural DP that lets u split a large class or a set of closely related classes
 * into two separate hierarchies-abstraction & implementation-which can be developed
 * independently of each other. --> The idea behind it is to flatten the class hierarchy &
 * have fewer specialized classes & avoid the fragile base class.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.bridge

//                                                      Aliases
typealias PointsOfDamage = Long
typealias Meters = Int

//                                                      Constants
const val RIFLE_DAMAGE = 3L
const val REGULAR_SPEED: Meters = 1

//                                                      Interfaces
interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
}

interface Weapon {
    fun attack(x: Long, y: Long): PointsOfDamage // type aliasing
}

interface Legs {
    fun move(x: Long, y: Long): Meters // type aliasing
}

//                                                      Classes
data class StormTrooper(
    private val weapon: Weapon,
    private val legs: Legs
) : Trooper {
    override fun move(x: Long, y: Long) {
        legs.move(x, y)
    }

    override fun attackRebel(x: Long, y: Long) {
        println("Attacking...")
        weapon.attack(x, y)
    }
}

class Rifle : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE
}

class Flamethrower : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE * 2
}
class Batton : Weapon {
    override fun attack(x: Long, y: Long) = RIFLE_DAMAGE * 3
}

class RegularLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move(x: Long, y: Long) = REGULAR_SPEED * 2
}

