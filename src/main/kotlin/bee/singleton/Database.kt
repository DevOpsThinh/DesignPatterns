package bee.singleton
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

