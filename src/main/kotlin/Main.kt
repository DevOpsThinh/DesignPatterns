import bee.creational.abstractfactory.Parser
import bee.creational.builder.CarOne
import bee.creational.factorymethod.ChessPiece
import bee.creational.factorymethod.Server
import bee.creational.factorymethod.createPiece
import bee.creational.singleton.Database
import bee.creational.singleton.Student
import bee.structural.decorator.BunPhoVietDecorator
import bee.structural.decorator.DauBunMamTom

//import bee.creational.abstractfactory.Parser.ServerConfigImpl.property
//import bee.creational.abstractfactory.Parser.ServerConfigImpl.server

fun main(args: Array<String>) {
// ********************************************************************************
//                                                  Creational design patterns
// ********************************************************************************
    /**
     * The abstract factory
     * */
//    val portProperty = property("port: 8080")
//    val port: Int? = portProperty.value as? Int
//    println(server(listOf("port: 443", "environment: development")))
    val environment = Parser.server(listOf("port: 8080", "environment: production"))
    println(environment)
    /**
     *  The factory method
     * */
    val queen = createPiece("qa5")
    println(queen)
    // populating our board
    val notations = listOf("pa8", "pa5", "qc3", "qd1")
    val pieces = mutableListOf<ChessPiece>()
    for (i in notations) {
        pieces.add(createPiece(i))
    }
    println(pieces)

    Server(8080)
    Server.withPort(443)
    //val server = Server.withPort(3006)
    /**
     *  The builder pattern
     * */
    val car = CarOne(name = "HondaR", colour = "Red", breaks = "ABS", fuelType = "Petrol")
    val otherCar = CarOne(
        "AudiOne", "White", "Fours", "V8",
        "ABS", null, "Petrol"
    )

    /**
     *  The singleton pattern
     * */
    println(Database.name)
    println(Database.name)
    /*
    A singleton use case:
    * */
    val teo = Student(1, "Nguyen", "Teo")
    val ti = Student(2, "Nguyen", "Ti")

    StudentRegistry.addStudent(teo)
    StudentRegistry.addStudent(ti)
    StudentRegistry.listAllStudents()
}

/**
 * use case for a singleton is an in-memory repository for a set of data of the students list
 * */
object StudentRegistry {
    private val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudents(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach {
            println(it.fullName)
        }
    }
// ********************************************************************************
//                                                  Structural design patterns
// ********************************************************************************
    /**
     *  The Decorator pattern
     * */
    val daubun = DauBunMamTom().apply {
        cook()
    }
    val bunVietNam = BunPhoVietDecorator(daubun).apply {
        cook()
    }
}