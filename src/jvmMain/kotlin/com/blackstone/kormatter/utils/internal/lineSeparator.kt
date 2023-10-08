package com.blackstone.kormatter.utils.internal

/*
 * Copyright © 2018 mrAppleXZ
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/.
 */


/*
 * Created by mrAppleXZ on 07.08.18.
 */
internal actual val lineSeparator: String
    get() = System.lineSeparator()

internal actual fun CharSequence.lengthSequence(length: Int): CharSequence
{
    if(this is StringBuilder)
    {
        setLength(length)
        return this
    }
    return subSequence(0, length)
}