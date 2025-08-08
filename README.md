Vehicle rental project

I wrote this for my Java class to demonstrate my understanding of classes, encapsulation, and polymorphism. This project is intended to allow a user to rent vehicles from the provided database.
It displays location information for the rental locations, customer information, the rentals with their relevant details, a rental summary, total cost, 
and a final message demonstrating that this information was properly stored within the database.

Installation Instructions: I downloaded Java JDK 23, Eclipse, and Microsoft SQL Server onto my desktop in order to create this project. I advise you to download the SQL file for the database
to run the code. At the bottom of the main script, there is a section for connection. I was unable to perform the universal connection, but I did find an alternative that required my personal
information to connect to the SQL server. On line 214, change the jdbc:sqlserver://JULIASPC:1433 to jdbc:sqlserver://YOURINFO (enter in your server name). This should then allow the application 
access to your SQL server on your desktop. 
***You may need to troubleshoot this further. I had to create a special port for SQL on my computer to bypass my firewall.

Usage: Upon running the code, you will see the rental locations. You will then be prompted to enter some information about yourself and your rental. Make your rental selection(s).
Once you make that choice, you will see a rental summary with the model of the vehicle, engine type, number of wheels, and the daily rental cost. You will then see the total rental cost
along with your relevant information.
