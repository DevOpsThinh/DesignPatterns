/**
 * Decorator (also known as: Wrapper) is a structural DP that lets u attach new behaviors to
 * objects by placing these objects inside special wrapper objects that contain the behaviors.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.structural.decorator

interface StarTrekRepos {
    operator  fun get(starshipName: String): String
    operator fun set(starshipName: String, captainName: String)
}
/**
 *  Simple class that registers all of the captains in the Star Trek Universe with their vessels.
 * */
class DefaultStarTrekRepos : StarTrekRepos {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "ABC")
    override fun get(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun set(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}
/**
 *  Logging behavior (opt)
 * */
class LoggingGetCaptain(private val repos: StarTrekRepos) : StarTrekRepos by repos {
    override fun get(starshipName: String) : String {
        println("Getting captain for $starshipName")
        return repos[starshipName]
    }
}
/**
 *  Validating behavior (opt)
 * */
class ValidatingAdd(private val repos: StarTrekRepos) : StarTrekRepos by repos {
    private val maxNameLength = 18
    override fun set(starshipName: String, captainName: String) {
        require(captainName.length < maxNameLength) {
            "$starshipName name is longer than $maxNameLength characters!"
        }
        repos[starshipName] = captainName
    }
}

