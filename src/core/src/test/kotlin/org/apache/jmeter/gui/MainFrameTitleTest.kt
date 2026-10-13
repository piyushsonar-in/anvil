/*
 * Copyright (c) 2026 Piyush Sonar
 * SPDX-License-Identifier: LicenseRef-Anvil-Community-1.0
 *
 * This file is part of Anvil and is licensed under the Anvil Community
 * Source License 1.0. See LICENSE in the project root.
 */

package org.apache.jmeter.gui

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MainFrameTitleTest {
    @ParameterizedTest
    @CsvSource(
        nullValues = ["null"],
        value = [
            "null, Anvil",
            "'', Anvil",
            "plan.jmx, Anvil · plan.jmx",
            "/home/user/tests/plan.jmx, Anvil · plan.jmx",
            "C:\\tests\\plan.jmx, Anvil · plan.jmx",
        ]
    )
    fun frameTitle(fileName: String?, expected: String) {
        assertEquals(expected, MainFrame.frameTitle(fileName))
    }
}
