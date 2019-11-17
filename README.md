# Retointercorp

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Try it out:

| Method | Command CURL |
| ------ | ------ |
| POST - creacliente | [curl -X POST "http://main-customer-1573970198442.azurewebsites.net/creacliente" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"apellido\": \"Mokey D.\", \"edad\": 20, \"fechaNacimiento\": \"1998-10-23\", \"nombre\": \"Luffy\"}"] |
| GET - kpideclientes | [curl -X GET "http://main-customer-1573970198442.azurewebsites.net/kpideclientes" -H "accept: */*"] |
| GET - listclientes | [curl -X GET "http://main-customer-1573970198442.azurewebsites.net/listclientes" -H "accept: */*"] |

For local deployment

```sh
git clone https://github.com/granchronos/retointercorp.git
cd retointercorp
mvn clean install
mvn spring-boot:run
```

# Visit Swagger

- http://main-customer-1573970198442.azurewebsites.net/swagger-ui.html
- http://localhost:8080/swagger-ui.html

Verify the deployment by navigating to your server address in your preferred browser.

```sh
http://localhost:8080/listclientes
```

#### Spring Boot + Java + Azure Cloud

### Deploymet By

 - Antony Velasquez RUiz

License
----

MIT


**Free Software, Hell Yeah!**
