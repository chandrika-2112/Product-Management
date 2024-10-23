# Product Management

Here’s the `README.md` file tailored to your **Product Management System** project:

---

# Product Management System

This is a **Spring Boot** application that provides a RESTful API for managing products. It uses **MySQL** as the database, and **Postman** can be used to test the API endpoints. The system allows users to create, update, delete, and fetch product details.

## Project Structure

The application consists of five main files:

1. **Product.java**: Entity class representing the `Product` model.
2. **ProductController.java**: Handles all incoming HTTP requests.
3. **ProductServices.java**: Implements business logic for handling products.
4. **ProductInterface.java**: Interface containing method signatures.
5. **ProductRepository.java**: Extends `JpaRepository` for database operations with MySQL.

### Product Model

```java
public class Product {
    @Id
    private int pid;
    private String name;
    private String image;
    private int costPrice;
    private int quantity;
    private String origin;
    private float profit;
    private int sellPrice;
    private float gst;
    private int amount;
    
    // Getters and Setters
}
```

### API Endpoints

The following APIs are available in this system:

---

### API 1: Get All Products

#### **Endpoint**: `/products`

#### **Method**: `GET`

#### **Description**: Retrieves a list of all products available in the system.

#### **Response**:

```json
[
    {
        "pid": 1,
        "name": "Laptop",
        "image": "laptop.png",
        "costPrice": 50000,
        "quantity": 10,
        "origin": "India",
        "profit": 5000.0,
        "sellPrice": 55000,
        "gst": 18.0,
        "amount": 64900
    },
    {
        "pid": 2,
        "name": "Mobile",
        "image": "mobile.png",
        "costPrice": 30000,
        "quantity": 20,
        "origin": "China",
        "profit": 3000.0,
        "sellPrice": 33000,
        "gst": 18.0,
        "amount": 38940
    }
]
```

---

### API 2: Create a New Product

#### **Endpoint**: `/products`

#### **Method**: `POST`

#### **Description**: Adds a new product to the system. The `pid` is auto-incremented.

#### **Request**:

```json
{
    "name": "Tablet",
    "image": "tablet.png",
    "costPrice": 25000,
    "quantity": 15,
    "origin": "USA",
    "profit": 2000.0,
    "sellPrice": 27000,
    "gst": 18.0,
    "amount": 31860
}
```

#### **Response**:

```json
{
    "pid": 6,
    "name": "Tablet",
    "image": "tablet.png",
    "costPrice": 25000,
    "quantity": 15,
    "origin": "USA",
    "profit": 2000.0,
    "sellPrice": 27000,
    "gst": 18.0,
    "amount": 31860
}
```

---

### API 3: Get Product by ID

#### **Endpoint**: `/products/{pid}`

#### **Method**: `GET`

#### **Description**: Fetches details of a product based on the product ID (`pid`). If the product is not found, returns `404 Not Found`.

#### **Response**:

```json
{
    "pid": 3,
    "name": "Smartwatch",
    "image": "smartwatch.png",
    "costPrice": 10000,
    "quantity": 30,
    "origin": "Japan",
    "profit": 1500.0,
    "sellPrice": 11500,
    "gst": 18.0,
    "amount": 13570
}
```

If the `pid` is not found:

```json
{
    "status": 404,
    "message": "Product not found"
}
```

---

### API 4: Update a Product

#### **Endpoint**: `/products/{pid}`

#### **Method**: `PUT`

#### **Description**: Updates an existing product based on the provided `pid`. If the product is not found, returns `404 Not Found`.

#### **Request**:

```json
{
    "sellPrice": 58000,
    "status": "IN STOCK"
}
```

#### **Response**:

```json
{
    "pid": 1,
    "name": "Laptop",
    "image": "laptop.png",
    "costPrice": 50000,
    "quantity": 10,
    "origin": "India",
    "profit": 8000.0,
    "sellPrice": 58000,
    "gst": 18.0,
    "amount": 68440
}
```

---

### API 5: Delete a Product

#### **Endpoint**: `/products/{pid}`

#### **Method**: `DELETE`

#### **Description**: Deletes a product based on the `pid`. If the product is not found, returns `404 Not Found`.

#### **Response**:

```json
{
    "status": "Product Deleted Successfully"
}
```

If the `pid` is not found:

```json
{
    "status": 404,
    "message": "Product not found"
}
```

---

## Database Configuration

The application uses **MySQL** as its database. To set up the database, ensure that you have the following configurations in your `application.properties` or `application.yml` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/product_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Tools & Technologies Used

- **Java 8+**
- **Spring Boot**
- **MySQL**
- **Postman** for API testing
- **JPA/Hibernate**

---

### Steps to Run the Project

1. Clone the repository.
2. Configure the MySQL database in `application.properties` with your credentials.
3. Run the Spring Boot application.
4. Use **Postman** to test the APIs as documented.

---

Let me know if you need further changes!
