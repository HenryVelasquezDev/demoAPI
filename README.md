# BASE PARA API CON SPRING BOOT

## DESCRIPCIÓN DEL PROYECTO

Proyecto base para la generación de API a traves de spring boot, el proyecto se encuentra configurado para hacer una conexión
con la base de datos de Oracle Express Edition de forma local por lo que se debe instalar la misma en el ambiente de desarrollo y
generar la estructura de tabla correspondiente para la clase UsuarioModel.

La configuración para la conexión a BD se encuentra en el archivo de recursos "\demo\src\main\resources\application.properties"

## INICIAR EL APLICATIVO

1.  Descargar el proyecto de forma local
2.  Abrir una ventana cmd y ubicarse dentro de la carpeta del proyecto
3.  Ejecutar la sentencia
            
        mvnw.cmd spring-boot:run

## RUTAS API

1.  Consultar todos los usuarios
        
        GET http://localhost:8081/usuario/

2.  Crear usuario

        POST http://localhost:8081/usuario/
        Ejemplo cuerpo solicitud: 
            {
                "nombre": "Vegeta",
                "apellido": "Prueba",
                "prioridad": 2
            }

3.  Actualizar usuario ( se envia el id del usuario )

        POST http://localhost:8081/usuario/
        Ejemplo cuerpo solicitud: 
            {
                "id": 10,
                "nombre": "Vegeta",
                "apellido": "Prueba",
                "prioridad": 2
            }

4.  Consultar usuario por Id

        GET http://localhost:8081/usuario/{id}
        
        Ejemplo http://localhost:8081/usuario/4 

5.  Eliminar usuario por Id

        DELETE http://localhost:8081/usuario/{id}

        Ejemplo http://localhost:8081/usuario/4 

6.  buscar usuarios por nombre

        GET http://localhost:8081/usuario/query/nombre/{nombre}

        Ejemplo http://localhost:8081/usuario/query/nombre/Vegeta

7.  buscar usuarios por prioridad

        GET http://localhost:8081/usuario/query/prioridad/{prioridad}

        Ejemplo http://localhost:8081/usuario/query/prioridad/2

7.  buscar usuarios por nombre o apellido, ambos parametros deben enviarse siempre

        GET http://localhost:8081/usuario/find?nombre={nombre}&apellido={apellido}

        Ejemplo: 
            - http://localhost:8081/usuario/find?nombre=Goku&apellido=Prueba
            - http://localhost:8081/usuario/find?nombre=&apellido=Prueba
            - http://localhost:8081/usuario/find?nombre=Goku&apellido=



