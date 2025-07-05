# Juego de Memory en Java – Estructuras de Datos

Este proyecto es una implementación del clásico juego **Memory**, desarrollado como parte de la asignatura **Estructura de Datos** (primer año). Se centra en el uso de estructuras de datos, diseñadas e implementadas desde cero en Java.



## ¿Qué es Memory?

**Memory** es un juego en el que los jugadores deben encontrar parejas de cartas ocultas en una cuadrícula. En cada turno, un jugador voltea dos cartas; si coinciden, se retiran del tablero. Si no, se vuelven a ocultar. El juego continúa hasta que se encuentren todas las parejas.


## Estructura del proyecto

### `Carta.java`
- Atributos: `nombre`, `pareja`, `revelada`.
- Incluye método `equals()` para comparar cartas.

### `Jugador.java`
- Atributos: `nombre` y `cartasGanadas`.
- `cartasGanadas` está implementado mediante una **Lista propia**.

### `Baraja.java`
- Estructura que representa el conjunto de cartas únicas disponibles.
- Utiliza un **TAD de conjunto propio**.
- Métodos clave:
  - `inicializarBaraja()`: genera cartas con letras A-Z y números 0-9.
  - Métodos para añadir y extraer cartas.

### `Tablero.java`
- Atributos: `columnas`, `filas`, `tablero` (una matriz de cartas).
- Métodos principales:
  - `inicializarTablero()`
  - `revelaCarta()`
  - `mostrarTableroRevelado()`
  - `todoRevelado()`

### `Main.java`
- Controla el flujo del juego, turnos de los jugadores y condiciones de victoria.


## Estructuras de datos propias implementadas

- **ArrayList**: utilizada para almacenar las cartas ganadas por cada jugador.
- **Conjunto (Set)**: usado para gestionar la baraja inicial de cartas únicas. Implementado utilizando un `Array` y una variable `cardinal`.
- **No se utilizaron estructuras estándar** como `ArrayList`, `HashSet`, etc.


## Tecnologías utilizadas

- **Lenguaje:** Java
- **IDE:** NetBeans
- **Paradigma:** Programación orientada a objetos


## Cómo ejecutar el proyecto

1. Clona el repositorio
2. Abre el proyecto desde tu IDE 
3. Ejecuta la clase `Main.java`
