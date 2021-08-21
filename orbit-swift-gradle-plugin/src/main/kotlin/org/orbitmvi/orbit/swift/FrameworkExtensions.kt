/*
 * Copyright 2021 Mikołaj Leszczyński & Appmattus Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.orbitmvi.orbit.swift

import java.util.Locale
import java.util.regex.Matcher
import java.util.regex.Pattern
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework

val Framework.architectureName: String
    get() {
        val m: Matcher = Pattern.compile("_([a-z])").matcher(linkTask.target)
        val architectureNameStringBuilder = StringBuilder()
        while (m.find()) {
            m.appendReplacement(architectureNameStringBuilder, m.group(1).toUpperCase(Locale.ROOT))
        }
        m.appendTail(architectureNameStringBuilder)
        return architectureNameStringBuilder.toString()
    }
