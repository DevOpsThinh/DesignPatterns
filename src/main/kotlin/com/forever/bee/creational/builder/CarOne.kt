/**
 * Builder is a creational DP that lets u construct complex objects step by step & allows u to produce different types &
 * representations of an object using the same construction code.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.creational.builder
/**
 * The  Car's Version 1
 * A car depends on a lot of things: engine, number of doors, colors, name, transmission
 * model, braking system, etc.
 *  @author: Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
class CarOne (private  var name: String? = null, private var colour: String? = null,
private var numberOfDoors: String? = null, private var engine: String? = null,
private var breaks: String? = null, private var transmissionType: String? = null,
private var fuelType: String? = null, private var carType: String? = null)