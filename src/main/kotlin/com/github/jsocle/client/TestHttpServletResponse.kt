package com.github.jsocle.client

import java.io.ByteArrayOutputStream
import java.io.PrintWriter
import java.util.*
import javax.servlet.ServletOutputStream
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import kotlin.collections.arrayListOf
import kotlin.collections.contains
import kotlin.collections.hashMapOf
import kotlin.collections.set

public class TestHttpServletResponse : HttpServletResponse {
    private val headers = hashMapOf<String, MutableList<String>>()

    private val _outputStream = ByteArrayOutputStream()

    private val _printWriter = PrintWriter(_outputStream)

    val cookies: ArrayList<Cookie> = arrayListOf()

    private var _status: Int = 0

    override fun setContentLengthLong(len: Long) {
        throw UnsupportedOperationException()
    }

    override fun getLocale(): Locale? {
        throw UnsupportedOperationException()
    }

    override fun reset() {
        throw UnsupportedOperationException()
    }

    override fun resetBuffer() {
        throw UnsupportedOperationException()
    }

    override fun flushBuffer() {
        throw UnsupportedOperationException()
    }

    override fun setContentType(type: String?) {
        throw UnsupportedOperationException()
    }

    override fun getWriter(): PrintWriter? {
        return _printWriter
    }

    override fun getOutputStream(): ServletOutputStream? {
        throw UnsupportedOperationException()
    }

    override fun isCommitted(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getBufferSize(): Int {
        throw UnsupportedOperationException()
    }

    override fun setLocale(loc: Locale?) {
        throw UnsupportedOperationException()
    }

    override fun getCharacterEncoding(): String? {
        throw UnsupportedOperationException()
    }

    override fun getContentType(): String? {
        throw UnsupportedOperationException()
    }

    override fun setBufferSize(size: Int) {
        throw UnsupportedOperationException()
    }

    override fun setContentLength(len: Int) {
        throw UnsupportedOperationException()
    }

    override fun setCharacterEncoding(charset: String?) {
        throw UnsupportedOperationException()
    }

    override fun setIntHeader(name: String?, value: Int) {
        throw UnsupportedOperationException()
    }

    override fun setDateHeader(name: String?, date: Long) {
        throw UnsupportedOperationException()
    }

    override fun getHeaders(name: String?): MutableCollection<String>? {
        throw UnsupportedOperationException()
    }

    override fun getStatus(): Int = _status

    override fun getHeader(name: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun containsHeader(name: String?): Boolean {
        throw UnsupportedOperationException()
    }

    override fun setStatus(sc: Int) {
        _status = sc
    }

    override fun setStatus(sc: Int, sm: String?) {
        throw UnsupportedOperationException()
    }

    override fun addDateHeader(name: String?, date: Long) {
        throw UnsupportedOperationException()
    }

    override fun sendError(sc: Int, msg: String?) {
        throw UnsupportedOperationException()
    }

    override fun sendError(sc: Int) {
        throw UnsupportedOperationException()
    }

    override fun encodeUrl(url: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun addHeader(name: String?, value: String?) {
        if (name == null || value == null) {
            throw UnsupportedOperationException()
        }
        if (name !in headers) {
            arrayListOf<String>().apply {
                headers[name] = this
            }
        } else {
            headers[name]!!
        }.add(value)
    }

    override fun getHeaderNames(): MutableCollection<String>? {
        throw UnsupportedOperationException()
    }

    override fun addCookie(cookie: Cookie?) {
        if (cookie != null) {
            cookies.add(cookie)
        }
    }

    override fun addIntHeader(name: String?, value: Int) {
        throw UnsupportedOperationException()
    }

    override fun encodeURL(url: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun encodeRedirectUrl(url: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun encodeRedirectURL(url: String?): String? {
        throw UnsupportedOperationException()
    }

    override fun setHeader(name: String?, value: String?) {
        throw UnsupportedOperationException()
    }

    override fun sendRedirect(location: String?) {
        throw UnsupportedOperationException()
    }

    internal fun buildResponse(url: String): ClientResponse {
        return ClientResponse(_outputStream.toString("UTF-8"), headers, url, _status)
    }
}