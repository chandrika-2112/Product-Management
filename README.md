# Product Management System

This project is a **Product Management System** that provides a RESTful API for managing products through a **Spring Boot** back-end and a **ReactJS** front-end. It uses **MySQL** as the database, and **Postman** can be used to test the API endpoints. The system allows users to **create**, **update**, **delete**, and **fetch** product details.

## Features

1. **Add Product**: Users can add new products by providing details such as product ID, name, image URL, cost price, quantity, and origin.
2. **View Products**: Users can view a list of all products, with additional details like profit, sell price, GST, and amount.
3. **Edit Product**: Users can update existing product details.
4. **Delete Product**: Users can delete products from the list.
5. **Integration**: The front-end (ReactJS) and back-end (Spring Boot) are connected using REST APIs, with MySQL storing product data.

## Technologies Used

- **Frontend**: ReactJS, Axios
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Testing**: Postman
- **Routing**: React Router
- **Database Interaction**: JPA/Hibernate

## Project Structure

### Backend (Spring Boot)

1. **ProductController.java**: Handles the REST API endpoints for product operations.
2. **ProductServices.java**: Contains business logic for managing products.
3. **ProductRepository.java**: Extends `JpaRepository` to manage database operations with MySQL.
4. **Product.java**: Entity class representing the `Product` model.

### Frontend (ReactJS)

1. **`AddProduct.jsx`**: Form component to add a new product.
2. **`EditProduct.jsx`**: Form component to edit an existing product.
3. **`ViewProduct.jsx`**: Component to view a list of all products.
4. **`Home.jsx`**: Home page of the product management system.
5. **`Master.jsx`**: Manages routing for the React application.

## Product Model

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

## API Endpoints

### 1. Get All Products

- **Endpoint**: `/allProducts`
- **Method**: `GET`
- **Description**: Retrieves a list of all products.

#### Sample Response

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
    }
]
```

### 2. Create a New Product

- **Endpoint**: `/save`
- **Method**: `POST`
- **Description**: Adds a new product to the system.

#### Sample Request

```json
{
    "pid": 103,
    "name": "Apple iPad Pro 11",
    "image": "https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_hero_04202021_big.jpg.large.jpg",
    "costPrice": 96000,
    "quantity": 1,
    "origin": "China"
}
```

#### Sample Response

```json
{
    "pid": 103,
    "name": "Apple iPad Pro 11",
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

### 3. Get Product by ID

- **Endpoint**: `/product/{pid}`
- **Method**: `GET`
- **Description**: Fetches details of a product based on the product ID (`pid`).

#### Sample Response

```json
{
    "pid": 105,
    "name": "iPhone 16 Pro",
    "image": "https://th.bing.com/th/id/OIP.WJgG0-v1zkdtxP0L07G_BgHaJP?w=133&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7",
    "costPrice": 127000,
    "quantity": 1,
    "origin": "United States",
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

### 4. Update a Product

- **Endpoint**: `/update/{pid}`
- **Method**: `PUT`
- **Description**: Updates an existing product based on the provided `pid`.

#### Sample Request

```json
{
    "quantity": 2
}
```

#### Sample Response

```json
{
    "pid": 103,
    "name": "Apple iPad Pro 11",
    "image": "https://www.apple.com/newsroom/images/product/ipad/standard/apple_ipad-pro-spring21_hero_04202021_big.jpg.large.jpg",
    "costPrice": 96000,
    "quantity": 2,
    "origin": "China",
    "profit": 14400.0,
    "sellPrice": 110400,
    "gst": 19872.0,
    "amount": 260544
}
```

### 5. Delete a Product

- **Endpoint**: `/delete/{pid}`
- **Method**: `DELETE`
- **Description**: Deletes a product based on the `pid`.

#### Sample Response

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

## Database Configuration

The application uses **MySQL**. Configure the following in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Steps to Run the Project

### Backend (Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/chandrika-2112/Product-Management.git
   ```
2. Set up the `application.properties` file in **Spring Boot** with MySQL credentials.
3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend (ReactJS)

1. Navigate to the React project folder.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Start the React app:
   ```bash
   npm run dev
   ```

### Database (MySQL)

Ensure the database is running, and the `database` is created.

#### Product Table Schema

```sql
CREATE TABLE product (
    pid INT PRIMARY KEY,
    name VARCHAR(255),
    image VARCHAR(255),
    costPrice INT,
    quantity INT,
    origin VARCHAR(255),
    profit FLOAT,
    sellPrice INT,
    gst FLOAT,
    amount INT
);
```

## Tools & Technologies

- **Java 8+**
- **Spring Boot**
- **MySQL**
- **Postman**
- **ReactJS**
