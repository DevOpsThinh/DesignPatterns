/**
 * Command (also known as: Action, Transaction) is a behavioral DP that turns a request
 * into a stand-alone object that contains all information about the request. This
 * transformation lets u parameterize methods with different request, delay or queue a
 * request's execution, & support undoable operations.
 * */
package com.forever.bee.behavioral.command

typealias Command = () -> Unit

class Troopers{
    private val orders = mutableListOf<Command>()
    // private val commands = mutableListOf<Pair<Command, Command>>()

    fun addOrder(order: Command) {
        this.orders.add(order)
    }

    fun executeOrders() {
        while (orders.isNotEmpty()) {
            val order = orders.removeFirst()
            //order.invoke()
            order() // executed the next order
        }
    }

    fun move(x: Int, y: Int) {
        println("Moving to ($x:$y)")
    }

//    fun appendMove(x: Int, y: Int) = apply { // higher-order function.
//        //commands.add(moveGenerator(this, x, y))
//        val oppositeMove = /* If it's the first command, generate move to current location.
//        Otherwise, get the previous command */
//        commands.add(moveGenerator(this, x, y) to oppositeMove)
//    }
}

val moveGenerator = fun(trooper: Troopers, x: Int, y: Int): Command { // higher-order function.
    return fun() {
        trooper.move(x, y)
    }
}