import com.forever.bee.behavioral.chainofresponsibility.*
import com.forever.bee.behavioral.command.Troopers
import com.forever.bee.behavioral.command.moveGenerator
import com.forever.bee.behavioral.interpreter.select
import com.forever.bee.behavioral.iterator.Squadation
import com.forever.bee.behavioral.mediator.DiegoMaradona
import com.forever.bee.behavioral.mediator.MyCompany
import com.forever.bee.behavioral.memento.MyManager
import com.forever.bee.behavioral.observer.*
import com.forever.bee.behavioral.state.Snail
import com.forever.bee.behavioral.state.Still
import com.forever.bee.behavioral.strategy.*
import com.forever.bee.behavioral.templatemethod.runSchedule
import com.forever.bee.behavioral.visitor.*
import com.forever.bee.creational.abstractfactory.Parser
import com.forever.bee.creational.builder.CarOne
import com.forever.bee.creational.builder.MailBuilder
import com.forever.bee.creational.factorymethod.ChessPiece
import com.forever.bee.creational.factorymethod.Server
import com.forever.bee.creational.factorymethod.createPiece
import com.forever.bee.creational.prototype.Role
import com.forever.bee.creational.prototype.User
import com.forever.bee.creational.singleton.Database
import com.forever.bee.creational.singleton.Student
import com.forever.bee.structural.adapter.*
import com.forever.bee.structural.bridge.*
import com.forever.bee.structural.composite.Squad
import com.forever.bee.structural.decorator.*
import com.forever.bee.structural.facade.*
import com.forever.bee.structural.flyweight.CarnivorousSnailArcade
import com.forever.bee.structural.proxy.CatImage
import java.util.stream.Stream

//import java.io.FileNotFoundException
//import kotlin.io.path.ExperimentalPathApi
//import kotlin.io.path.Path

//import com.forever.Parser.ServerConfigImpl.property
//import com.forever.Parser.ServerConfigImpl.server

private val allUsers = mutableListOf<User>()

//@OptIn(ExperimentalPathApi::class)
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
        "AudiOne", "White", "Fours", "V8", "ABS", null, "Petrol"
    )

    val mail = MailBuilder().setRecepients(listOf("nguyentruongthinhvn2020@gmail.com")).setMessage("Hi everyone!").build()

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

//    try {
//        val serverABC = ServerABC.withPort(0).startFromConfiguration("/path/to/config")
//    } catch (e: FileNotFoundException) {
//        println("If there was a file & a parser, it would have worked")
//    }
    /**
     *  The Adapter pattern
     * */
    cellPhone(
        charger(
            usPowerOutlet().toEUPlug()
        ).toUsbTypeC()
    )

    val aLowercaseLiteral = listOf("a", "b", "c")

    printStream(aLowercaseLiteral.stream())

//    val s = (Stream.generate { 42 }).toList()
//    println(s)

    /**
     * The Bridge pattern
     * */
    val stormTrooper = StormTrooper(Rifle(), RegularLegs())
    val flameTrooper = StormTrooper(Flamethrower(), RegularLegs())
    val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())
    val battonTrooper = StormTrooper(Batton(), AthleticLegs())

    println(listOf(stormTrooper, flameTrooper, scoutTrooper))
    println("--------------------------------------------")
    /**
     * The Composite pattern
     * */
    val boba = StormTrooper(Rifle(), RegularLegs())
    val squad = Squad(listOf(boba.copy(), boba.copy(), boba.copy()))
    squad.attackRebel(1, 2)

    val secondSquad = Squad(
        boba.copy(), boba.copy(), boba.copy()
    )

    println(listOf(squad, secondSquad))
    println("--------------------------------------------")
    /**
     * The Flyweight pattern
     * */
    // Flyweight allows us to create much more objects that otherwise possible
    val snails = List(10_000) { CarnivorousSnailArcade() }

    /**
     * The Proxy pattern
     * */
    val cat = CatImage(
        "https://i.chzbgr.com/full/9026714368/hBB09ABBE/i-will-has-attention", "https://i.chzbgr.com/full/9026714368/hBB09ABBE/i-will-has-attention"
    )
    println(cat.image.size)
    println(cat.thumbnailUrl)
    println(cat.url.length)

    // ********************************************************************************
    //                                                  Behavioral design patterns
    // ********************************************************************************
    /**
     *  The observer patterns
     * */
    val textInputObs = TextInputObserver(value_Observer)
    textInputObs.run {
        text = "Hi"
        text = "Anyone!"
    }

    val beeTheConductor = Bee()

    val goat = Goat()
    val dog = Dog()
    val turkey = Turkey()

    beeTheConductor.joinChoir(dog::bark)
    beeTheConductor.joinChoir(dog::howl)

    beeTheConductor.leaveChoir(dog::howl)

    beeTheConductor.conduct(5)

    /**
     *  The mediator pattern
     * */
    val productManager = DiegoMaradona
    val company = MyCompany(productManager)
    company.allTasksCompleted(true)

    /**
     *  The Chain of Responsibility - CoR
     * */
    ATM().apply {
        withdrawMoney(6000000)
        println()
        withdrawMoney(4800000)
        println()
        withdrawMoney(3500000)
    }
    println("--------------------------------------------")
    val atm = ATM()
    atm.withdrawMoney(5700000)

//    val req = Request("bee@company.com", "Who broke my build?")
//    val chain = BasicValidationHandler(
//        KnownEmailHandler(
//            JuniorDevFilterHandler(
//                AnswerHandler()
//            )
//        )
//    )
//    val res = chain.handle(red)

    val req = Request(
        "bee@company.com", "Why do we need Software Architects?"
    )
    val chain = basicValidation(authentication(finalResponse()) as Handler)
    val res = chain(req)
    println("--------------------------------------------")
    println(res)
    println("--------------------------------------------")
    /**
     *  The Memento pattern
     * */
    val alex_ferguson = MyManager()
    alex_ferguson.think("Need to implement 4-3-3 squad.")
    alex_ferguson.think("Should get some Attackers")
    val memento = alex_ferguson.saveThatThought()
    with(alex_ferguson) {
        think("Or may be Ronaldo?")
        think("No, actually, let's implement 4-4-2 squad.")
    }
    alex_ferguson.printThoughts()
    alex_ferguson.`what was I thinking back then?`(memento)
    alex_ferguson.printThoughts()
    println("--------------------------------------------")
    /**
     * The Visitor pattern
     * */
    val page = Page(
        Container(
            Image, Link, Image
        ), Table, Link, Container(
            Table, Link
        ), Container(
            Image, Container(
                Image, Link
            )
        )
    )

    println(collectLinks(page))
    println("--------------------------------------------")
    /**
     * The Template Method
     * */
    runSchedule(afterLunch = fun() {
        println("")
        println("")
    }, beforeLunch = {
        println("")
    }, readingEbook = {
        println("I'm reading it.")

    })
    println("--------------------------------------------")
    /**
     * The Interpreter pattern: Our DSL
     * */
    val query =  select("name, age") {
        from("users") {
            where("age > 29")
        } // closes from
    } // closes select
    println(query)
    println("--------------------------------------------")
    /**
     * The Strategy pattern
     * */
    val hero = OurHero()
    hero.shoot()
    hero.currentWeapon = Weapons::banana
    //hero.currentWeapon = Weapons::pomegranate
    hero.shoot()
    println("--------------------------------------------")
    /**
     * The Iterator pattern
     * */
    val platoon = Squadation(
        stormTrooper,
        Squadation(
            stormTrooper,
        ),
        Squadation(
            flameTrooper,
            flameTrooper,
        ),
        battonTrooper
    )

    val list = listOf<String>()
    list.iterator()
    // For loop range must have an iterator method
    for (trooper in platoon) {
        println(trooper)
    }
    println("--------------------------------------------")
    /**
     * The State pattern
     * */
    var snail = Snail()
    val mood = Still(snail)
    println(mood.seeHero())
    println(mood.getHit(10))
    println("--------------------------------------------")
    /**
     * The Command pattern
     * */
    val trooper = Troopers()

    trooper.addOrder(moveGenerator(trooper, 1, 1))
    trooper.addOrder(moveGenerator(trooper, 2, 2))
    trooper.addOrder(moveGenerator(trooper, 3, 3))
    trooper.addOrder(moveGenerator(trooper, 4, 4))

    trooper.executeOrders()
}

// A lazy collection of elements
fun <T> collectionProcessing(c: Collection<T>) {
    for (e in c) {
        println(e)
    }
}

// A stream is a lazy collection of elements
fun <T> streamProcessing(stream: Stream<T>) {
    // Do something.....
}

fun printStream(stream: Stream<String>) {
    stream.forEach { e -> println(e) }
}

//@ExperimentalPathApi
//fun ServerABC.startFromConfiguration(fileLocation: String) {
//    val path = Path(fileLocation)
//
//    val lines = path.toFile().readLines()
//
//    val configuration = try {
//        JsonParser().server(lines)
//    } catch (e: RuntimeException) {
//        YamlParser().server(lines)
//    }
//
//    ServerABC.withPort(configuration.port)
//}

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