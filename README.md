The problem: 

The application resolve a problem related to detecting a pair of employees who have worked together on common projects for a longest time.

The solution:

#STARTING THE APP
1.To start the app you have to have already created a DB with name "employees" with table "employee".
2.Then you have to set the settings needed in the "application.properties" otherwise the app won't start and will throw an error.
3.Open the URL according your own settings to see the app in the browser.

#Step-by-step 
1. The app reads CSV file, where are already added some records.
2. Then checks if the DB is empty.
  2.1 If it is empty saves all the data from the file to the DB.
  2.2 Otherwise it gets all of the records of the DB and compare the records from the DB to the records from the CSV file.
    2.2.1 If The records are the same, the record from the CSV file won't be pushed to the DB.
    2.2.2 If there is a difference the record will be added to the DB.
3. After the DB is completed with the additional information from the CSV file, all of the records are requested from the DB with findAll() method.
4. With this info and already created view template - with HTML file and styled with CSS file - Thymeleafe engine helps the info to be rendered in the browser.
5. If we want to navigate to see which is the winner pair among all of the employees at the DB we can add to URL /displayResult or just use the button at the nav-bar.
6. The info from the DB goes trough couple of filters that are implemented with for-loops and comparisons.
