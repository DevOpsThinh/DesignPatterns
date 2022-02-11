/**
 * Observer (also known as: Event-Subscriber, Listener) is a behavioral DP that let U define
 * a subscription mechanism to notify multiple objects about any events that happen to
 * the object they're observing.
 * "Core philosophy: The fundamental of reactive programming is observing a change".
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.observer

import kotlin.properties.Delegates

/**
 * Observing a text value change with delegated properties in Kotlin
 * */
class TextInputObserver (valueObserver: (String, String) -> Unit) {
    var text: String by Delegates.observable("") {prop, old, new ->
        valueObserver.invoke(old, new)
    }
}

val value_Observer: (String, String) -> Unit = {
    oldText, newText -> println("Observer notified. Value changed from $oldText to $newText")
}