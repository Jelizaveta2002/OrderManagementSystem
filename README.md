# Setting up Application

In order to run application it is needed to run docker-compose.yml file (it is possible to run by typing command "docker compose up") in
terminal. Note that nothing should be run on ports 8080, 5432.
Add postgres database with url: jdbc:postgresql://postgres:5432/postgres
user: postgres, password:postgres.
Run OrderManagementSystem application.

## Database

Postgres, database is generated using Liquibase.
Database is already filled with some mock data.

## Back-End

Spring Data JPA

Create a new customer: POST: http://localhost:8080/api/customer/addCustomer
Body: {"fullName": "Jelizaveta Voloshina",
"email": "jelizavetav@gmail.com",
"telephone": "+37256276506"
}

Create a new product: POST: http://localhost:8080/api/product/addProduct
Body: {"name": "banana",
"unitPrice": 1.3
}

Create a new Order: POST: http://localhost:8080/api/order/addOrder
Body: {
"customerId": 4
}

Create a new orderLine: POST: http://localhost:8080/api/order/addOrderLine
Body: {
"orderId": 1,
"productId": 1,
"quantity": 3
}

Get orders by customer: GET:  http://localhost:8080/api/order/getOrdersByCustomer
Body: {
"id": 4,
"registrationCode": REGISTRATION CODE
"fullName": "Jelizaveta Voloshina",
"email": "jelizavetav@gmail.com",
"telephone": "+37256276506"
}

Get order by id: GET:  http://localhost:8080/api/order/getOrderById?id=1

Get orders by date: GET: http://localhost:8080/api/order/getOrdersByDate?date=2023-09-11T15:30:00  ##change date

Get orders by product: GET: http://localhost:8080/api/order/getOrdersByProduct
Body: {
"id": 4,
"name": "banana",
"skuCode": GENERATED SKU-CODE,
"unitPrice": 1.3
}

## Additional Information
For my project I used some materials from previous university projects.
I also used some tips from https://stackoverflow.com/ and https://chat.openai.com/chat.




