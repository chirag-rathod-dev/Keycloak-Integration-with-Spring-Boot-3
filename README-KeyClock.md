## Get started with Keycloak on Docker
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




 