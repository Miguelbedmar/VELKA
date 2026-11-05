# VELKA
Desarrollado por Miguel Bedmar Diaz de la Serna. 
# 📋 Descripción del proyecto.
Velka es un videojuego  inspirado en celeste  en donde tendras que superar  obstaculos puedes saltar y escalar tiene sistema de colision  que la controla la clase tile 
sistema de cambio de mapa  al llegar a un portal  te dirige al siguiente nivel 
, tiene un sistema de respawn siempre y cuando el jugador no pierda aunque todavia falta por implementar  el menu de fin de juego.


# 🎯 Objetivo.
EL objetivo de esta reapertura de proyecto es  corregir los bugs , implementar funcionalidad como la pantalla de muerte y victoria y  a lo mejor pensar en nuevas tecnologias como javafx 

# 🏗️ Estructura de VELKA

```
VELKA/
├── bin/
└── src/
    ├── controlador/
    │   ├── LoopGame.java
    │   └── TecladoControlador.java
    ├── main/
    │   └── Principal.java
    ├── modelo/
    │   ├── Coleccionable.java
    │   ├── Jugador.java
    │   ├── Map.java
    │   ├── Personaje.java
    │   ├── ReproductoMusica.java
    │   └── Tile.java
    ├── recursos/
    │   ├── MUSICA/
    │   │   └── MusicaMenu.wav
    │   ├── SPRITEMAPA/
    │   │   ├── BLOQUE.png
    │   │   ├── ESTRELLAS.png
    │   │   └── [Otros elementos del mapa...]
    │   └── SPRITESJUGADOR2/
    │       ├── CORRER/
    │       ├── DANIO/
    │       ├── ESCALA/
    │       ├── IDLE/
    │       ├── PORTA/
    │       └── SALTO/
    └── vista/
        ├── JframePrincipal.java
        ├── JLabelControles.java
        ├── JLabelFinJuego.java
        ├── JPanel1Juego.java
        └── JpanelMenu.java

```

# 🎮 Controles 
El juego cuenta con un **sistema de control dual**, permitiendo alternar de forma cómoda entre la distribución clásica **WASD** o las **Flechas direccionales** según tu preferencia de juego:

| Acción | Opción Principal | Opción Alternativa | Función en el Juego |
| :--- | :---: | :---: | :--- |
| **Mover a la izquierda** | `A` | `←` | Desplaza al personaje hacia la izquierda. |
| **Mover a la derecha** | `D` | `→` | Desplaza al personaje hacia la derecha. |
| **Mirar arriba / Escalar** | `W` | `↑` | Permite trepar por muros o mirar hacia arriba. |
| **Agacharse / Descender** | `S` | `↓` | Permite descender de plataformas o agacharse. |
| **Saltar** | `Espacio` | `Espacio` | Realiza un salto (o impulsos desde paredes). |
| **Impulso (Dash)** | `K` | `X` / `Shift` | Desplazamiento rápido en el aire. |
| **Agarrar (Climb)** | `J` | `C` / `Z` | Sujeción en superficies verticales para escalar. |


# 🧑‍💻 Tecnologías
   - Java
   - Librerias swing
   - librerias awg
   - librerias sound
   -  estructura MVC
# 🆔 IDE.
   - Visual Studio Coe


