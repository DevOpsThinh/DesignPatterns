/**
 * Lets u produce families of related objects without specifying their concrete classes.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.creational.abstractfactory

class Parser {

    companion object ServerConfigImpl {
        fun server(propertyStrings: List<String>): ServerConfiguration {
            val parsedProperties = mutableListOf<Property>()
            for (i in propertyStrings) {
                parsedProperties += property(i)
            }
            return  ServerConfigurationImpl(parsedProperties)
        }

         fun property(prop: String): Property {
            val (name, value ) = prop.split(":")

            return when(name) {
                //"port" -> PropertyImpl(name, value.trim().toInt())
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value.trim())
                else -> throw RuntimeException("Unknown property: $name")
            }
        }
    }
}

//data class PropertyImpl(
//    override val name: String,
//    override val value: Any
//): Property

class StringProperty(
    override  val name: String,
    override val value: String
) : Property

data class IntProperty(
    override val name: String,
    override val value: Int
): Property

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration

interface Property {
    val name: String
    val value: Any
}

interface ServerConfiguration {
    val properties: List<Property>
}
