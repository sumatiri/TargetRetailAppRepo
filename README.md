# TargetRetailAppRepo
MyRetail Restful Service

# Project Outline

# Spring Tool Suite 4
# Java 

# Mongo DB database

Database Name : myretaildb
This has  two collections:
1)	productinfo – Since the target API was not working. This acts like dummy external API from which Product Name is fetched.
Please insert few records in this collection using:

     db.productinfo.insert({"_id":13860429,"name":"The Flat-      Screen(Blu-Ray)"})

     db.productinfo.insert({"_id":13860428,"name":"The Big Lebowski(Blu-Ray)(WideScreen)"})

     db.productinfo.insert({"_id":13860427,"name":"MacBook Air"})
WriteResult({ "nInserted" : 1 })


2)	priceinfo – This is for price information as mentioned in the case study document. Please insert few records in this collection using:

 db.priceinfo.insert({"_id":13860429,"value":"1500","currencyCode":"USD"})
db.priceinfo.insert({"_id":13860427,"value":"1500","currencyCode":"USD"})


# Build, test, Run the application

To run the jar

java -jar myretail-0.0.1-SNAPSHOT.jar

Application will run on Port 8082


#Calling myretail api services

Using postman, get and put operations can be performed

GET : http://localhost:8082/products/13860428

Response:

{
    "id": 13860428,
    "name": "The Big Lebowski(Blu-Ray)(WideScreen)",
    "currentPrice": {
        "value": 500.00,
        "currencycode": "USD"
    }
}

In this GET operation the redsky target URL was not functioning, hence the application picks product name from a dummy URL and later combines with price information to show the above response.

PUT: http://localhost:8082/products/13860428

Request Body:
{
    "id": 13860428,
    "currentPrice" : {
        "value": 500.00,
        "currencyCode":"USD"
    }
}

Response:
{
    "id": 13860428,
    "name": "The Big Lebowski(Blu-Ray)(WideScreen)",
    "currentPrice": {
        "value": 500.00,
        "currencycode": "USD"
    }
}







MyRetail Restful Service

# Project Outline

# Spring Tool Suite 4
# Java 

# Mongo DB database

Database Name : myretaildb
This has  two collections:
1)	productinfo – Since the target API was not working. This acts like dummy external API from which Product Name is fetched.
Please insert few records in this collection using:

     db.productinfo.insert({"_id":13860429,"name":"The Flat-Screen(Blu-Ray)"})

     db.productinfo.insert({"_id":13860428,"name":"The Big Lebowski(Blu-Ray)(WideScreen)"})

     db.productinfo.insert({"_id":13860427,"name":"MacBook Air"})



2)	priceinfo – This is for price information as mentioned in the case study document. Please insert few records in this collection using:

 db.priceinfo.insert({"_id":13860429,"value":"1500","currencyCode":"USD"})
 db.priceinfo.insert({"_id":13860428,"value":"500","currencyCode":"USD"})
 db.priceinfo.insert({"_id":13860427,"value":"1500","currencyCode":"Pound"})


# Build, test, Run the application

To run the jar

java -jar myretail-0.0.1-SNAPSHOT.jar

Application will run on Port 8082


#Calling myretail api services

Using postman, get and put operations can be performed

GET : http://localhost:8082/products/13860428

Response:

{
    "id": 13860428,
    "name": "The Big Lebowski(Blu-Ray)(WideScreen)",
    "currentPrice": {
        "value": 500.00,
        "currencycode": "USD"
    }
}

In this GET operation the redsky target URL was not functioning, hence the application picks product name from a dummy URL and later combines with price information to show the above response.

PUT: http://localhost:8082/products/13860428

Request Body:
{
    "id": 13860428,
    "currentPrice" : {
        "value": 500.00,
        "currencyCode":"USD"
    }
}

Response:
{
    "id": 13860428,
    "name": "The Big Lebowski(Blu-Ray)(WideScreen)",
    "currentPrice": {
        "value": 500.00,
        "currencycode": "USD"
    }
}



