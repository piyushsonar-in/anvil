@echo off
rem
rem Copyright (c) 2026 Piyush Sonar
rem SPDX-License-Identifier: LicenseRef-Anvil-Community-1.0
rem
rem This file is part of Anvil and is licensed under the Anvil Community
rem Source License 1.0. See LICENSE in the project root.
rem

rem   Compatibility launcher: forwards all arguments to anvil.bat

>&2 echo jmeter.bat is deprecated, use anvil.bat instead.
call "%~dp0anvil.bat" %*
exit /b %ERRORLEVEL%
