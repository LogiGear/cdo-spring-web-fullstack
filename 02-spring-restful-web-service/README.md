# Introduction
- This source code folder will be included Spring Web MVC, RESTful API Web Services, Spring Core, Spring Bean, Servlet API, JSP, Servlet Session concepts.

# In-course
- Trainee will be trained:
    + How to leverage Spring Boot Web MVC by integrating JSP View into Spring Boot Application.
    + Understanding basic JSP declaratives, tags.
    + Servlet Life Cycle (request, response, session, application, page).
    + Implementing and Understanding Servlet's Filter concepts.
    + Review @Component, @Service, @Controller, @Repository annotations.
    + Knowing how difference are @Controller and @RestController.
    + Understanding basic HTTP Methods, HTTP Status.
    + Implementing a RESTful API Web Service.
    + ResponseEntity object introduction.
    + Implmeneting a full-ledge CRUD RESTful API.

# Exercice
+ 1. Leveraging Servlet's Filter to help Spring Boot App to set permission for each resource (Role-based Filter).
    - How to do this:
        + Implement a normal Servlet's Filter.
        + Enable Servlet's @SessionAtrributes annotation.
        + Implement code in Filter to decide whether user has the right permission to access the resource.
        + Good to go.
+ 2. Implementing full CRUD using JSP & Servlet's API to manage employees.
        ```java
        public class Employee {
            private String username;
            private String password;
            private String fullname;
            private String role;
        }
        ```