/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("build-logic.jvm-published-library")
}

val lastEditYear: String by rootProject.extra
val anvilVersion: String by rootProject.extra
val jmeterBaseVersion: String by rootProject.extra

tasks.withType<ProcessResources>().configureEach {
    val version = rootProject.version.toString()
    inputs.property("@VERSION@", version)
    inputs.property("@ANVIL_VERSION@", anvilVersion)
    inputs.property("@JMETER_BASE_VERSION@", jmeterBaseVersion)
    inputs.property("@YEAR@", lastEditYear)
    filter { x: String ->
        x.replace("@VERSION@", version)
            .replace("@ANVIL_VERSION@", anvilVersion)
            .replace("@JMETER_BASE_VERSION@", jmeterBaseVersion)
            .replace("@YEAR@", lastEditYear)
    }
}

tasks.named<Jar>(JavaPlugin.JAR_TASK_NAME) {
    manifest {
        attributes["Main-Class"] = "org.apache.jmeter.NewDriver"
    }
}
