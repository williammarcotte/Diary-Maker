# Diary-Maker

##Introduction
Diary Maker is a full stack application with React for front-end and Rest API with Spring Boot and JPA for
the backend.

##Running
To run the project, download from https://github.com/williammarcotte/Diary-Maker. Run the backend end and the frontend separately.

##Challenges
Some challenges I faced during the creation of Diary Maker was to create the backend for the project. A feature I hope to implement in the future is to create tags for entries.

##Classe structure
In the backend, there are separate classes for Rest architecture. There is a controller, entity, repository, response and service of the diary entries.

##End points
Get: http://localhost:8080/api/entries
Post: http://localhost:8080/api/entries/ -> Entry
get tag: http://localhost:8080/api/entries/{id}/tags
post tag: http://localhost:8080/api/entries/{id}/tags/ -> tag


