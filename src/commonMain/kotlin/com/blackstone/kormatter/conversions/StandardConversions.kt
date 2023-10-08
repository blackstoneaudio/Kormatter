/*
 * Copyright © 2018 mrAppleXZ
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.blackstone.kormatter.conversions

import com.blackstone.kormatter.utils.ArgumentTaker
import com.blackstone.kormatter.utils.FormatString
import com.blackstone.kormatter.utils.PartAction


/*
 * Created by mrAppleXZ on 12.08.18.
 */
internal class ConversionConstant(
    private val replacement: String,
    override val widthAction: PartAction,
    override val precisionAction: PartAction
) : ConversionChecking
{
    override val canTakeArguments: Boolean
        get() = false

    override fun formatTo(to: Appendable, str: FormatString, taker: ArgumentTaker)
    {
        to.append(replacement)
    }
}

@PublishedApi
internal abstract class ConversionExecuting(
    private val supportedFlags: CharArray,
    override val widthAction: PartAction,
    override val precisionAction: PartAction
) : ConversionChecking
{
    override val canTakeArguments: Boolean
        get() = true

    override fun checkFlag(str: FormatString, flag: Char): Boolean = flag in supportedFlags
}

@PublishedApi
internal abstract class ConversionExecutingNotNull(
    private val supportedFlags: CharArray,
    override val widthAction: PartAction,
    override val precisionAction: PartAction
) : ConversionChecking
{
    override val canTakeArguments: Boolean
        get() = true

    override fun checkFlag(str: FormatString, flag: Char): Boolean = flag in supportedFlags

    override fun formatTo(to: Appendable, str: FormatString, taker: ArgumentTaker)
    {
        val arg = taker.take()
        if(arg == null)
            to.append("null")
        else
            formatTo(to, str, arg)
    }

    abstract fun formatTo(to: Appendable, str: FormatString, arg: Any)
}