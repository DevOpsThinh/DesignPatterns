/**
 * Strategy (also known as: Policy) is a behavioral DP that lets u define a family of algorithms, put each of them
 * into a separate class, and make their objects interchangeable -> is to allow an object to
 * alter its behavior at runtime.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.strategy

enum class Direction {
    LEFT, RIGHT
}

interface Weapon {
    fun shoot(x: Int, y: Int, direction: Direction): Projecttile
}

data class Projecttile
    (
    private var x: Int,
    private var y: Int,
    private var direction: Direction
)

/**
 * Flies straight
 * */
class Peashooter : Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction): Projecttile {
        return Projecttile(x, y, direction)
    }
}

/**
 * Returns back after reaching end or the screen
 * */
class Banana : Weapon {
    override fun shoot(x: Int, y: Int, direction: Direction): Projecttile {
        return Projecttile(x, y, direction)
    }
}

class OurHero {
    private var x: Int = 49
    private var y: Int = 173
    private var direction = Direction.LEFT

//    private var currentWeapon: Weapon = Peashooter()

//    fun shoot(): Projecttile {
//        return Projecttile(x, y , direction)
//    }

//    fun shoot(): Projecttile = currentWeapon.shoot(x, y, direction)

//    fun equip(weapon: Weapon) {
//        currentWeapon = weapon
//    }

    var currentWeapon = Weapons::peashooter

    val shoot = fun() {
        currentWeapon(x, y, direction)
    }
}

object Weapons {
    fun peashooter(x: Int, y: Int, direction: Direction): Projecttile {
        println("It's a peashooter")
        return Projecttile(x, y, direction)
    }

    fun banana(x: Int, y: Int, direction: Direction): Projecttile {
        println("It's a banana")
        return Projecttile(x, y, direction)
    }

    fun pomegranate(x: Int, y: Int, direction: Direction): Projecttile {
        println("It's a pomegranate")
        return Projecttile(x, y, direction)
    }
}