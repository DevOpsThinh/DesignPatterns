/**
 * Iterator (also known as: Cursor) is a behavioral DP that lets u traverse elements of a
 * collection without exposing its underlying representation( List, stack, tree, etc.).
 * => it flattens our complex data structure in to a simple sequence of elements.
 * The order of the elements & what elements to ignore is for the iterator to decide.
 * */
package com.forever.bee.behavioral.iterator

import com.forever.bee.structural.bridge.Trooper


class Squadation(private val units: List<Trooper>): Trooper {

    constructor(vararg units: Trooper): this(units.toList())

    operator fun iterator(): Iterator<Trooper> {
        return TrooperIterator(units)
    }

    override fun move(x: Long, y: Long) {
        TODO("Not yet implemented")
    }

    override fun attackRebel(x: Long, y: Long) {
        TODO("Not yet implemented")
    }
}

class TrooperIterator(private val units: List<Trooper>) : Iterator<Trooper> {
    private var i = 0
    private var iterator: Iterator<Trooper> = this
    override fun hasNext(): Boolean {
        // are there more objects to iterate over?
        if (i >= units.size) {
            return false
        }
        if (i == units.size - 1) {
            if (iterator != this) {
                return iterator.hasNext()
            }
        }
        return true
    }

    override fun next(): Trooper {
        if (iterator != this) {
            if (iterator.hasNext()) {
                return iterator.next()
            }else {
                i++
                iterator = this
            }
        }
        // return next Trooper: unit to return
        return when (val e = units[i]) {
            is Squadation -> {
                iterator = e.iterator()
                this.next()
            }
            else -> {
                i++
                e
            }
        }
    }
}
