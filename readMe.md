# Blogpost
- A basic journal entry application

### Build
- mvn clean compile

### Usage
- mvn exec:java -Dexec.args-"[operands]"

Usage
To run program use ./run.sh

mvn exec:java The program will display a menu that will take input from the user and take action depending the input.
Design

### Architecture

The Blog is a command line application
The posting package defines the element of operations which implements interface and classes and that will different entries.
The io package is in charge of reading and parsing the contents, of a file inputted by the user in the menu, and stores it in a list of components for later use
The io.SQLDataSource creates Connection objects for the SQLOpsRepo class
SQLOpsRepo inserts and selects data from a sql database
Main Algorithm

The main class will display a menu and ask the user to type a number from 1 to 3 from the selections
That input will be store and passed into the main loop
while the user input is not equal to 0
If user input is equal to 1
User is allowed to fill out the blog entry

Else if user input is equal to 2
File menu is displayed and user has to type name of file
It opens the typed string as a file
FileParser loads the file into a List of Blog Posts

Else if user input is equal to 3
The List is passed to a SQLOpsRepo to insert all Operations to a sql database
SQLOpsRepo queries the database for all Components on the list
The returned List of Components is printed to the console/ terminal
Else if user input is equal to 4
A connection to a https server is open
The list of blog entries will be displayed on the browser when typing http://localhost:8080
Else a usage guide is printed to the console
The main menu is displayed again so the user can type another selection
If user types 0 the application will exit