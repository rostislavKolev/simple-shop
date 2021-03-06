# simple-shop
Spring Boot application that handles CRUD operations for a simple shop.

Java Version:
  sourceCompatibility = '1.8'
DB:
  PostgreSQL

You can find API documentation after running the project 
on this url: http://localhost:8080/ui-docs.html

Current application has these three entities:

1.Product
 - long id
 - String productId
 - String name (unique column)
 - boolean isAvailable
 - Timestamp creationDate

2.Subscriber
 - long id
 - String subscriberId
 - String firstName
 - String lastName
 - String email (unique column)
 - List of purchases
 - Timestamp creationDate

3.Purchase
 - long id
 - purchaseId
 - externalId (unique, added in order to achieve idempotency)
 - subscriberId
 - List of purchaseDetails

4.PurchaseDetails
 - long id
 - purchaseId
 - productId
 - quantity

Controllers:
1.ProductController currently provides endpoints for:
 - Create Product
 - Get Product
 - Update Product
 - Delete Product

2.SubscriberController currently provides endpoints for:
 - Create Subscriber
 - Get Subscriber
 - Update Subscriber
 - Delete Subscriber


3.PurchaseController currently provides endpoints for:
  - Create Purchase
  - Get Purchase


Tests:
1.ProductController has currently only one test.. 


##TODO:
  - Finish described functionalities.
  - Add validations for ReuqestModels and entities.
  - Add more tests.
  
