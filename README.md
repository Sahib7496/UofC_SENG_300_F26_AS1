# GoCycle System (SENG 300 Assignment 1)
Authors:
Jonathan Krisnawan - 30334242
Sahib Sahota - 30241787
Archit Sharma - 30248701

Course: SENG 300
Date: 2026-10-19

System Overview:
A proposed Java implementation of the GoCycle System designed using a Singleton, Abstract Factory approach.

Build Instructions:
1. API setup
Requirements:
- SQL Database
-    Url link
-    User login text string
- Mail Transfer API (ex: SMTP)
-   Domain Name/IP Address text string (Host)
-   Port Number integer
-   Admin Email text string
View #4 below for the SQL implementation

2. Clone repository
In a terminal, run the following command:
```bash
git clone https://github.com
cd UofC_SENG_300_F26_AS1
```
If done correctly, a local repository will be created containing the Java files from UofC_SENG_300_F26_AS1

3. Initialize Mail Transfer API
In the 'sendReceipt' method under interface 'ReceiptPort', implement the Host string, Port number, and Admin email string as seperate variables, and implement the Email client commands corresponding to the chosen Mail Transfer API

4. Implement SQLDatabase
At the start of a program's runtime, call
```bash
 SQLDatabaseSingleton.init(String url, String user)
```
and pass the SQL url link and login text string as arguments to initialize the SQL database.

5. Compile package
In a terminal, run the command associated with your Java build type:
Maven:
```bash
mvn clean package
```
Gradle:
```bash
./gradlew clean build
```
If done correctly, all Java source code will be compiled as a .jar file

Run Instructions:
In a terminal, run the command:
```bash
java -jar target/gocycle-api-1.0.0.jar
```
, replacing 'gocycle' with the project name to start the program

