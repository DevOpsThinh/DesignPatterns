/**
 * Lets u ensure that a class has only one instance, while providing a global access point
 * to this instance.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.creational.singleton
/**
 * The  Database Object
 *  @author: Nguyen Truong Thinh
 * */
object Database {
    // Properties
    var name = "MongoDB"

    init {
        println("Creating DB")
    }
    // Functions
    fun registerDataUpdateListener(listener: DataUpdateListener) {

    }
}

interface DataUpdateListener

