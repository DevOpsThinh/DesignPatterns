/**
 * Factory method (also known as: Virtual Constructor) is a creational DP that provides
 * an interface for creating objects in a superclass, but allows subclasses to alter the type
 * of objects that will be created.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.creational.factorymethod

class Server (port: Long) { // private constructor (port: Long)
    init {
        println("Server started on port $port")
    }
    companion object Parser{
        //fun withPort(port: Long) = Server(port)
       fun withPort(port: Long): Server {
            return Server(port)
        }
    }
}