package bee.singleton
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
