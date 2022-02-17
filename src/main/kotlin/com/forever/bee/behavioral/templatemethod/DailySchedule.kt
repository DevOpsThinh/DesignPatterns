/**
 * Template method is a behavioral DP that  defines the skeleton of an algorithm in the
 * superclass but lets subclass override specific steps of the algorithm without changing
 * its structure.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.templatemethod

/*
* Some lazy people make art out of their laziness. Take me, for example. Here's my daily
* schedule (Working from home - Remote):
* 1. 8h00 am - 9h30 am: Hardworking;
* 2. 9h30 am - 10h00 am: Rest - Tired break;
* 3. 10h00 am - 11h30 am: Hardworking;
* 4. 11h30 am - 1h00 pm: Go out for lunch;
* 5. 1h00 pm - 2h30 pm: Attend some meetings or review code
* 6. 2h30 pm - 5h00pm: Hardworking;
* 7. 5h00 pm: Sneak back home.
* */

abstract class DayRoutine {
    protected fun joinInWork() {
        println("Hi boss! I've been joining in work on my desk at my home!")
    }

    protected fun tiredBreak() {
        println("Hi boss! I'm resting.")
    }

    protected fun goToLunch() {
        println("Chicken & Rice. It's awesome!!")
    }

    protected fun goToDinner() {
        println("Hi boss! Bye Bye, see u again :<3")
    }

    abstract fun doBeforeLunch()
    abstract fun doAfterLunch()

    open fun readingEbook() {
        println("What? 8h00 pm! Reading an ebook now!!")
    }

    fun funSchedule() {
        joinInWork()
        tiredBreak()
        doBeforeLunch()
        goToLunch()
        doAfterLunch()
        goToDinner()
        readingEbook()
    }
}

class MondaySchedule : DayRoutine() {
    override fun doBeforeLunch() {
        println("I've been developed the splash layout using DSL with the external library: Anko.")
    }

    override fun doAfterLunch() {
        println("Some pointless meeting")
        println("Code review. What this code?")
    }

    override fun readingEbook() {
        super.readingEbook()
        println("\nThat's Exploring Kotlin.")
    }

    fun funSchedule(
        beforeLunch: () -> Unit,
        afterLunch: () -> Unit,
        readingEbook: (() -> Unit)? = fun() { println() }
    ) {
        joinInWork()
        tiredBreak()
        beforeLunch
        goToLunch()
        afterLunch()
        goToDinner()
        readingEbook?.let { it() }
    }
}

//                                                      package leve functions
fun runSchedule(
    beforeLunch: () -> Unit,
    afterLunch: () -> Unit,
    readingEbook: (() -> Unit)? = fun() { println() }
) {
    // local functions
    fun joinInWork() {
        println("Hardworking....")
    }

    val tiredBreak = {
        println("I'm tired")
    }

    fun goToLunch() = println("Rice & Meat?")
    val goToDinner = fun() {
        println("Finally some rest")
    }

    joinInWork()
    tiredBreak()
    beforeLunch()
    goToLunch()
    afterLunch()
    goToDinner()
    readingEbook?.let { it() }
}