# ChangeLog

## Version 1.1.1
### Added
- HttpServer.java and its addition to display
  the total price for the user's parts(not fully implemented though), ComponentsTest.java

### Modified
- Main java file to display the correct menus and access and retrieve data from the database
- IO.java implements another method to receive a string input
- Components.java returns a new toString() method
- Menu.java contains a new menu and formatted the rest
- Renamed the csv file
- Modified Readme and Changelog.md

## Version 1.0.1
### Added
- ComponentsFactory.java, Cpu.java, Gpu.java, Moth.java, Ssd.java, TaxComputation.java, Dao interface for the IO.java
- Sql repositories and data source to persits the data to the database
- Dockerfile
- Schema file
- JUnit test path for sql and for components
- sqlComponentsRepositoryTest.java and ComponentsTest.java

### Modified
- Overhaul for the whole application
- ChangeLog.md
- Menu.java
- main java file
- IO.java to implement an interface
- Components.java to implement a factory

## Version 1.0.0
### Added
- File Reader method in the Components.java file
- Interface to read the file (Dao.java)
- Test csv file

### Modified
- Components.java, IO.java, Menu.java, ChangeLog.md, Readme.md and PartPicker.java

## Version 0.1.0
### Added
- IO,java, Components.java, and Menu.java packages
- OOP

### Modified
- ChangeLog.md file
- PartPicker.java file by adding all the corresponding packages
- Corrected output problems and fixed main class issues
- Remodeled all files
- pom.xml file to include the mnv exec command in properties 

## Version 0.0.2
### Added
- Mavenization of the entire project
  (Added folders for maven)
- run.sh file for easy access
- pom.xml file to run maven

### Modified
- ChangeLog.md file
- PartPicker.java file by creating a package
- Build.sh file to compile maven
- More files to the .gitignore file

## Version 0.0.1
### Added
- PartPicker.java main file
  Started by declaring some temporary variables for testing
  Then a main menu was added for the user to choose each PC component
  Once chosen, a list of pc parts will show and another user promt as well
  After selection the running total will be updated and the main menu will be shown again

- Build.sh file
  File created just to compile the java file

- ChangeLof.md file
  File made to keep track of the different versions of the project

- Readme.md file
  Gives a small insight of what the project is about

- .gitignore file
  Created to ignore unwanted files
