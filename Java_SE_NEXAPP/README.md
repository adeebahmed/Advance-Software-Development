This is a Java SE application modeled after NEX (https://github.com/adeebahmed/NEX). It implements CRUD functionality for my entities utilizing JPA. 

It also included unit testing done using Junit. 

Project Summery

Create - It persists an entity into the database and if the entity was successfully create it will have an ID assigned to it.
Read - It compares .toString() output to the expected output, it they match then the entity was successfully read
Update - It updates an entities values using setters and then merges the entity back into the database.
Delete - It uses the remove() function to remove the entity from the database using it's composite/business key.
Utilizes JPA to run CRUD operations on Entities in addition to using the persistence unit to map objects to the database.
Using ORM the entities are mapped to MySql database.
JUnit tests for each entities CRUD operations.

Design

My project is based off my iPro project from last semester, it took 1st place in its track at iPro day.
It is a very basic implementation of the entities, great starting point.
I have a more advance schema that I did not have the chance to implement due to time.
I implemented a one-to-many relationship for Companies and Job Recruiters.
I implemented a one-to-one relationship between Job Seekers and Resume.
I implemented a many-to-one relationship for Events and Organization.