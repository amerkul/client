# client

Client is a test application which obtains data from cloud service. Implement the Circuit breaker pattern.


# Prerequisites

You need to have [```Docker```](https://www.docker.com), ```Java 17+```, and ```Maven 3.3+``` installed.

# Get started

```shell
./mvnw clean install

docker-compose up
```
# Endpoints

### Get

```
http://localhost:8081/client/all
```
### Post

```
http://localhost:8081/client/insert
```

### Json Example 
```json
{
      "id": 1,
      "name": "Name_1",
      "category": "Category_1",
      "color": "Color_1",
      "price": 1
}
```
