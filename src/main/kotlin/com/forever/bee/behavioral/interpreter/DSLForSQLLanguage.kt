/**
 * Interpreter is a behavioral DP that intents given a language, define a representation for
 * its grammar along with an interpreter that uses the representation to interpret sentences
 * in the language.
 * This pattern & Kotlin's abilities to procedure DSLs with type-safe builders are compelling
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.interpreter

//                                                  package level functions
fun select(columns: String, from: SelectClause.() -> Unit): SelectClause {
    return SelectClause(columns).apply (from)
}

//                                                           classes
class SelectClause(private val columns: String) {
    private lateinit var from: FromClause

    fun from(
        table: String,
        where: FromClause.() -> Unit
    ): FromClause {
        this.from = FromClause(table)
        return this.from.apply(where)
    }

    override fun toString() = "SELECT $columns $from"
}

class FromClause(private val table: String) {
    private lateinit var where: WhereClause

    fun where(conditions: String) = this.apply {
        where = WhereClause(conditions)
    }

    override fun toString() = "FROM $table $where"
}

class WhereClause(private val conditions: String) {
    override fun toString() = "WHERE $conditions"
}
