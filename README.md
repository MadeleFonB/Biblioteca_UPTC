
# Biblioteca UPTC

## Descripción

Aplicación backend para la gestión de una biblioteca universitaria, que permite administrar libros, usuarios y préstamos usando Spring Boot y PostgreSQL.
Tecnologías usadas

Java 17 (o la versión que uses)
Spring Boot
PostgreSQL
Hibernate / JPA
Swagger para documentación API
Maven / Gradle (según tu proyecto)
Configuración y ejecución

Requisitos previos
Tener Java instalado
Tener PostgreSQL (o usar la base de datos en la nube como Supabase)
IDE recomendado: IntelliJ IDEA, VSCode, Eclipse
Variables de configuración
Indicar que deben modificar application.properties con su conexión a la base de datos, ejemplo:

spring.application.name=Biblioteca UPTC
spring.datasource.url=jdbc:postgresql://aws-0-us-east-2.pooler.supabase.com:5432/postgres?user=postgres.ckyooueqdxcfuuvgjugq&password=Gotica982008*
spring.datasource.username=postgres.ckyooueqdxcfuuvgjugq
spring.datasource.password=Gotica982008*


spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.hikari.maximum-pool-size=5


# Swagger
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

# Puerto personalizado (opcional)
server.port=9090



Cómo correr el proyecto
Clonar el repositorio
Importar el proyecto en el IDE
Ejecutar el archivo principal (ej. Application.java)
Acceder a Swagger UI en: http://localhost:9090/swagger-ui.html

## Funcionalidades

CRUD de libros
CRUD de usuarios
Gestión de préstamos
Documentación de API con Swagger
Estructura del proyecto

src/main/java/com/upct/biblioteca/
 ├── controller/      (controladores REST)
 ├── model/           (entidades JPA)
 ├── repository/      (interfaces JPA)
 ├── service/         (lógica de negocio)
 └── config/          (configuraciones como Swagger)
 
## Consideraciones

Se usa spring.jpa.hibernate.ddl-auto=update para manejar la creación y actualización automática de tablas.
Usar con cuidado la base de datos en producción.
Autor

Madeleine Daniela Fonseca Bernal
