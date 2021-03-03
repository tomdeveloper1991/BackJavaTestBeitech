# BackJavaTestBeitech

Proyecto desarrollado con spring boot, java 8, consta de dos servicios web rest que realizan la creación de órdenes y listan las ordenes creadas entre un rango de fechas y para un cliente en específico. Contiene las siguientes características: 
- Pruebas de Integracion.
- Documentación automatizada con Swagger.

### End Points para consumir los servicios

- http://localhost:8888/beitech/backend/order/createOrder (POST)

Request de ejemplo en caso de que no funcione el enlace de Postman 

{ 
    "creationDate": "20210602", 
    "customerId": 1, 
    "deliveryAddress": "Avenida Siempre viva 123", 
    "products": [ 
        { 
            "productId": 10, 
            "productDescription": "Sin cubiertos ni servilletas", 
            "quantity": 3 
        }, 
        { 
            "productId": 15, 
            "productDescription": "Sin salsas", 
            "quantity": 1 
        }, 
        { 
            "productId": 16, 
            "productDescription": "Sin Azucar", 
            "quantity": 1 
        } 
    ] 
}

- http://localhost:8888/beitech/backend/order/getOrdersByCustomerAndDate/1/20200101/20200431 (GET)

(El primer parámetro es el ID del Customer Las fechas se ponen en formato YYYYMMDD, la primera es la 	fecha inicial la segunda es la fecha final) 



### Enlace para ver la documentación de los servicios rest (Swagger)

- http://localhost:8888/beitech/backend/order/swagger-ui.html#/order-api

### Enlace para importar Request desde postman
- https://www.getpostman.com/collections/3023dc7260824362729a

## Diagrama de clases

![alt text](https://github.com/tomdeveloper1991/BackJavaTestBeitech/blob/d02e391cf0c3c68d15ccdf6f4ed897ed07d0ca6c/ClassDiagram.jpg?raw=true)