/**
 * Lets u ensure that a class has only one instance, while providing a global access point
 * to this instance.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.creational.singleton
/**
 *  A singleton use case: An app that needs a registry of students
 * */
data class Student(
    val id: Int,
    val firstName: String,
    val lastName: String
) {
    var fullName = "$lastName, $firstName"
}
