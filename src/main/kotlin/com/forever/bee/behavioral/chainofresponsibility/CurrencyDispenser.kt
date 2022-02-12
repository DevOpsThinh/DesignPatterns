/**
 * Chain of Responsibility (also known as: CoR, Chain of Command) is a behavioral DP
 * that lets U pass requests along a chain of handlers. Upon receiving a request, each
 * handler decides either to process the request or to pass it to the next handler in the chain.
 * --> decouple such a request & each layer will have some responsibility.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.chainofresponsibility

/*
* ATM accepts input from a user & dispenses some money. It calculates what number of
* which currency value should be returned to the user. Based on the amount U have entered
* it calculates the currency notes & dispenses it to U. This can be done using a CoR.
* */

interface CurrencyDispenser {
    val currencyValue: Int
    val nextDispenser: CurrencyDispenser?
    fun dispenseMo(amount: Int)
}

class DispenseOne(override val currencyValue: Int = 1000000, override val nextDispenser: CurrencyDispenser? = null) : CurrencyDispenser {
    override fun dispenseMo(amount: Int) {
        if (amount >= currencyValue) {
            val (quantity, remainder) = amount.getQuantityAndRemainder(currencyValue)
            println("Dispensing $quantity of $currencyValue")
            if (remainder > 0) {
                println("Amount must be in multiple of  1000000 vnd")
            }
        } else if (amount != 0) {
            println("Amount must be in multiple of  1000000 vnd")
        }
    }
}

class DispenseTwo(override val nextDispenser: CurrencyDispenser? = null, override val currencyValue: Int = 2000000) : CurrencyDispenser {
    override fun dispenseMo(amount: Int) {
        if (amount >= currencyValue) {
            val (quantity, remainder) = amount.getQuantityAndRemainder(currencyValue)
            println("Dispensing $quantity of $currencyValue")
            nextDispenser?.dispenseMo(remainder)
        } else {
            nextDispenser?.dispenseMo(amount)
        }
    }
}

class DispenseThree(override val nextDispenser: CurrencyDispenser? = null, override val currencyValue: Int = 3000000) : CurrencyDispenser {
    override fun dispenseMo(amount: Int) {
        if (amount >= currencyValue) {
            val (quantity, remainder) = amount.getQuantityAndRemainder(currencyValue)
            println("Dispensing $quantity of $currencyValue")
            nextDispenser?.dispenseMo(remainder)
        } else {
            nextDispenser?.dispenseMo(amount)
        }
    }
}

class ATM {
    private val one = DispenseOne()
    private val two = DispenseTwo(one)
    private val three = DispenseThree(two)

    fun withdrawMoney(amount: Int) {
        three.dispenseMo(amount)
        println("Denominations for $amount")
    }
}

//                                              Extension functions
private fun Int.getQuantityAndRemainder(currencyValue: Int): Pair<Int, Int> {
    val quantity = this / currencyValue
    val remainder = this % currencyValue
    return Pair(quantity, remainder)
}