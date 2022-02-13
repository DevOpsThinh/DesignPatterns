/**
 * Composite (also known as: Object Tree) is a structural DP that lets u compose objects
 * into tree structures & then work with these structures as if they were individual objects.
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
