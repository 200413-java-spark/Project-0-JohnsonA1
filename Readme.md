# PC Budget Application

## Example
The purpose of this application is to help pc builders to know
the full price of pc parts and the full price of their PC build.
- cpu
- moth
- gpu
- ssd
Each part will have its specific details and price, and at the end of the program the user will
be able to see the tax and total amount for the PC build.

## Build
- ./build.sh
>mvn clean compile

## Postgres
```bash
docker build -t pclist .
docker run --name pclist -d --rm -p 5432:5432 pclist
```
# Usage
To run program use ./run.sh
>mvn exec:java
The program will display a menu that will take input from the user
and take action depending the input.

## Design
### Architecture
- PartPicker is a command line application
- The components package defines an abstract class which
  implements an interface that will calculate the tax and total price of the components
- The io package is in charge of reading and parsing the contents,
  of a file inputted by the user in the menu, and stores it in a 
  list of components for later use
- The io.sqlDataSource creates Connection objects for       sqlOperationRepository
- sqlOperationRepository inserts and selects data from a sql database

## Main Algorithm
- The main class will display a menu and ask the user to
  type a number from 1 to 3 from the selections
- That input will be store and passed into the main loop
    - while the userinput is not equal to 0
    - If userinput is equal to 1
        - Yet to write code to it
    - Else if userinput is equal to 2
        - File menu is displayed and user has to type name of file
        - It opens the typed string as a file
        - FileParser loads the file into a List of Components
        - Each Component's total price is calculated
        - The List is passed to a sqlComponentsRepository to insert all Operations to a sql database
        - sqlComponentsRepository  queries the database for all Components on the list
        - The returned List of Components is printed to the console/ terminal
    - Else if userinput is equal to 3
        - A connection to a httpserver is open
        - the total price of the pc build will be displayed
        on the browser when typing http://localhost:8080
- Else a usage guide is printed to the console
- The main menu is displayed again so the user can type another
  selection
- If user types 0 the application will exit
# Project-0-JohnsonA1
