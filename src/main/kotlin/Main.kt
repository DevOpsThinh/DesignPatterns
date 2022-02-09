import bee.creational.abstractfactory.Parser
import bee.creational.builder.CarOne
import bee.creational.builder.MailBuilder
import bee.creational.factorymethod.ChessPiece
import bee.creational.factorymethod.Server
import bee.creational.factorymethod.createPiece
import bee.creational.prototype.Role
import bee.creational.prototype.User
import bee.creational.singleton.Database
import bee.creational.singleton.Student
import bee.structural.decorator.*
import bee.structural.facade.UserInterface

//import bee.creational.abstractfactory.Parser.ServerConfigImpl.property
//import bee.creational.abstractfactory.Parser.ServerConfigImpl.server

private val allUsers = mutableListOf<User>()

fun main(args: Array<String>) {
// ********************************************************************************
//                                                  Creational design patterns
// ********************************************************************************
    /**
     *  The Prototype pattern
     * */
    val oriUser = User("Admin", Role.ADMIN, setOf("READ", "WRITE", "DELETE"))
    allUsers += oriUser
    createUser("OtherAdmin", Role.ADMIN)
    println(allUsers)
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

    val mail = MailBuilder()
        .setRecepients(listOf("nguyentruongthinhvn2020@gmail.com"))
        .setMessage("Hi everyone!")
        .build()

    println(mail.to)
    println(mail.cc)
    println(mail.message)
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

    val starTrekRepos = DefaultStarTrekRepos()
    val withValidating = ValidatingAdd(starTrekRepos)
    val withloggingValidating = LoggingGetCaptain(withValidating)

    withloggingValidating["USS Enterprise"]

    try {
        withloggingValidating["USS Voyagers-ss"] = "ABC ABC ABC"
    } catch (e: IllegalStateException) {
        println(e)
    }

    println(withloggingValidating is LoggingGetCaptain)
    println(withloggingValidating is StarTrekRepos)

    /**
     *  The Facade pattern
     * */
    val userInterface = UserInterface()
    with(userInterface) {
        browseInternet()
        playMedia()
        manageDocs()
    }
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
}

fun createUser(_name: String, role: Role) {
    for (i in allUsers) {
        if (i.role == role) {
            allUsers += i.copy(name = _name)
            return
        }
    }
}