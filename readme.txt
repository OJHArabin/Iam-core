Welcome to IAM-rabincore project:

It is an interactive console application that allows you to create, delete, update and search identities. Read to the User Guide.pdf for further help.
This application was build using JDK 1.8

Step to run the application

Setup the database:

Download apache derby client
Create an instance of derby name it instance name =mynew with username="ojha" and password="ojha".
run /db-derby-10.13.1.1-bin/bin/startNetworkServer
Go to iam-rabincore/src/fr/epita/iam-rabincore/config/config.properties edit user value with the user name you used to create your derby schema Do the same with password, the name if instance if you used your own values
Go to iam-rabincore/sql run create_tables.sql on your instance mynew
Run the application:

Go to iam-rabincore/src/fr/epita/iam/launcher execute ConsoleLauncher.java
Developers:

Go to iam_rabincore/doc for documentation
