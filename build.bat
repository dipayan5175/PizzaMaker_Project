
@echo off
cls

set DRIVE_LETTER=%1:
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\apache-ant-1.10.5\bin;c:\Windows

::ant run-command-line -Ddrive-letter=%DRIVE_LETTER%
::ant test -Ddrive-letter=%DRIVE_LETTER%
ant run-gui -Ddrive-letter=%DRIVE_LETTER%