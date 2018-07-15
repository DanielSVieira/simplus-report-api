# About this project

This is a project based on Spring Boot + JPA, running over a H2 Database.
The goal of this project is create an application for reports. 
There is 2 reports for each company, and all of them should be added into a zip file.

# How run this project 
go to ${projectRoot}/


execute the command below:

```
mvn -f spring-boot:run
```


To access the application, please check the URL below:
http://localhost:8080/


At this page there is a grid that will display all records added into data.sql file 

There is a button for reports that will generate a zip file containing all reports available for all records.
This button doesn't obbey the grid filter.

### APIs

The apis available are:

```
http://localhost:8080/report/createDefaultReport
```

this will generate a default report, with a zip file being written in temporary file.


```
http://localhost:8080/report/createDefaultReportInMemory
```

this will generate a default report, with a zip file being processed entirelly in memory, in buffer.


```
http://localhost:8080/report/createReportInMemory
```

this will generate a default report, with a zip file being processed entirelly in memory, in buffer, with a possibility of filters.
For example:


```
http://localhost:8080/report/createReport?companyName=anho
```


To catch all APIs available, please read documentation at:

```
http://localhost:8080/v2/api-docs
```


### Generating an war for this project

At the ${projectRoot}/run the command below:

```
mvn package java -war 
```
