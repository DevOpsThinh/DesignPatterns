import bee.builder.CarOne
import bee.singleton.Database
import bee.singleton.Student

fun main(args: Array<String>) {
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
    val teo = Student(1, "Nguyen", "Teo" )
    val ti = Student(2, "Nguyen", "Ti" )

    StudentRegistry.addStudent(teo)
    StudentRegistry.addStudent(ti)
    StudentRegistry.listAllStudents()
}

object StudentRegistry {
    val allStudents = mutableListOf<Student>()

    fun addStudent(student: Student) {
        allStudents.add(student)
    }

    fun removeStudents(student: Student) {
        allStudents.remove(student)
    }

    fun listAllStudents() {
        allStudents.forEach{
            println(it.fullName)
        }
    }
}