/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.navigation.safe.args.generator.kotlin

import androidx.navigation.safe.args.generator.NavWriter
import androidx.navigation.safe.args.generator.models.Destination
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec

class KotlinNavWriter(private val useAndroidX: Boolean = false) : NavWriter<KotlinCodeFile> {

    override fun generateDirectionsCodeFile(
        destination: Destination,
        parentDirectionsFileList: List<KotlinCodeFile>
    ): KotlinCodeFile {
        val destName = destination.name
            ?: throw IllegalStateException("Destination with actions must have name")
        val className = ClassName(destName.packageName(), "${destName.simpleName()}Directions")

        return FileSpec.builder(className.packageName, className.simpleName)
            .build()
            .toCodeFile()
    }

    override fun generateArgsCodeFile(destination: Destination): KotlinCodeFile {
        val destName = destination.name
            ?: throw IllegalStateException("Destination with actions must have name")
        val className = ClassName(destName.packageName(), "${destName.simpleName()}Args")

        return FileSpec.builder(className.packageName, className.simpleName)
            .build()
            .toCodeFile()
    }
}