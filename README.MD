 # TECNOLOGÍAS UTILIZADAS
 ## BACKEND:
 Spring boot v: 3.4.11
 java: openJDK 17

 ## SEGURIDAD
 Spring Security + JWT

 ## DATABASE
Postgres 15 (Dockerizada)


 ## FRONTEND:
 Angular v17

### DEPLOYMENT:
---------------------------

-  *En la raíz del repositorio iniciar la base de datos con el comando:*

 ```    docker compose up -d    ```

 - (Automáticamente generará tablas, información inicial, stored Procedures)

 - Iniciar el backend desde la ruta /backend/loginsys

 - Iniciar el frontEnd (Angular) desde la ruta /frontEnd con el comand:
``` ng serve ```
