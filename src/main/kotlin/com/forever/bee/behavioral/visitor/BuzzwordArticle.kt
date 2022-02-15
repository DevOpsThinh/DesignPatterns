/**
 * Visitor is a behavioral DP that let u separate algorithms from the objects on which
 * they operate.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.behavioral.visitor

sealed class HtmlElement

class Page(val elements: MutableList<HtmlElement> = mutableListOf()) {
    constructor(vararg elements: HtmlElement) : this(mutableListOf()) {
        for (e in elements) {
            this.elements.add(e)
        }
    }
}

class Container(val elements: MutableList<HtmlElement> = mutableListOf()) : HtmlElement() {
    constructor(vararg units: HtmlElement) : this(mutableListOf()) {
        for (i in units) {
            this.elements.add(i)
        }
    }
}

class LinksCrawler {
    private var _links = mutableListOf<String>()

    val links
        get() = _links.toList()

    fun visit(page: Page) {
        visit(page.elements)
    }

    fun visit(container: Container) = visit(container.elements)

    private fun visit(elements: List<HtmlElement>) {
        for (e in elements) {
            when (e) {
                is Container -> e.accept(this)
                is Link -> _links.add(e.href)
                is Image -> _links.add(e.src)
                else -> {}
            }
        }
    }
}

object Image : HtmlElement() {
    val src: String
        get() = "https://images.free.vn"
}

object Link : HtmlElement() {
    val href: String
        get() = "https://short.links.vn"
}

object Table : HtmlElement()

// Package level functions

/**
 *  Will receive the root of our object tree
 *  @param page Page container
 *  @return a list of all the available links
 * */
fun collectLinks(page: Page): List<String> {
    // No need for intermediate variable there.
    return LinksCrawler().run {
        page.accept(this)
        this.links
    }
}

//                                                      Extension functions

private fun Container.accept(feature: LinksCrawler) {
    feature.visit(this)
}

private fun Page.accept(feature: LinksCrawler) {
    feature.visit(this)
}
