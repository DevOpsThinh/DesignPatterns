/**
 * Factory method (also known as: Virtual Constructor) is a creational DP that provides
 * an interface for creating objects in a superclass, but allows subclasses to alter the type
 * of objects that will be created.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.creational.factorymethod

interface  ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(
    override val file: Char,
    override val  rank: Char
): ChessPiece

data class Queen(
    override val file: Char,
    override val rank: Char
): ChessPiece

fun createPiece(notation: String): ChessPiece {
    val (type, file, rank) = notation.toCharArray()

    return  when (type) {
        'q' -> Queen(file, rank)
        'p' -> Pawn(file, rank)

        else -> throw RuntimeException("Unknown piece: $type")
    }
}