package com.blackstone.kormatter.utils.internal

import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
internal actual val lineSeparator: String
    get() = when (Platform.osFamily) {
        OsFamily.WINDOWS -> "\r\n"
        else -> "\n"
    }

internal actual fun CharSequence.lengthSequence(length: Int): CharSequence {
    if (this is StringBuilder) {
        // For the Kotlin/Native StringBuilder, you can clear and append spaces to set the desired length
        this.clear()
        repeat(length) { this.append(' ') }
        return this
    }
    return subSequence(0, length)
}