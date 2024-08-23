# Weather Analysis Programs

## Description

#### This project focuses on creating suitable test cases involving both black and white box concepts.
Throughout the design process I had to follow software design principles such as modularity and adaptability to 
ensure the program is as efficient and simple as possible.

#### The use of Git was to learn how to keep track of the progress of a software project.

#### Not being able to implement my white box testing for certain methods was a failure however i do know that the methods themselves work when used int the program. The usage of git could have been improved with more carefully planned branching and merging which would have allowed for a more organised setup and implementation structure as well as a better idea of what is going on in the overall project. More time could have been dedicated to work on the project stage by stage without having to go back and add something. 

### Scenario A
#### Finding the season of the year when a country name and the month of the year is given.



### Scenario B 
#### Finding whether a given temperate reading is above or below the average temperature of a
city (Morning or Evening) will be provided by the system. If the difference is more than 5⁰C,
additional message also will be provided.



## How to Run the Program

### Scenario A
#### 1. To compile the program enter "javac MainSeasons.java"
#### 2. Run the program by entering "java MainSeasons"
#### 3. Choose a method of data input or exit (Enter 1, 2 or 3)
#### 4. If one is selected, the data will be displayed to you and you can choose to use the program again. If two is selected, enter a country name from the ones shown then enter a month of the year and the data will be displayed to you and you can hcoose to use the program again. If three is selected the program will end.

### Scenario B
#### 1. To compile the program enter "javac MainWeather.java"
#### 2. Run the program by entering "java MainWeather"
#### 3. Choose a method of data input or exit (Enter 1, 2 or 3)
#### 4. If one is selected the data will be displayed to you and you can choose to use the program again. If two is selected, enter the name of the city from one of the ones shown then enter a temperature of choice andd the data will be displayed to you and you can choose to use the program again. If three is selected then the program will end.




## Contents of "Code" file

Code: contains production and testing code
	- ScenarioA:
		- MainSeasons is the main class
		- Seasons is the class containing methods for seasons
		- TestSeasons contains testing code
		- testFile is made when TestSeasons is run
		- seasonsData is a csv file containing data for MainSeasons
	- ScenarioB
		- MainWeather is the main class
		- Weather is the class containing methods for weather
		- TestWeather contains testing code
		- temperature is a csv file containing data for MainWeather
