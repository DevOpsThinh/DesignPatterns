/**
 * Prototype (also known as: Clone) is a creational DP that lets U copy existing objects
 * without making your code dependent on their classes.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.creational.prototype
/**
 *  A system that manages users & their permissions, each user must have a role, and each
 *  role has a set of permissions
 * */
data class User(
    val name: String,
    val role: Role,
    val permissions: Set<String>
) {
    fun hasPermission(permission: String) = permission in permissions
}

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}
