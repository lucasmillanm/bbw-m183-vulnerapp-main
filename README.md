# Vulner App - Spring Boot Application

This is a vulnerable Spring Boot application that demonstrates various security vulnerabilities and their corresponding mitigations. The application is designed to fulfill the following requirements:

## Requirements

1. Usage of correct REST verbs.
2. Implementation of an authentication solution (e.g., BasicAuth).
3. Enforce RBAC (z.B. User- und Admin-Services unterscheiden).
4. Aktivieren von CSRF-Protection und Erklärung, warum diese Implementation funktioniert.
5. Implementierung einer sicheren Passwort-Speicherung (Hashing, Passwortregeln).
6. Strikte Inputvalidierung (für REST-Endpunkte und Datenbank).

## Security Features

### 1. Usage of Correct REST Verbs

The application follows the RESTful design principles and utilizes the appropriate HTTP verbs (GET, POST, PUT, DELETE) for performing corresponding operations on resources.

### 2. Authentication Solution - BasicAuth

The application implements Basic Authentication as the authentication solution. Users are required to provide their credentials (username and password) with each request to access protected resources.

### 3. Role-Based Access Control (RBAC)

RBAC is enforced in the application by distinguishing between User and Admin services. Different roles have different levels of access and permissions within the application.

### 4. CSRF Protection

CSRF (Cross-Site Request Forgery) protection is activated in the application. CSRF tokens are generated and included in the requests to prevent unauthorized requests from malicious websites. This implementation works by validating the CSRF token sent with each request against the server-side token stored in the user's session.

### 5. Secure Password Storage

Passwords are securely stored in the application using hashing techniques. When a user registers or updates their password, it is hashed using a strong cryptographic algorithm (e.g., bcrypt). This ensures that even if the password hashes are exposed, they cannot be easily reversed to obtain the original passwords.

### 6. Strict Input Validation

The application implements strict input validation for REST endpoints and database operations. It validates user input to prevent common security vulnerabilities such as SQL injection, cross-site scripting (XSS), and other forms of code injection attacks.

## Acknowledgements
