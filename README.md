# Customer Satisfaction Survey App

It is a CRUD application built using Java(springboot, JPA), TYPESCRIPT and REACT.

## Installation

In order to test the frontend and the server together, it is necessary to run both projects.

Node modules are not in the frontend folder. It is necessary to run the package installer.

After opening and running the Java project with the file named pom.xml, run React App. React can be run using app yarn.

```bash
cd frontend
npm i
yarn start
```

## DB Connection

It is used with the JPA and PostgreSQL libraries. The db connection can be established by updating the information in the resources/application.properties file. There should be a db named postgres.

## Controllers

All functions including CRUD operations are located in the controller folder.

## Routes

All routes are defined with RequestMapping within the controller classes.

## Frontend

Routes are defined in the Routes.tsx file in the src folder and they work in the app.tsx file. Pages can be changed by making changes in the Pages folder. Also, navbar is defined as navbar component.
