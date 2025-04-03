
# Project Title

A brief description of what this project does and who it's for

# 🧾 Backend - Sistema de Control de Stock

Este proyecto es la parte backend de una aplicación para gestionar productos y movimientos de stock. Está construido con **Java y Spring Boot**, y ofrece una API REST para ser consumida por una app móvil desarrollada en **React Native con Expo**.

---

## 📚 Tabla de contenidos

- [Tecnologías](#-tecnologías)
- [Requisitos](#-requisitos)
- [Instalación y ejecución](#-instalación-y-ejecución)
- [Configuración de la base de datos](#-configuración-de-la-base-de-datos)
- [Consola H2](#-consola-h2)
- [Endpoints disponibles](#-endpoints-disponibles)
- [Conexión con frontend móvil](#-conexión-con-frontend-móvil)
- [Notas útiles](#-notas-útiles)
- [Autora](#-autora)

---

## 🚀 Tecnologías

- Java 17
- Spring Boot 3+
- Spring Data JPA
- H2 Database (en memoria)
- Lombok
- Maven

---

## ✅ Requisitos

- JDK 17+
- Maven (`mvn`)
- IDE (IntelliJ, Eclipse, VS Code, etc.)
- Herramienta para probar APIs (Postman, Insomnia, etc.)
- Proyecto frontend React Native (Expo)

---

## 🧰 Instalación y ejecución

## 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPO>
cd stockAppBack
```
## 2. Configurar propiedades de Spring Boot
```bash
server.port=8080
server.address=0.0.0.0
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

## 🗃️ Configuración de la base de datos
El proyecto usa H2 en memoria, por lo tanto se reinicia al cerrar la app.

Podés migrar fácilmente a MySQL o PostgreSQL cambiando las propiedades del datasource.

## 🖥️ Consola H2
Acceso web a la base de datos:

    URL: http://localhost:8080/h2-console

    Driver: org.h2.Driver

    JDBC URL: jdbc:h2:mem:testdb

    Usuario: sa

    Contraseña: (dejar en blanco)


## 🔌 Endpoints disponibles
### 📦 Productos (`/api/productos`)

| Método | Endpoint               | Descripción                   |
|--------|------------------------|-------------------------------|
| GET    | /api/productos         | Listar todos los productos    |
| POST   | /api/productos         | Crear un nuevo producto       |
| GET    | /api/productos/{id}    | Obtener un producto por ID    |
| PUT    | /api/productos/{id}    | Actualizar un producto        |
| DELETE | /api/productos/{id}    | Eliminar un producto          |

## 🔁 Movimientos de Stock (`/api/movimientos`)

| Método | Endpoint                                | Descripción                                 |
|--------|-----------------------------------------|---------------------------------------------|
| POST   | /api/movimientos                        | Registrar ingreso, egreso, reparto          |
| GET    | /api/movimientos/producto/{id}          | Listar movimientos de un producto           |

## 📲 Conexión con frontend móvil (Expo)

#### Para conectar la app móvil con este backend:

1. Asegurate de que el celular y la PC estén en la misma red Wi-Fi.

2. Usá la IP local de tu PC (ejemplo: 192.168.100.36)

3. En el frontend, configurá tu fetch así:

```javascript 
fetch("http://192.168.100.36:8080/api/productos")
```

4. Asegurate de tener CORS habilitado en tus controladores:

```java
@CrossOrigin(origins = "*")
```

## 💡 Notas útiles

Podés probar los endpoints desde Postman o el navegador

Si tu frontend falla con Network request failed, asegurate de que:

El backend escuche en 0.0.0.0

No haya firewall bloqueando el puerto 8080

No uses VPNs activas como Radmin VPN

La app móvil se conecta por IP local, no localhost

## 👩‍💻 Autora

#### Adriana Manresa
###### 📅 Versión inicial: Abril 2025
###### 📌 Proyecto educativo y funcional como MVP para manejo de stock desde backend y frontend móvil.