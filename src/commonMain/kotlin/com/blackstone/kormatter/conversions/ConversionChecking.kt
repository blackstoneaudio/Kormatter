/*
 * Copyright © 2018 mrAppleXZ
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.blackstone.kormatter.conversions

import com.blackstone.kormatter.FLAG_LEFT_JUSTIFIED
import com.blackstone.kormatter.FLAG_REUSE_ARGUMENT
import com.blackstone.kormatter.FlagMismatchException
import com.blackstone.kormatter.PrecisionMismatchException
import com.blackstone.kormatter.WidthMismatchException
import com.blackstone.kormatter.utils.FormatString
import com.blackstone.kormatter.utils.PartAction


/*
 * Created by mrAppleXZ on 12.08.18.
 */
interface ConversionChecking : Conversion
{
    override fun check(str: FormatString)
    {
        if(widthAction == PartAction.FORBIDDEN && str.width != null)
            throw WidthMismatchException(str)
        if(precisionAction == PartAction.FORBIDDEN && str.precision != null)
            throw PrecisionMismatchException(str)
        for (flag in str.flags)
        {
            if (flag == FLAG_LEFT_JUSTIFIED && widthAction != PartAction.FORBIDDEN)
                continue
            if (flag == FLAG_REUSE_ARGUMENT && canTakeArguments)
                continue
            if(checkFlag(str, flag))
                continue
            throw FlagMismatchException(str, flag)
        }
    }

    fun checkFlag(str: FormatString, flag: Char): Boolean = false
}