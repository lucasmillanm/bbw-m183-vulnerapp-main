# Vulner App

This is VulnerApp, this is my beautiful creation - Lucas Millan Miles

# Security Features

### 1. Usage of Correct REST Verbs

The application follows the RESTful design principles and utilizes the appropriate HTTP verbs (GET, POST, DELETE) for performing corresponding operations on resources.

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

While the application has implemented various security measures, there are still potential vulnerabilities present. For example, the application is vulnerable to cross-site scripting (XSS) attacks if user input is not properly sanitized before displaying it in the application.
Cross-Site Request Forgery (CSRF): Although CSRF protection has been implemented, further measures can be taken to strengthen it. The application should generate and validate unique tokens for each user session or request to ensure that requests originated from the same site and are not forged by malicious entities.

# UPDATE: NEW FEATURES AND FIXES

I fixed the @GetMapping on the deleteUser() => I changed it to @DeleteMapping.
I added an existsByUsername method in the userRepository. This enhancement enables more efficient user requests by checking if a username already exists before creating a new user. The existence of the user is checked to avoid executing a false operation like deleting a non-existent user. These checks enhance data integrity and prevent potential conflicts or errors.
I also implemented tests to enable easier and more comprehensive testing of the application's functionality and security. Testing plays a crucial role in identifying and fixing issues, ensuring that the application performs as expected and meets the desired security standards. By incorporating tests, the development process becomes more reliable, and potential vulnerabilities or bugs can be detected early, reducing the risk of security breaches or functional inconsistencies.