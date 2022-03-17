spring-app-tipoCambio
======================
Web service que permite realizar el tipo de cambio y actualizar los valores de los tipos de cambios.
## Tabla de contenidos

- [1. Instalación](#instalacion)
    - [1.1 Construcción](#proceso-construccion)
        - [1.1.1 Pre-requisitos de Construcción](#pre-requisitos-de-construccion)
        - [1.1.2 Pruebas Unitarias](#pruebas-unitarias)
    - [1.2 Despliegue](#proceso-despliegue)
        - [1.2.1 Pruebas Funcionales](#pruebas-funcionales)
- [2. Uso](#uso)
- [3. Autor](#autor)

## 1. Instalacón

Clonar el proyecto desde github:
http://devops.imiclaroapp.com.pe:7000/ClaroVentas/ws-sb-claro-venta-precio.git

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

#### 1.2.1 Pruebas Funcionales

Tal como en el punto 1.1.2 las pruebas deberan ser ejecuciones directas al servicio en desarrollo
## 2. Uso
La aplicacion de este servicio servira para realizar las operaciones de conversión de tipo de cambio 
de una moneda asi como la actualización del valor del tipo de cambio.

<a name="autores"></a>
## 3. Autor
- ### Yanpieer Romero.
- ### yanpieer.romero@unmsm.edu.pe