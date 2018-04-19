/*
 * Copyright 2018 The Android Open Source Project
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

package androidx.navigation

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class ViewTest {

    @Test fun navController() {
        val view = View(InstrumentationRegistry.getTargetContext())
        val navController = NavController(InstrumentationRegistry.getTargetContext())
        view.navController = navController
        assertTrue("View should have NavController set",
                view.navController == navController)
    }

    @Test fun navControllerNull() {
        val view = View(InstrumentationRegistry.getTargetContext())
        try {
            view.navController
            fail("navController should throw IllegalStateException if a NavController was not set")
        } catch (e: IllegalStateException) {
            // Expected
        }
    }

    @Test fun findNavController() {
        val view = View(InstrumentationRegistry.getTargetContext())
        val navController = NavController(InstrumentationRegistry.getTargetContext())
        view.navController = navController

        val foundNavController = view.findNavController()
        assertNotNull("findNavController should return non-null if a NavController was set",
                foundNavController)
        assertTrue("View should have NavController set",
                foundNavController == navController)
    }

    @Test fun findNavControllerNull() {
        val view = View(InstrumentationRegistry.getTargetContext())
        assertNull("findNavController should return null if a NavController was never set",
                view.findNavController())
    }
}
