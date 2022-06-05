set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%lib\AllureReport\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%lib\testng-6.14.3.jar;%ProjectPath%lib\selenium-server-standalone-3.141.59.jar;%ProjectPath%lib\AllureReport\*;%ProjectPath%lib\ExtentReport\V2\*;%ProjectPath%lib\Log4J\*;%ProjectPath%lib\ExtentReport\V3\*;%ProjectPath%lib\ExtentReport\V4\*;%ProjectPath%lib\ExtentReport\V5\*;%ProjectPath%lib\ReportNG\*;%ProjectPath%lib\WebDriverManager\*" org.testng.TestNG "%ProjectPath%bin\RunFacebook.xml"
pause