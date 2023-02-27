# springboot_crud

This is a spring boot web application with example CRUD operations with supporting REST Apis

## Features

- Jpa Hibernate is used for repository.
- There are four entieties Vendor, Product, Transaction and TransactionDetail.
    > Transaction has many Transaction Details - handles with one to many uni directional mapping
- REST Apis available for for Entity types POST , GET , PUT, DELETE and PATCH
- Common Exception Handler to handle global exception with @ControllerAdvice.

