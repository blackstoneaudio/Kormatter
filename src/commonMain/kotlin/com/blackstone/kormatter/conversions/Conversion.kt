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
 * Created by mrAppleXZ on 04.08.18.
 */
interface Conversion
{
    val widthAction: PartAction

    val precisionAction: PartAction

    val canTakeArguments: Boolean

    fun formatTo(to: Appendable, str: FormatString, taker: ArgumentTaker)

    fun check(str: FormatString)
}