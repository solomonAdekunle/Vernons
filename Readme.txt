This Framework is Data Driven FrameWork using Maven Repository
All Codes are inside the src/test/java

BaseTest Class is where all Properties Initialisation are and this can be located in a Package Folder called com.suite.

Config Package contains two Files which are
Config.properties files and OR.properties file
Config.properties file is where all browser setting, Url and Default Username and Password are kept
OR.properties file .
Pages Package is a Package where all Page classes are kept
Util Package and inside it there are a classes called Constant,customListener, ErrorUtil, ExtentManager, TestDataProvider, TestListenerAdapter TestUtil and Xls-Reader
Constant Class is a class where some part of identifier are kept.
There Packages called Vernons_Core_Suite, Suite2, Suite3a ndCashier , here are where all the Features Classes are kept.

There is another source folder called  src/test resources
 Inside this src/main/resource there are Cashier.xml, Suite2.xml, Suite3.xnl, Vernons_Core-SUITE.xml, testng.xml files, 
 
lib folder is a folder that has all the chrome.exe,geckco.exe and IESever.exe drivers for windows OS
 while chrome and geckco drivers are for linux OS.

BingoData Folder : thsis where all the data are kept in spreadsheets.
reports Folder: is the folder where all reports generated throug the excution can be found. 
Screenshot Folder: this is where all screenshot taken during the Execution are kept.
 
 pom.xml file is where all maven dependencies are kept and also the execution is called when running through command line
 
 This Framework can be run in 2 ways 
 i) Testng.xml
 ii) Through Command line by Navigating to the project on the Command Prompt typing: mvn test
 
 