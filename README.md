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

 **Endpoint**: `/allProducts`

 **Method**: `GET`

**Description**: Retrieves a list of all products available in the system.

 **Response**:

```json
[
    {
        "pid": 101,
        "name": "Samsung Galaxy S24",
        "image": "https://th.bing.com/th/id/OIP.O6Q0e4UmP3pfw-ovYg4k_QAAAA?w=181&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7",
        "costPrice": 66000,
        "quantity": 2,
        "origin": "South Korea",
        "profit": 9900.0,
        "sellPrice": 75900,
        "gst": 13662.0,
        "amount": 151800
    },
]
```

---

### API 2: Create a New Product

 **Endpoint**: `/save`

 **Method**: `POST`

 **Description**: Adds a new product to the system. The `pid` is auto-incremented.

 **Request**:

```json
{
   "pid": 103,
    "name": "Apple ipad pro 11",
    "image": "https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_hero_04202021_big.jpg.large.jpg",
    "costPrice": 96000,
    "quantity": 1,
    "origin": "China",
}
```

 **Response**:

```json
{
    "pid": 103,
    "name": "Apple ipad pro 11",
    "image": "https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_hero_04202021_big.jpg.large.jpg",
    "costPrice": 96000,
    "quantity": 1,
    "origin": "China",
    "profit": 14400.0,
    "sellPrice": 110400,
    "gst": 19872.0,
    "amount": 130272
}
```

---

### API 3: Get Product by ID

 **Endpoint**: `/product/{pid}`

 **Method**: `GET`

 **Description**: Fetches details of a product based on the product ID (`pid`). If the product is not found, returns `404 Not Found`.

 **Response**:

```json
{
    "pid": 105,
    "name": "iPhone 16 pro",
    "image": "https://th.bing.com/th/id/OIP.WJgG0-v1zkdtxP0L07G_BgHaJP?w=133&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
    "costPrice": 127000,
    "quantity": 1,
    "origin": "United State",
    "profit": 19050.0,
    "sellPrice": 146050,
    "gst": 26289.0,
    "amount": 172339
}
```

If the `pid` is not found:

```json
{
    "status": 404,
    "message": "Product doesn't exist"
}
```

---

### API 4: Update a Product

 **Endpoint**: `/update/{pid}`

 **Method**: `PUT`

 **Description**: Updates an existing product based on the provided `pid`. If the product is not found, returns `404 Not Found`.

 **Request**:

```json
{
    "quantity": 2,
}
```

 **Response**:

```json
{
    "pid": 103,
    "name": "Apple ipad pro 11",
    "image": "https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_hero_04202021_big.jpg.large.jpg",
    "costPrice": 96000,
    "quantity": 2,
    "origin": "China",
    "profit": 14400.001,
    "sellPrice": 110400,
    "gst": 19872.0,
    "amount": 260544
}
```

---

### API 5: Delete a Product

 **Endpoint**: `/delete/{pid}`

 **Method**: `DELETE`

 **Description**: Deletes a product based on the `pid`. If the product is not found, returns `404 Not Found`.

 **Response**:

```json
{
    "status": "Product Deleted Successfully"
}
```

If the `pid` is not found:

```json
{
    "status": 404,
    "message": "Product doesn't exist"
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

## Note:
Refer to the **Product-Management-Using-ReactJs** repository, where I have implemented the same operations using **ReactJS**, integrated with **Spring Boot** and **MySQL**.
