spring-app-tipoCambio
======================
Web service que permite realizar el tipo de cambio y actualizar los valores de los tipos de cambios.
## Tabla de contenidos

- [1. Instalación](#instalacion)
    - [1.1 Construcción](#proceso-construccion)
        - [1.1.1 Pre-requisitos de Construcción](#pre-requisitos-de-construccion)
        - [1.1.2 Pruebas Unitarias](#pruebas-unitarias)
    - [1.2 Despliegue](#proceso-despliegue)
        - [1.2.1 Subir imagen a DockerHub](#Subir-imagen-a-DockerHub)
        - [1.2.2 Descargar y despliegue de imagen remota](#Descargar-imagen-remota)
        - [1.2.3 Pruebas Funcionales](#pruebas-funcionales)
- [2. Uso](#uso)
- [3. Autor](#autor)

## 1. Instalación

Clonar el proyecto desde github:
https://github.com/yanpieer-romero-unmsm/spring-app-tipoCambio.git

Luego deberas moverte a la rama develop:

git checkout develop

### 1.1 Construcción

#### 1.1.1 Pre-requisitos de Construcción


Tener instalados y configurados [Java JDK11](https://www.oracle.com/java/technologies/downloads/#java11) y [Apache Maven](https://maven.apache.org/download.cgi) para poder compilar el proyecto.


$JAVA_HOME = ""

$M2_HOME = ""

Tutorial Instalacion Lombok: https://youtu.be/EDGTS8SwzPA

lombok-1.18.20.jar

luego ejecutar el comando
bash
mvn clean install

#### 1.1.2 Pruebas Unitarias
Los test a los metodos del servicio no aplican.
La prueba unitaria será pegarle al servicio.

### 1.2 Despliegue
El despliegue se hará con [docker](https://docs.docker.com/get-docker/) para eso se procura tenerlo instalado, 
luego aplicar los siguiente comandos:

#### Crear imagen:
docker build -t spring-app-tipocambio .

#### Visualizar las imagenes creadas:
docker images

#### Levantar la aplicación:
docker run --name spring-app-tipocambio -p 8090:8090 spring-app-tipocambio:latest

#### ó en su defecto:
docker run -p 8090:8090 spring-app-tipocambio:latest

#### 1.2.1 Subir imagen a DockerHub

#### Tagear la imagen local a DockerHub:
docker tag spring-app-tipocambio yanpieer/spring-app-tipocambio

#### Pushear la imagen local a DockerHub:
docker push yanpieer/spring-app-tipocambio

#### 1.2.2 Descargar y despliegue de imagen remota

#### Descargar imagen del repositorio remoto dockerhub:
docker pull yanpieer/spring-app-tipocambio

#### Levantar imagen remota dockerhub:
docker run -p 8090:8090 yanpieer/spring-app-tipocambio

#### 1.2.3 Pruebas Funcionales

Tal como en el punto 1.1.2 las pruebas deberan ser ejecuciones directas al servicio en desarrollo
## 2. Uso
La aplicacion de este servicio servira para realizar las operaciones de conversión de tipo de cambio 
de una moneda asi como la actualización del valor del tipo de cambio.

<a name="autores"></a>
## 3. Autor
- ### Yanpieer Romero.
- ### yanpieer.romero@unmsm.edu.pe