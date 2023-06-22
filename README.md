### Food ordering application

Project is implemented using Java Spring Boot framework (Hibernate, Spring Secuirty with JSON Web token, REST API)

### Project specification

The main purpose of the application is to enable users to view restaurant offers, place food orders, then track the status of their orders, which can be updated by employees. The system consists of three user roles with different capabilities:
- ADMIN
- EMPLOYEE
- USER

The application can also be accessed by unregistered users, who have the following abilities:
- Register an account
- Order food by selecting different meals and specifying quantities. The user can view the menu, choose a meal type, and see the complete offer for that type. By clicking on a selected meal, a modal window appears, allowing the user to enter the quantity and add the meal to the cart. To confirm the final order, a new modal window appears where the user enters their address and phone number since they are not logged in. After successfully placing an order, the user receives a message containing a link to track the order status.

Registered users with the *USER* role can log into the system using their username and password. They have the following abilities:
- Update their personal information
- Order food similar to unregistered users, but without the need to enter their address and phone number since their data is already saved in the system.
- Receive a 10% discount on every order
- View their active orders (with *ORDERED* and *IN PREPARATION* status)
- View the history of their orders (with *IN DELIVERY* status)

Users with the *EMPLOYEE* role have the following abilities:
- Review all incoming orders and change their status to *IN PREPARATION* or *IN DELIVERY*, depending on whether the orders are being prepared or in the process of  delivery.
- View the history of all orders.

Users with the *ADMIN* role have the following abilities:
- Create, delete, and update meal types in the database (including uploading images)
- Create, delete and update meals (including uploading images)
- Logically delete users (change their status, their data remains in the database)
- View the order history
- Create, delete, and update employee data (users with the *EMPLOYEE* role)

