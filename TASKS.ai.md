# Anvil M0: Foundation

Branch `feat/m0-foundation` from `origin/master` (`762310f401`). Plan: `anvil-plans/01-plan-anvil-roadmap.html`.

## 1. Move the baseline to Java 21

- [x] `targetJavaVersion` 17 → 21 in `build-logic/build-parameters/build.gradle.kts`
- [x] Fix Java 21 deprecation warnings in `src/core` main code
- [x] Fix Java 21 deprecation warnings in other modules and tests (URL constructors and `Subject.doAs` suppressed, not migrated)
- [x] CI matrix covers JDK 21 and 25, drops 17 (`.github/workflows/matrix.mjs`)
- [x] `bin/jmeter` and `bin/jmeter.bat` print "Anvil needs Java 21 or newer, found 17" and a download link
- [ ] `gradlew.bat build` green with `--release 21`

## 2. Anvil branding

- [x] `anvil.version=0.1.0` in `gradle.properties`
- [x] Window title "Anvil · plan.jmx" (`MainFrame`)
- [x] About shows "Anvil 0.1.0, based on Apache JMeter 6.0.0" (`AboutCommand`)
- [x] Splash screen, new icon and splash images (no ASF feather)
- [x] `bin/anvil`, `bin/anvil.bat` launchers; `jmeter`, `jmeter.bat` print a one-line notice and delegate
- [x] Distribution archive `anvil-0.1.0.zip` (`src/dist/build.gradle.kts`)
- [x] No UI string uses "Apache JMeter" as the product name (About, title, splash, help, CLI banner, dashboard title; plain "JMeter" still appears in many messages)
- [x] New settings use `anvil.*`; `jmeter.*` keys still work (M0 adds no new settings; `runGui` passes `-Danvil.*`)
- [x] NOTICE keeps ASF attribution and states no affiliation; README "Relationship to Apache JMeter"

## 3. CI and weekly upstream sync

- [x] `.github/workflows/main.yml` adjusted for Java 21
- [x] `.github/workflows/upstream-sync.yml`: Monday PR "Sync upstream/master", conflicts listed, never pushes to master
- [ ] CI job `launcher-old-java` checks the Java 17 message (added; same check passes locally, runs after push)
- [ ] Green CI on `piyushsonar-in/anvil` (needs push)

## 4. Clean-room rules

- [x] CONTRIBUTING.md clean-room section
- [x] `.github/PULL_REQUEST_TEMPLATE.md` checkbox "No code copied from breaktest"
- [x] TASKS.ai.md mirrors the plan

## 5. License (added during M0)

- [x] Anvil Community Source License 1.0 in `LICENSE`; Apache text in `LICENSE-APACHE-2.0`
- [x] CLA, CONTRIBUTING section, PR checkbox
- [x] Autostyle enforces Anvil header for `config/anvil-licensed-files.txt`, ASF header elsewhere; RAT skips Anvil files
- [x] Jars and dist zips ship both licenses
- [ ] Legal review of LICENSE and CLA

## Verify

- [ ] `gradlew.bat build` green
- [x] `bin/anvil.bat` opens a window titled Anvil (`Anvil · CSVSample.jmx`)
- [x] `classes testClasses style` green; `:src:core:test` 385 and `:src:protocol:http:test` 853 passed
- [ ] Unexplained `Changing LAF requires a restart` dialog seen once on GUI launch
- [ ] Weekly upstream-sync PR merges cleanly (needs push)
