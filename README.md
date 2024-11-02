# Gestor de Catálogo de Productos

## Autor
Jorge Sánchez

## Descripción
Este proyecto es un gestor de catálogo de productos que permite realizar la operación de alta de productos. El sistema funciona en local con una interfaz de texto, y los datos se almacenan en un archivo CSV para persistencia.

## Requisitos
- Java 8 o superior
- Make

## Instrucciones de Instalación
1. Clonar el repositorio:
    ```bash
    git clone https://github.com/JoRgEe80/catalogoproductos.git
    cd catalogoproductos
    ```

2. Compilar el código:
    ```bash
    make compile
    ```

3. Generar el archivo JAR:
    ```bash
    make jar
    ```

4. Generar la documentación Javadoc:
    ```bash
    make javadoc
    ```

## Instrucciones de Uso
1. Ejecutar la aplicación:
    ```bash
    java -cp bin aplicación.Principal
    ```

2. Seguir las instrucciones en la terminal:
    - "alta": Añadir un nuevo producto al catálogo.
    - "mostrar": Mostrar todos los productos del catálogo.
    - "salir": Salir de la aplicación.

## Estructura del Proyecto
- **dominio**: Contiene la clase "Producto" y la clase "Catalogo".
- **presentacion**: Contiene la clase "InterfazUsuario".
- **aplicacion**: Contiene la clase "Principal".

## Diagrama UML
    ```markdown
    ## Diagrama UML
    ![Diagrama UML](C:\Users\User\Programación 1\Repositorios\catalogoproductos)
    ```

## Licencia
Este proyecto está bajo la Licencia Apache versión 2.0. Puedes obtener una copia de la licencia en [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

