# Test Project
## Libraries and plugins used

- [Rest Assured](https://rest-assured.io/)

## Dependencies

To run the tests, please ensure you have the following installed:

- JDK 8
- Maven 3.5.x
- Eclipse IDE

## How to run

```
given().
    body("JSON")
when().
    post("/path").
then().
    assertThat().statusCode(200);
```

to run script
Click tab Run -> Run or Right click on file Basics.java --> Run As Java Application
