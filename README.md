# Keycloak-Integration-with-Spring-Boot-3

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
   * Client ID: myclient
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
    * Username: myuser
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

### Assign the role to the client
Use these steps to assign the role to the client:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Client Roles in the left-hand menu.
3. Click Assign client role to client.
4. Select the client you want to assign the role to.
5. Select the role you want to assign to the client.
6. Click Add.

http://localhost:8080/realms/myrealm/.well-known/openid-configuration

----------------------------------------------------------------------------------------------------------------------------

### Create a scope
Use these steps to create a scope:   
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Scopes in the left-hand menu.
3. Click Create new scope.
4. Fill in the form with the following values:
   * Name: myscope
   * Display Name: My Scope
   * Description: My Scope
5. Click Create.

### Create a protocol mapper
Use these steps to create a protocol mapper:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Protocol Mappers in the left-hand menu.
3. Click Create new protocol mapper.
4. Fill in the form with the following values:
   * Name: myscope
   * Mapper Type: Audience
   * Included Client Audience: myclient
5. Click Create.

### Create a policy
Use these steps to create a policy:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Policies in the left-hand menu.
3. Click Create new policy.
4. Fill in the form with the following values:
   * Name: myscope
   * Policy Type: Resource
   * Resource Type: Scope
   * Resource Name: myscope
5. Click Create.

### Assign the scope to the client
Use these steps to assign the scope to the client:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Client Scopes in the left-hand menu.
3. Click Assign scope to client.
4. Select the client you want to assign the scope to.
5. Select the scope you want to assign to the client.
6. Click Add.

### Assign the protocol mapper to the client
Use these steps to assign the protocol mapper to the client:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Protocol Mappers in the left-hand menu.
3. Click Assign protocol mapper to client.
4. Select the client you want to assign the protocol mapper to.
5. Select the protocol mapper you want to assign to the client.
6. Click Add.

### Assign the policy to the client
Use these steps to assign the policy to the client:
1. Verify that you are still in the myrealm realm, which is shown above the word Manage.
2. Click Policies in the left-hand menu.
3. Click Assign policy to client.
4. Select the client you want to assign the policy to.
5. Select the policy you want to assign to the client.
6. Click Add.

#### This user needs a password to log in. To set the initial password:

1. Click Credentials at the top of the page.
2. Fill in the Set password form with a password.
3. Toggle Temporary to Off so that the user does not need to update this password at the first login.