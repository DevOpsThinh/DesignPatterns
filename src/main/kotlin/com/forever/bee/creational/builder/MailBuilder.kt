/**
 * Lets u construct complex objects step by step & allows u to produce different types &
 * representations of an object using the same construction code.
 * @author Nguyen Truong Thinh
 *  ->  Contact me: nguyentruongthinhvn2020@gmail.com || +84393280504
 * */
package com.forever.bee.creational.builder
/**
 * imagine we need to design a system that send emails.
 * An email may have: An address, CC (opt), Title (opt), Body (opt), Important flag (opt).
 *  /**
 *  Will wrap our Mail class
 *  */
  */
class MailBuilder {
    private var recipients: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String = ""
    private var message: String = ""
    private var importantFlag: Boolean = false

    class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val importantFlag: Boolean
    )

    /**
     *  To finalize the creation of our class
     * */
    fun build(): Mail {
        if (recipients.isEmpty()) {
            throw RuntimeException("To property is empty")
        }
        return Mail(recipients, cc, title, message, importantFlag)
    }
    // Setters
    fun setRecepients(_recepients: List<String>): MailBuilder {
        recipients = _recepients
        return this
    }

    fun setMessage(_message: String): MailBuilder {
        message = _message
        return  this
    }
}