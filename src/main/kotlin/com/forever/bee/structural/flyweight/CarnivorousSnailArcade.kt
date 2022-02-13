/**
 * Flyweight (also known as: Cache) is a structural DP that let u fit more objects into the
 * available amount of RAM by sharing common parts of state between multiple objects
 * instead of keeping all the data in each object. Flyweight is an object without any state.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.flyweight

import java.io.File

/*
* We're building a 2D side-scrolling arcade platform game.
* Using only 16 colors in our game & our character is 64 * 64 pixels
* */

enum class Direction {
    LEFT,
    RIGHT
}
/**
 * Carnivorous Tanzanian snails
 * */
class CarnivorousSnailArcade {
    val directionFacing = Direction.LEFT

    val sprites = SnailSprites.sprites // the Flyweight

    //val sprites = listOf(File("snail_left.jpg"), File("snail_right.jpg"))
//    val sprites = List(8) { i ->
//        File(when (i) {
//            0 -> "snail_left.jpg"
//            1 -> "snail_right.jpg"
//            in 2..4 -> "snail_move_left_${i -1}.jpg"
//            else -> "snail_move_right ${4 - i}.jpg"
//        })
//    }
    // More info comes here...

    fun getCurrentSprite() : File {
        return when (directionFacing) {
            Direction.LEFT -> sprites[0]
            Direction.RIGHT -> sprites[1]
        }
    }
}

object SnailSprites {
    val sprites = List(8) { i ->
        File(when (i) {
            0 -> "snail_left.jpg"
            1 -> "snail_right.jpg"
            in 2..4 -> "snail_move_left_${i -1}.jpg"
            else -> "snail_move_right ${4 - i}.jpg"
        })
    }
}