# Vulner App - Spring Boot Application

This is a vulnerable Spring Boot application that demonstrates various security vulnerabilities and their corresponding mitigations. The application is designed to fulfill the following requirements:

# Security Features

### 1. Usage of Correct REST Verbs

The application follows the RESTful design principles and utilizes the appropriate HTTP verbs (GET, POST, PUT, DELETE) for performing corresponding operations on resources.

### 2. Authentication - BasicAuth

The application implements Basic Authentication. Users are required to provide their credentials (username and password) with each request to access protected resources. 
Then I also removed the Pop-Up when you try to create a post, I did it by implementing it in the header, so it doesn't request an additional Login.

### 3. RBAC

RBAC is enforced in the application by distinguishing between User and Admin. Different roles have different levels of access and permissions within the application. For example the user does not have the permission to create a new User nor to delete a User, etc.

### 4. CSRF Protection

CSRF (Cross-Site Request Forgery) protection is activated in the application. 
This was added to not be able to do something you are not allowed to. For example, somebody that just randomly wants to add a new Blog, can not just POST a new Blog. But they do have the permission to GET them.

### 5. Secure Password Storage

Passwords are securely stored in the application using hashing techniques. When a user registers their password, it is hashed using a strong cryptographic algorithm (bcrypt).

### 6. Input Validation

The application implements input validation for REST endpoints and database operations. For example, you can not POST an empty User.

## What's missing

My Code is still vulnerable to a lot of attacks, for example you could still enter a <script> tag in the body of the Blog.

## Improvements

I could have invested more times with the tests, since I don't really have any. The app is not perfect, but I feel like I've still done a good job.
I would grade this project a solid 4.9
