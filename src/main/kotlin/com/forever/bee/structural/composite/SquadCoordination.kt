/**
 * Bridge is structural DP that lets u split a large class or a set of closely related classes
 * into two separate hierarchies-abstraction & implementation-which can be developed
 * independently of each other. --> The idea behind it is to flatten the class hierarchy &
 * have fewer specialized classes & avoid the fragile base class.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.composite

import com.forever.bee.structural.bridge.Trooper

class Squad(private val units: List<Trooper>) : Trooper {

    constructor(vararg units: Trooper) : this(units.toList())

    override fun move(x: Long, y: Long) {
        for (i in units) {
            i.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (i in units) {
            i.attackRebel(x, y)
        }
    }

}
