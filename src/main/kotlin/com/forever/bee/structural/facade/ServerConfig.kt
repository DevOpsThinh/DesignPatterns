/**
 * Facade is a structural DP that provides a simplified interface to a library, a framework, or
 * any other complex set of classes -> front of any building which opens to street or some
 * open ground -> to hide the complexity of a lof other small systems.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.facade

interface Parser {
    fun property(prop: String): Property
    fun server(propertyString: List<String>): ServerConfiguration
}

class ServerConfiguration {
    var port: Int = 8080
}

class Property

class ServerABC private constructor(port: Int) {
    companion object Parser {
        fun withPort(port: Int): ServerABC {
            return ServerABC(port)
        }
    }
}

class YamlParser : Parser {
    // Implementation specific to YAML files
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(propertyString: List<String>): ServerConfiguration {
        TODO("Not yet implemented")
    }

}

class JsonParser : Parser {
    // Implementation specific to JSON files
    override fun property(prop: String): Property {
        TODO("Not yet implemented")
    }

    override fun server(propertyString: List<String>): ServerConfiguration {
        TODO("Not yet implemented")
    }
}