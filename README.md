# Culebra Real

**Culebra Real** es un juego de la culebra desarrollado en Java utilizando Swing para la interfaz gráfica y hilos para la lógica del juego. Este proyecto fue creado como un proyecto personal durante las vacaciones por Yaider Becerra.

## Descripción

El juego de la culebra es un clásico en el que el jugador controla una culebra que se mueve por la pantalla, comiendo comida para crecer y evitando chocar con las paredes o consigo misma. Este proyecto implementa el juego utilizando:

- **Swing**: Para la creación de la interfaz gráfica.
- **Hilos**: Para manejar la lógica del juego y el movimiento de la culebra de manera concurrente.

## Características

- Interfaz gráfica amigable y sencilla.
- Movimiento suave y continuo de la culebra.
- Incremento de la longitud de la culebra al comer.
- Detección de colisiones con las paredes y la propia culebra.

## Instalación

Para ejecutar este proyecto, necesitas tener instalado Java y Maven. Sigue los siguientes pasos para clonar y ejecutar el proyecto:

1. Clona el repositorio:
    ```sh
    git clone <URL_DEL_REPOSITORIO>
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd CulebraReal
    ```
3. Compila y ejecuta el proyecto usando Maven:
    ```sh
    mvn clean install
    mvn exec:java -Dexec.mainClass="controller.Controller"
    ```

## Autor

Este proyecto fue desarrollado por **Yaider Becerra** durante las vacaciones como un proyecto personal para mejorar sus habilidades en Java y programación concurrente.

¡Disfruta jugando a Culebra Real!