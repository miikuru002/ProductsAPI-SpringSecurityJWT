# Products API
## Descripción
Este proyecto es una API REST que permite realizar operaciones CRUD sobre una base de datos de productos utilizando el Spring Security para la autenticación y autorización de usuarios.

## Requisitos
Para poder ejecutar el proyecto es necesario tener instalado:
- Java 17
- IntelliJ IDEA
- MySQL

## Dependencias
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL Driver
- JJWT
- Model Mapper
- SpringDoc
- Spring Validation

## Deficiones
- **Bean**: Es un objeto que es instanciado, ensamblado y administrado por un contenedor de inversión de control (IoC) como Spring. Estos beans son creados con el fin de encapsular muchas instancias de objetos en un solo objeto que pueda ser administrado por el contenedor de IoC.
- **JWT**: JSON Web Token es un estándar abierto basado en JSON para la creación de tokens de acceso que permiten la autenticar a un usuario y dar privilegios.

## Flujo de la autenticación y autorización
### Inicio de sesión
1. El usuario envía sus credenciales al servidor (inicio de sesión)
2. El servidor valida las credenciales (Spring Security)
3. El servidor crea un JWT con los datos relevantes del usuario (ejm. roles) y lo envía al cliente (clase `JwtTokenProvider`)
4. El cliente almacena el JWT y lo envía en cada petición al servidor.

### Autorización (para cada petición y rutas protegidas)
1. El usuario envía el JWT en la cabecera de la petición (header Authorization).
2. El servidor valida que el JWT sea válido, autentica al usuario y autoriza la petición. (clase `JwtTokenProvider`, `TokenAuthenticationFilter`)
3. El servidor responde con los datos solicitados.
4. Se valida que el usuario tenga los permisos necesarios para acceder a los datos solicitados. (roles)
5. El cliente muestra los datos.
