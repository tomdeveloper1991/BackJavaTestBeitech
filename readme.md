# BackJavaTestBeitech

Proyecto desarrollado con spring boot, contiene servicios web rest que realizan la creación de ordenes y listan las ordenes creadas entre un rango de fechas y para un cliente en especifico.
Contiene las siguientes caracteristicas:
- Pruebas de Integracion.
- Documentación automatizada con Swagger.

### End Points para consumir los servicios

- http://localhost:8888/beitech/backend/order/createOrder
- http://localhost:8888/beitech/backend/order/getOrdersByCustomerAndDate/99999/20200101/20200431

### Enlace para ver la documentación de los servicios rest (Swagger)

- http://localhost:8888/beitech/backend/order/swagger-ui.html#/order-api

### Enlace para importar Request desde postman
- https://www.getpostman.com/collections/3023dc7260824362729a

## Diagrama de clases

![alt text](https://github.com/tomdeveloper1991/BackJavaTestBeitech/blob/d02e391cf0c3c68d15ccdf6f4ed897ed07d0ca6c/ClassDiagram.jpg?raw=true)