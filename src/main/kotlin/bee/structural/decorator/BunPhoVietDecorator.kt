/**
 * Decorator (also known as: Wrapper) is a structural DP that lets u attach new behaviors to
 * objects by placing these objects inside special wrapper objects that contain the behaviors.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.structural.decorator

interface Recipe {
    fun cook()
}

class DauBunMamTom : Recipe {
    override fun cook() {
        println("Preparing Dau Bun Mam Tom....")
    }
}
// delegate recipe instance & override the functions
class BunPhoVietDecorator  (private val recipe: Recipe): Recipe by recipe {
    override fun cook() {
        recipe.cook()
        soup()
    }

    private fun soup() {
        println("Adding some soup....")
    }
}