@echo off
IF EXIST .\bin (
cd bin
jar cvfe ../fhlib.jar at/hagenberg/jg16/se/fhlib/tests/MainTest .
cd ..
echo "Created jar!"
pause >nul
pause
) ELSE (
echo "Make sure you execute the 'ant' command first"
pause
)
