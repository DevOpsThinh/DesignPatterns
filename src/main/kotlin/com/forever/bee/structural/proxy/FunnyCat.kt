/**
 * Proxy (Sub-patterns: virtual - remote - protection or access control proxy) is a structural DP that let u provide a substitute or placeholder for another object.
 * It controls access to the original object, allowing u to perform something either before
 * or after the request gets through to the original object.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.structural.proxy

import java.net.URL

/*
* We at the Funny Cat App provide our users with funny cat images on a daily basis.
* On our homepage & mobile app, each user sees a lot of pictures of funny cats. When
* they click or touch any of those images, it expands to its full-screen glory.
* Fetching cat images over the network is very expensive, anh it consumes a lof of memory,
* especially if those are images of cats that tend to indulge in a second dessert after dinner.
* What we want to do is fetch the full-sized image only once at the time it is requested. And
* if it is requested multiple times, we want ot be able to show it to family or friends. We
* don't want to have to fetch it every time.
* There's no way to avoid loading the image once. But when it's being accessed for the
* second time, we would like to avoid going over the network again & instead return the
* result that was cached in memory.
* */

data class CatImage(val thumbnailUrl: String, val url: String) {
    val image: ByteArray by lazy { // delegator function
        // Read image as bytes
        URL(url).readBytes()
    }
}
