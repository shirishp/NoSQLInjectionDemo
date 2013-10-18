# NoSQL Injection Demo Application

An application to demo NoSQL Injection attack on MongoDB

---
## Requirements
* Java 6+
* MongoDB
* Maven 3

## Getting started
1. Make sure your mongoDB server is up and running. If MongoDB requires authentication, please make corresponding changes to `NoSQLDatabase.java`
2. Execute maven goal `mvn jetty:run`. This will start jetty server. By default it will reload changes (if any) every one second.
3. Visit [http://localhost:8080](http://localhost:8080). And try following searches
  * `Robb`
  * `Robb', 'address':'Kingslayer`
  * `Robb', $where: 'function(){print("Testing"); return this.name == "Robb"}'})`
  * `Robb', $where: 'function(){sleep(5000); return this.name == "Robb"}'})`
  * `Robb', name:{$ne:'Robb'}, address:'Kingslayer`
