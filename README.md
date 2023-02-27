# springboot_crud

This is a spring boot web application with example CRUD operations with supporting REST Apis

Features,

1.Jpa Hibernate is used for repository.
2.There are four entieties Vendor, Product, Transaction and TransactionDetail.
    x: Transaction has many Transaction Details - handles with one to many uni directional mapping
3.REST Apis available for for Entity types POST , GET , PUT, DELETE and PATCH
4.Common Exception Handler to handle global exception with @ControllerAdvice.
