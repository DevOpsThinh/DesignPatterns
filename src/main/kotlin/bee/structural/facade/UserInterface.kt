/**
 * Facade is a structural DP that provides a simplified interface to a library, a framework, or
 * any other complex set of classes -> front of any building which opens to street or some
 * open ground -> to hide the complexity of a lof other small systems.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package bee.structural.facade
/**
 *  A small Operating System that has only three programs in it: Media Player, Network
 *  Service and File Manager.
 * */
data class UserInterface (
    private val mediaPlayer: MediaPlayer = MediaPlayer(),
    private val netService: NetworkService = NetworkService(),
    private val fileManager: FileManager = FileManager()
) {
    fun manageDocs() {
        fileManager.makeDocuments()
    }

    fun  browseInternet() {
        netService.browserServer()
    }

    fun playMedia() {
        mediaPlayer.playMedia()
    }
}

class FileManager {
    fun makeDocuments() {
        println("Creating a doc ....")
    }
}

class NetworkService {
    fun browserServer() {
        println("Loading data from http://wiki.ros.org/")
    }
}

class MediaPlayer {
    fun playMedia() {
        println("Playing rviz...")
    }
}
