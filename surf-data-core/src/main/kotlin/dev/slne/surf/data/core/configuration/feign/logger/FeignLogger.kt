package dev.slne.surf.data.core.configuration.feign.logger

import feign.Logger
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.logger.slf4j.ComponentLogger
import org.slf4j.Marker

class FeignLogger(
    private val delegate: ComponentLogger
) : Logger(), ComponentLogger {

    override fun trace(msg: Component) {
        delegate.trace(msg)
    }

    override fun trace(format: Component, arg: Any?) {
        delegate.trace(format, arg)
    }

    override fun trace(format: Component, arg1: Any?, arg2: Any?) {
        delegate.trace(format, arg1, arg2)
    }

    override fun trace(format: Component, vararg arguments: Any?) {
        delegate.trace(format, *arguments)
    }

    override fun trace(msg: Component, t: Throwable?) {
        delegate.trace(msg, t)
    }

    override fun trace(marker: Marker, msg: Component) {
        delegate.trace(marker, msg)
    }

    override fun trace(marker: Marker, format: Component, arg: Any?) {
        delegate.trace(marker, format, arg)
    }

    override fun trace(
        marker: Marker, format: Component, arg1: Any?,
        arg2: Any?
    ) {
        delegate.trace(marker, format, arg1, arg2)
    }

    override fun trace(
        marker: Marker,
        format: Component,
        vararg argArray: Any?
    ) {
        delegate.trace(marker, format, *argArray)
    }

    override fun trace(marker: Marker, msg: Component, t: Throwable?) {
        delegate.trace(marker, msg, t)
    }

    override fun debug(msg: Component) {
        delegate.debug(msg)
    }

    override fun debug(format: Component, arg: Any?) {
        delegate.debug(format, arg)
    }

    override fun debug(format: Component, arg1: Any?, arg2: Any?) {
        delegate.debug(format, arg1, arg2)
    }

    override fun debug(format: Component, vararg arguments: Any?) {
        delegate.debug(format, *arguments)
    }

    override fun debug(msg: Component, t: Throwable?) {
        delegate.debug(msg, t)
    }

    override fun debug(marker: Marker, msg: Component) {
        delegate.debug(marker, msg)
    }

    override fun debug(marker: Marker, format: Component, arg: Any?) {
        delegate.debug(marker, format, arg)
    }

    override fun debug(
        marker: Marker, format: Component, arg1: Any?,
        arg2: Any?
    ) {
        delegate.debug(marker, format, arg1, arg2)
    }

    override fun debug(
        marker: Marker,
        format: Component,
        vararg arguments: Any?
    ) {
        delegate.debug(marker, format, *arguments)
    }

    override fun debug(marker: Marker, msg: Component, t: Throwable?) {
        delegate.debug(marker, msg, t)
    }

    override fun info(msg: Component) {
        delegate.info(msg)
    }

    override fun info(format: Component, arg: Any?) {
        delegate.info(format, arg)
    }

    override fun info(format: Component, arg1: Any?, arg2: Any?) {
        delegate.info(format, arg1, arg2)
    }

    override fun info(format: Component, vararg arguments: Any?) {
        delegate.info(format, *arguments)
    }

    override fun info(msg: Component, t: Throwable?) {
        delegate.info(msg, t)
    }

    override fun info(marker: Marker, msg: Component) {
        delegate.info(marker, msg)
    }

    override fun info(marker: Marker, format: Component, arg: Any?) {
        delegate.info(marker, format, arg)
    }

    override fun info(
        marker: Marker, format: Component, arg1: Any?,
        arg2: Any?
    ) {
        delegate.info(marker, format, arg1, arg2)
    }

    override fun info(
        marker: Marker,
        format: Component,
        vararg arguments: Any?
    ) {
        delegate.info(marker, format, *arguments)
    }

    override fun info(marker: Marker, msg: Component, t: Throwable) {
        delegate.info(marker, msg, t)
    }

    override fun warn(msg: Component) {
        delegate.warn(msg)
    }

    override fun warn(format: Component, arg: Any?) {
        delegate.warn(format, arg)
    }

    override fun warn(format: Component, vararg arguments: Any?) {
        delegate.warn(format, *arguments)
    }

    override fun warn(format: Component, arg1: Any?, arg2: Any?) {
        delegate.warn(format, arg1, arg2)
    }

    override fun warn(msg: Component, t: Throwable) {
        delegate.warn(msg, t)
    }

    override fun warn(marker: Marker, msg: Component) {
        delegate.warn(marker, msg)
    }

    override fun warn(marker: Marker, format: Component, arg: Any?) {
        delegate.warn(marker, format, arg)
    }

    override fun warn(
        marker: Marker, format: Component, arg1: Any?,
        arg2: Any?
    ) {
        delegate.warn(marker, format, arg1, arg2)
    }

    override fun warn(
        marker: Marker,
        format: Component,
        vararg arguments: Any?
    ) {
        delegate.warn(marker, format, *arguments)
    }

    override fun warn(marker: Marker, msg: Component, t: Throwable) {
        delegate.warn(marker, msg, t)
    }

    override fun error(msg: Component) {
        delegate.error(msg)
    }

    override fun error(format: Component, arg: Any?) {
        delegate.error(format, arg)
    }

    override fun error(format: Component, arg1: Any?, arg2: Any?) {
        delegate.error(format, arg1, arg2)
    }

    override fun error(format: Component, vararg arguments: Any?) {
        delegate.error(format, *arguments)
    }

    override fun error(msg: Component, t: Throwable) {
        delegate.error(msg, t)
    }

    override fun error(marker: Marker, msg: Component) {
        delegate.error(marker, msg)
    }

    override fun error(marker: Marker, format: Component, arg: Any?) {
        delegate.error(marker, format, arg)
    }

    override fun error(
        marker: Marker, format: Component, arg1: Any?,
        arg2: Any?
    ) {
        delegate.error(marker, format, arg1, arg2)
    }

    override fun error(
        marker: Marker,
        format: Component,
        vararg arguments: Any?
    ) {
        delegate.error(marker, format, *arguments)
    }

    override fun error(marker: Marker, msg: Component, t: Throwable) {
        delegate.error(marker, msg, t)
    }

    override fun getName(): String? {
        return delegate.name
    }

    override fun isTraceEnabled(): Boolean {
        return delegate.isTraceEnabled
    }

    override fun trace(msg: String?) {
        delegate.trace(msg)
    }

    override fun trace(format: String?, arg: Any?) {
        delegate.trace(format, arg)
    }

    override fun trace(format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(format, arg1, arg2)
    }

    override fun trace(format: String?, vararg arguments: Any?) {
        delegate.trace(format, *arguments)
    }

    override fun trace(msg: String?, t: Throwable?) {
        delegate.trace(msg, t)
    }

    override fun isTraceEnabled(marker: Marker?): Boolean {
        return delegate.isTraceEnabled(marker)
    }

    override fun trace(marker: Marker?, msg: String?) {
        delegate.trace(marker, msg)
    }

    override fun trace(marker: Marker?, format: String?, arg: Any?) {
        delegate.trace(marker, format, arg)
    }

    override fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(marker, format, arg1, arg2)
    }

    override fun trace(marker: Marker?, format: String?, vararg argArray: Any?) {
        delegate.trace(marker, format, *argArray)
    }

    override fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.trace(marker, msg, t)
    }

    override fun isDebugEnabled(): Boolean {
        return delegate.isDebugEnabled
    }

    override fun debug(msg: String?) {
        delegate.debug(msg)
    }

    override fun debug(format: String?, arg: Any?) {
        delegate.debug(format, arg)
    }

    override fun debug(format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(format, arg1, arg2)
    }

    override fun debug(format: String?, vararg arguments: Any?) {
        delegate.debug(format, *arguments)
    }

    override fun debug(msg: String?, t: Throwable?) {
        delegate.debug(msg, t)
    }

    override fun isDebugEnabled(marker: Marker?): Boolean {
        return delegate.isDebugEnabled(marker)
    }

    override fun debug(marker: Marker?, msg: String?) {
        delegate.debug(marker, msg)
    }

    override fun debug(marker: Marker?, format: String?, arg: Any?) {
        delegate.debug(marker, format, arg)
    }

    override fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(marker, format, arg1, arg2)
    }

    override fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.debug(marker, format, *arguments)
    }

    override fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.debug(marker, msg, t)
    }

    override fun isInfoEnabled(): Boolean {
        return delegate.isInfoEnabled
    }

    override fun info(msg: String?) {
        delegate.info(msg)
    }

    override fun info(format: String?, arg: Any?) {
        delegate.info(format, arg)
    }

    override fun info(format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(format, arg1, arg2)
    }

    override fun info(format: String?, vararg arguments: Any?) {
        delegate.info(format, *arguments)
    }

    override fun info(msg: String?, t: Throwable?) {
        delegate.info(msg, t)
    }

    override fun isInfoEnabled(marker: Marker?): Boolean {
        return delegate.isInfoEnabled(marker)
    }

    override fun info(marker: Marker?, msg: String?) {
        delegate.info(marker, msg)
    }

    override fun info(marker: Marker?, format: String?, arg: Any?) {
        delegate.info(marker, format, arg)
    }

    override fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(marker, format, arg1, arg2)
    }

    override fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.info(marker, format, *arguments)
    }

    override fun info(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.info(marker, msg, t)
    }

    override fun isWarnEnabled(): Boolean {
        return delegate.isWarnEnabled
    }

    override fun warn(msg: String?) {
        delegate.warn(msg)
    }

    override fun warn(format: String?, arg: Any?) {
        delegate.warn(format, arg)
    }

    override fun warn(format: String?, vararg arguments: Any?) {
        delegate.warn(format, *arguments)
    }

    override fun warn(format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(format, arg1, arg2)
    }

    override fun warn(msg: String?, t: Throwable?) {
        delegate.warn(msg, t)
    }

    override fun isWarnEnabled(marker: Marker?): Boolean {
        return delegate.isWarnEnabled(marker)
    }

    override fun warn(marker: Marker?, msg: String?) {
        delegate.warn(marker, msg)
    }

    override fun warn(marker: Marker?, format: String?, arg: Any?) {
        delegate.warn(marker, format, arg)
    }

    override fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(marker, format, arg1, arg2)
    }

    override fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.warn(marker, format, *arguments)
    }

    override fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.warn(marker, msg, t)
    }

    override fun isErrorEnabled(): Boolean {
        return delegate.isErrorEnabled
    }

    override fun error(msg: String?) {
        delegate.error(msg)
    }

    override fun error(format: String?, arg: Any?) {
        delegate.error(format, arg)
    }

    override fun error(format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(format, arg1, arg2)
    }

    override fun error(format: String?, vararg arguments: Any?) {
        delegate.error(format, *arguments)
    }

    override fun error(msg: String?, t: Throwable?) {
        delegate.error(msg, t)
    }

    override fun isErrorEnabled(marker: Marker?): Boolean {
        return delegate.isErrorEnabled(marker)
    }

    override fun error(marker: Marker?, msg: String?) {
        delegate.error(marker, msg)
    }

    override fun error(marker: Marker?, format: String?, arg: Any?) {
        delegate.error(marker, format, arg)
    }

    override fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(marker, format, arg1, arg2)
    }

    override fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.error(marker, format, *arguments)
    }

    override fun error(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.error(marker, msg, t)
    }

    override fun log(configKey: String?, format: String?, vararg args: Any?) {
        delegate.debug(Component.text(String.format(methodTag(configKey) + format, args)))
    }
}