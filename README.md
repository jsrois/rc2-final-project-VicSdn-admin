App para el frontend creado con Astro y TypeScript para la Cangas Cup.


### Cómo lanzar el proyecto 

Necesitamos una base de datos MySQL. Puedes usar docker para lanzarla, haciendo:

```
docker run --name mysql-cup -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=cup -p 3306:3306 -d mysql:latest
```

```
mvn spring-boot:run
```