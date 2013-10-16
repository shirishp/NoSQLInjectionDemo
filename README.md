# NoSQL Injection Demo Application

An application to demo NoSQL Injection attach on MongoDB

The application has two endpoints, which takes `name` parameter and return result of search from database:

1. /secure-find
2. /insecure-find

---
## Requirements
* Java 6+
* MongoDB
* Maven 3

## Getting started
1. Make sure your mongoDB server is up and running. If MongoDB requires authentication, please make corresponding changes to NoSQLDatabase.java
2. Execute maven goal `mvn jetty:run`. This will start jetty server. By default it will reload changes (if any) every one second.
3. Try following URLs in browser
- `http://localhost:8080/insecure-find?name=Robb`
- `http://localhost:8080/insecure-find?name=Robb%27%2C%20%27address%27%3A%27Kingslayer`
- `http://localhost:8080/insecure-find?name=Robb%27,%20$where:%20%27function%28%29{print%28%22Testing%22%29;%20return%20this.name%20==%20%22Robb%22}%27}%29`
- `http://localhost:8080/insecure-find?name=Robb%27,%20$where:%20%27function%28%29{sleep%285000%29;%20return%20this.name%20==%20%22Robb%22}%27}%29`
4. Now try above URLs with /secure-find endpoint