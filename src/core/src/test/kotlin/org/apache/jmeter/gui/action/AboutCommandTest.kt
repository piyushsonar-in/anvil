/*
 * Copyright (c) 2026 Piyush Sonar
 * SPDX-License-Identifier: LicenseRef-Anvil-Community-1.0
 *
 * This file is part of Anvil and is licensed under the Anvil Community
 * Source License 1.0. See LICENSE in the project root.
 */

package org.apache.jmeter.gui.action

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AboutCommandTest {
    @Test
    fun versionLine() {
        val line = AboutCommand.versionLine()
        assertTrue(
            Regex("""Anvil \d+\.\d+\.\d+\S*, based on Apache JMeter \d+\.\d+\.\d+""").matches(line),
            "About version line: $line"
        )
    }
}
