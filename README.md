# Keycloak-Integration-with-Spring-Boot-3

This project secures a Spring Boot application using Keycloak, an open-source Identity and Access Management tool.

## Prerequisites
1. Java 17+
2. Maven
3. Keycloak Server 21+

## Getting Started
Follow these steps to set up the project on your local machine for development and testing.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/chirag-rathod-dev/Keycloak-Integration-with-Spring-Boot-3.git
    ```
2. Navigate into the project directory:
    ```bash
    cd your-repository-name
    ```
3. Use Maven to build the project:
    ```bash
    mvn clean install
    ```
4. You can then run the Spring Boot application using:
    ```bash
    mvn spring-boot:run

## Keycloak Setup

### Get started with Keycloak on Docker
https://www.keycloak.org/getting-started/getting-started-docker

### Create a realm
A realm in Keycloak is equivalent to a tenant. Each realm allows an administrator to create isolated groups of applications and users. Initially, Keycloak includes a single realm, called master. Use this realm only for managing Keycloak and not for managing any applications.

1. Use these steps to create the first realm.
2. Open the Keycloak Admin Console.
3. Click Keycloak next to master realm, then click Create Realm.
4. Enter myrealm in the Realm name field.
5. Click Create.

### Create a client
Use these steps to create a client:

1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Clients in the left-hand menu.
3. Click Create new client.
4. Fill in the form with the following values:
   * Client ID: rest-api
   * Client Protocol: openid-connect
   * Client Type: Confidential
   * Access Type: Public
5. Login Setting
   * root URL: http://localhost:8081
   * Home URL: http://localhost:8081
   * Valid Redirect URIs: http://localhost:8081/*
   * Valid Post Logout Redirect URIs: http://localhost:8081
   * Web Origins: *
6. Click Save.

### Create a realms role
Use these steps to create a role:

1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Roles in the left-hand menu.
3. Click Create new role.
4. Fill in the form with the following values:
   * Role Name: user
   * Description: User Role
   * Role Name: admin
   * Description: Admin Role
5. Click Save.

### Create a user
Initially, the realm has no users. Use these steps to create a user:

1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Users in the left-hand menu.
3. Click Create new user.
4. Fill in the form with the following values:
   * Email Verified: On
   * Username: myuser
   * Email: any email
   * First name: any first name
   * Last name: any last name
5. Click Create.
6. Click the Credentials tab.
7. Fill in the form with the following values:
   * Password: mypassword
   * Password Confirmation: mypassword
   * Temporary: Off
8. Click Save.
9. Click the Role Mappings tab.
10. Select the role you want to assign to the user. Before this step, you need to create a client role & assign the role to the client.
11. Click Add.

### Create a client role
Use these steps to create a client role:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Client Roles in the left-hand menu.
3. Click Create new client role.
4. Fill in the form with the following values:
   * Name: client_user
   * Description: Client User
   * Name: client_admin
   * Description: Client Admin
5. Click Create.

### Assign Assosiate the role to the client
Use these steps to assign the role to the client:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Realms Roles in the left-hand menu.
3. Click on Role Name (e.g. user) in the list of roles.
4. Open Associated Roles tab.
5. Select the client you want to assign the role to.
6. Select the role you want to assign to the client. e.g client_user or client_admin
7. Click Add.

## Get the OpenID Configuration
http://localhost:8080/realms/myrealm/.well-known/openid-configuration

## Get the Access Token
http://localhost:8080/realms/myrealm/protocol/openid-connect/token
Body (x-www-form-urlencoded)
```json
{
    "client_id": "rest-api",
    "client_secret": "client-secret",
    "grant_type": "password",
    "username": "myuser",
    "password": "mypassword"
}
```
}

## Get the User Info
http://localhost:8080/realms/myrealm/protocol/openid-connect/userinfo
Authorization: Bearer <access_token>

#### If you are getting the error Forbidden 403, You need to add client scopes.
1. Open Client Scopes in the left-hand menu.
2. Click on the client scope (e.g. openid).
3. Click save.
4. Open clients in the left-hand menu then client (e.g. rest-api).
5. Click on the client scope  and add the client scope (e.g. openid) to the client.
6. Make sure openid is default client scope.
7. Click save.
8. Try to get the user info again.

## Test the API
1. Open Postman.
2. Create a new request.
3. Set the request method to POST.
4. Set the URL to http://localhost:8081/api/v1/admin.
5. Set the Authorization header to Bearer <access_token>.
6. Send the request.
7. You should get a response with the message "Hello World!". If you get a 403 Forbidden error, you need to add client scopes.
8. If you get a 401 Unauthorized error, you need to check the access token.
9. If you get a 500 Internal Server Error, you need to check the server logs.
10. If you get a 200 OK response with the message "Hello World!", you have successfully secured the API using Keycloak.
11. You can also test the API using the curl command:
    ```bash
    curl -X POST http://localhost:8081//api/v1/admin -H "Authorization: Bearer <access_token>"
    ```
12. You should get a response with the message "Hello World!".

### You have to add one more user for client_user role. PreAuthorize("hasRole('client_user')") is used in the controller.

## Conclusion
Congratulations! You have successfully secured a Spring Boot application using Keycloak. You can now use Keycloak to manage users, roles, and permissions for your application.
