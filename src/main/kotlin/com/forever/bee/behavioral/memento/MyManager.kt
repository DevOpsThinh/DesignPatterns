/**
 * Memento (also known as: Snapshot) is a behavioral DP that let u save & restore the
 * previous state of an object (the internal state) without revealing the details of its implementation.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.memento

class MyManager {
    private var thoughts = mutableListOf<String>()

    fun printThoughts() {
        println(thoughts)
    }

    inner class Memory( private val mindState: List<String>) {
        fun restore() {
            thoughts = mindState.toMutableList()
        }
    }

    fun saveThatThought() : Memory {
        return Memory(thoughts.toList())
    }

    fun `what was I thinking back then?` (memory: Memory) {
        memory.restore()
    }

    fun think(thought: String) {
        thoughts.add(thought)
        if (thoughts.size > 2) {
            thoughts.removeFirst()
        }
    }
}