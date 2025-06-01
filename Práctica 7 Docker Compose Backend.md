# Práctica #7 Automatización del despliegue de una aplicación backend con PostgreSQL y pgAdmin usando Docker Compose

## 1. Título

**Práctica: Creación de un entorno backend con PostgreSQL y pgAdmin mediante Docker Compose**

## 2. Tiempo de duración

La duración estimada para esta práctica fue aproximadamente 2 horas.

## 3. Fundamentos

En esta práctica, se aplicaron conocimientos sobre Docker y Docker Compose para definir y levantar un entorno completo que incluye una base de datos PostgreSQL, su panel de administración pgAdmin y una aplicación backend desarrollada en Java (Spring Boot). Docker Compose permite orquestar múltiples contenedores definiendo sus configuraciones, redes y volúmenes en un archivo YAML (`docker-compose.yml`).

Además, se aplicó la técnica de **multi-stage builds**, una estrategia avanzada de construcción de imágenes Docker que permite separar el proceso de compilación del entorno de ejecución. Esto se traduce en imágenes finales más pequeñas, limpias y seguras, ya que se evita incluir herramientas de compilación innecesarias en el entorno de producción (Docker Inc., 2025). En este caso, se usaron al menos dos etapas: una con Java SDK para compilar la aplicación, y otra con un JRE liviano para ejecutar el artefacto resultante. Esto mejora el rendimiento del contenedor y reduce el uso de recursos en entornos de producción y desarrollo.

## 4. Conocimientos previos

Docker es una plataforma para empaquetar aplicaciones en contenedores que aseguran un entorno de ejecución consistente (Docker Inc., 2025). Docker Compose permite definir y ejecutar aplicaciones multi-contenedor usando un solo archivo YAML, facilitando la gestión de servicios relacionados. PostgreSQL es un sistema gestor de bases de datos relacional robusto y ampliamente utilizado en aplicaciones empresariales (Stonebraker, 2018). pgAdmin es una herramienta gráfica para administrar PostgreSQL, facilitando la gestión visual de las bases de datos (pgAdmin Development Team, 2024).

Además, se investigó la técnica de **multi-stage builds** en Docker, descrita en la documentación oficial, la cual permite optimizar las imágenes dividiendo el proceso en varias etapas. Esta práctica no solo mejora la eficiencia en el tiempo de construcción, sino que también aporta beneficios en seguridad, portabilidad y mantenimiento de los contenedores generados (Docker Inc., 2025).

## 5. Objetivos a alcanzar

- **Crear servicios en Docker Compose para PostgreSQL y pgAdmin, definiendo volúmenes para persistencia y redes para conectividad.**
    
- **Construir un Dockerfile multi-stage para empaquetar la aplicación backend optimizando la imagen.**
    
- **Configurar un servicio en Docker Compose para el backend que se conecte correctamente a la base de datos.**
    
- **Definir las variables de entorno necesarias en un archivo `.env`.**
    
- **Levantar y validar que los contenedores funcionen correctamente y estén conectados.**
    

## 6. Equipo necesario

- Computador con sistema operativo **MacOS 13.7.1** (o equivalente con Docker instalado).
    
- **Docker Desktop** instalado y ejecutándose.
    
- Terminal para ejecutar comandos Docker.
    
- Editor de texto para crear y modificar archivos `docker-compose.yml`, `Dockerfile` y `.env`.
    
- Acceso a Internet para descargar imágenes Docker base.
    

## 7. Material de apoyo

- Documentación oficial de Docker y Docker Compose.
    
- Documentación oficial de PostgreSQL y pgAdmin.
    
- Repositorio base de la aplicación backend: [https://github.com/maguaman2/tendencias-mar22-security.git](https://github.com/maguaman2/tendencias-mar22-security.git).
    
- Tutoriales y ejemplos de multi-stage builds en Docker.
    

## 8. Procedimiento

**Paso 0:** Clonar el repositorio base de la aplicación backend desde GitHub usando el siguiente comando:

`git clone https://github.com/maguaman2/tendencias-mar22-security.git`

**Figura 1.** _"Clonado del repositorio backend"_

<img width="995" alt="f1" src="https://github.com/user-attachments/assets/ea9c7553-a6f8-4968-bba4-616e2502ba04" />

---

**Paso 1:** Crear el archivo `.env` en el directorio raíz del proyecto con las variables de entorno necesarias para los servicios PostgreSQL y pgAdmin. Esto permite separar las credenciales del código fuente.

**Figura 2.** _"Archivo `.env` con las variables de entorno"_


<img width="576" alt="f2" src="https://github.com/user-attachments/assets/5ca793c8-4f1e-41e9-a526-a47bf1d80122" />


---

**Paso 2:** Crear el archivo `docker-compose.yml` con la definición de los servicios necesarios: `postgres`, `pgadmin` y `backend`. Se deben incluir redes personalizadas y volúmenes para la persistencia de datos.

**Figura 3.** _"Configuración de los servicios en `docker-compose.yml`"_

<img width="594" alt="f3-1" src="https://github.com/user-attachments/assets/f322be67-6303-4fd5-bc9b-3b584c1214b9" />  _
<img width="572" alt="f3-2" src="https://github.com/user-attachments/assets/e5cecc4d-5516-40c2-97a3-12ec2dd9392c" />  _
<img width="580" alt="f3-3" src="https://github.com/user-attachments/assets/bf3e08c3-c457-4a2b-a16a-2e5819382e0f" />  -

---

**Paso 3:** Crear un archivo `Dockerfile` dentro del proyecto backend utilizando la técnica de **multi-stage builds**. En la primera etapa se compila la aplicación usando Java SDK, y en la segunda se copia solo el artefacto a una imagen ligera basada en JRE.

**Figura 4.** _"Estructura del Dockerfile con multi-stage builds"_
<img width="590" alt="f4" src="https://github.com/user-attachments/assets/9406fe4a-82a7-4323-9126-191e960b04ea" />

---

**Paso 4:** Ejecutar el comando para construir las imágenes y levantar los contenedores. Este comando fuerza la reconstrucción de las imágenes y ejecuta los servicios en segundo plano.

`docker-compose up --build -d`

**Figura 5.** _"Ejecución de Docker Compose para levantar los servicios"_
<img width="980" alt="f5" src="https://github.com/user-attachments/assets/02681de8-db65-4851-bfa9-df98edd5e2f3" />


---

**Paso 5:** Verificar el estado de los contenedores, donde se muestra el estado, puertos y nombres de los contenedores ejecutándose.

**Figura 6.** _"Verificación de contenedores en ejecución"_

<img width="1091" alt="f6" src="https://github.com/user-attachments/assets/eb7f9b1f-f5b7-42d2-94c8-5edc11725c78" />

---

**Paso 6:** Acceder a **pgAdmin** desde el navegador en `http://localhost:5050` usando las credenciales definidas en el archivo `.env`. Luego, registrar un nuevo servidor y conectarlo a PostgreSQL utilizando el nombre del servicio (`postgres`) como host.

**Figura 7.** _"Acceso al panel pgAdmin y conexión al servicio PostgreSQL"_

<img width="1448" alt="f7" src="https://github.com/user-attachments/assets/54790294-d61c-44b8-9714-df7105f0ee85" />

---

**Paso 7:** Verificar que la aplicación backend funciona correctamente accediendo al puerto correspondiente (por ejemplo `http://localhost:8081`) y probando alguna ruta del API (como `/users` si existe). 

**Figura 8.** _"Verificación del funcionamiento del backend desde el navegador "_

<img width="1333" alt="f8" src="https://github.com/user-attachments/assets/104a5389-3314-48df-a4c1-412431281988" />


## 9. Resultados esperados

Se logró crear y gestionar contenedores Docker para PostgreSQL, pgAdmin y la aplicación backend. El archivo `docker-compose.yml` permitió automatizar la creación, configuración y levantamiento de los contenedores con persistencia y comunicación adecuada a través de redes Docker personalizadas.

La técnica de **multi-stage builds** optimizó la imagen de la aplicación backend, reduciendo el tamaño final de la imagen y acelerando el proceso de construcción. Esta separación clara entre compilación y ejecución resultó especialmente útil para asegurar que el entorno de producción contenga únicamente los archivos necesarios para ejecutar la aplicación, minimizando así potenciales vulnerabilidades y mejorando el rendimiento.

El uso del archivo `.env` facilitó la gestión de variables de entorno sensibles y reutilizables en la configuración de los servicios.

Al acceder al panel de pgAdmin en `http://localhost:5050`, se pudo conectar sin problemas a la base de datos PostgreSQL, visualizando la base `security_db` y sus tablas. La aplicación backend respondió correctamente a las solicitudes, confirmando su conexión exitosa con la base de datos.

Este entorno local con Docker Compose proporciona una solución reproducible y fácil de mantener para el desarrollo y prueba de aplicaciones backend con base de datos, mejorando la automatización y eficiencia en el ciclo de desarrollo.

## 10. Referencias 

Docker Inc. (2025). _Docker: Documentation_. Recuperado de [https://docs.docker.com](https://docs.docker.com)

Docker Inc. (2025). _Use multi-stage builds_. Recuperado de https://docs.docker.com/develop/develop-images/multistage-build/

pgAdmin Development Team. (2024). _pgAdmin Documentation_. Recuperado de [https://www.pgadmin.org/docs/](https://www.pgadmin.org/docs/)

Stonebraker, M. (2018). _PostgreSQL: Advanced open source database_. Addison-Wesley.
