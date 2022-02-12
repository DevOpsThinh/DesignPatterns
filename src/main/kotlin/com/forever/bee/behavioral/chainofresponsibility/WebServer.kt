/**
 * Chain of Responsibility (also known as: CoR, Chain of Command) is a behavioral DP
 * that lets U pass requests along a chain of handlers. Upon receiving a request, each
 * handler decides either to process the request or to pass it to the next handler in the chain.
 * --> decouple such a request & each layer will have some responsibility.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.chainofresponsibility

import kotlin.IllegalArgumentException

data class Request(val email: String, val question: String) {
    fun isKnownEmail(): Boolean {
        return true
    }

    fun isFromJuniorDeveloper(): Boolean {
        return false
    }
}

//fun handleRequest(r: Request) {
//    // Validate
//    if (r.email.isEmpty() || r.question.isEmpty()) {
//        return
//    }
//    // Authenticate, make sure that u know who is this user
//    if (r.isKnownEmail()) {
//        return
//    }
//    // Authorize, requests from juniors are automatically ignored by architects
//    if (r.isFromJuniorDeveloper()) {
//        return
//    }
//
//    println("I don't know. Did u check StackOverflow?...")
//}

//interface  Handler {
//    fun handle(request: Request): Response
//}

data class Response(val answer: String)

//class BasicValidationHandler (private val next: Handler) : Handler {
//    override fun handle(request: Request): Response {
//        if (request.email.isEmpty() || request.question.isEmpty()) {
//            throw IllegalArgumentException()
//        }
//        return next.handle(request)
//    }
//}

typealias Handler = (request: Request) -> Response

val authentication = fun(next: Handler) =
    fun(request: Request): Response {
        if (!request.isKnownEmail()) {
            throw IllegalArgumentException()
        }
        return next(request)
    }

val basicValidation = fun(_: Handler) =
    fun(_: Request): Response {
        return Response("I don't know")
    }

val finalResponse = fun() =
    fun(_: Request): Response {
        return Response("I don't know")
    }
