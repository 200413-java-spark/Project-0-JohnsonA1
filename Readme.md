# Blogpost
- A basic journal entry application

### Build
- mvn clean compile

### Usage
- mvn exec:java -Dexec.args-"[operators]"

Usage
To run program use ./run.sh

mvn exec:java The program will display a menu that will take input from the user and take action depending the input.
Design

### Architecture

The Blog is a command line application
The posting package defines the element of operations package and classes and that will perform different task.
The io package is in charge of reading and parsing the contents, of a file inputted by the user in the menu, and stores it in a list of components for later use
The io.SQLDataSource creates Connection objects for the BlogOpsRepo class
BlogOpsRepo inserts and selects data from a sql database


### Main Algorithm

The main class will display a menu and ask the user to type a string from the selections
That input will be store and passed into the main loop
"'add' : Add a new blog entry by following the prompts."
"'show all items' : Print all items currently saved in blog post"
"read from file"
"write to file"
"read from database"
"write to database"
 "'exit' : Quit and exit program."
