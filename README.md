# FilmAppCompose

Ejemplo de una sencilla aplicación de gestión de películas usando Compose Multiplatform.

[![Kotlin](https://img.shields.io/badge/Code-Kotlin-blueviolet)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Code-Compose-blue)](https://www.jetbrains.com/es-es/lp/compose-mpp/)
![GitHub](https://img.shields.io/github/last-commit/joseluisgs/FilmAppCompose)
[![LICENSE](https://img.shields.io/badge/Lisence-CC-%23e64545)](https://joseluisgs.github.io/docs/license/)
![imagen](https://repository-images.githubusercontent.com/293498508/1624a845-8807-4b9b-895a-fdbc9ce70678)

## Acerca de

Este es un ejemplo de una aplicación gestión de películas con Kotlin Multiplatform y Compose. Es un ejemplo muy
simple pero que muestra como podemos usar Compose en una aplicación multiplataforma. En este caso, la aplicación se
compone de un módulo Desktop y otro Android, pero podríamos añadir más módulos para iOS, Web, etc.

Este ejemplo esta basado en el tutorial:
de [JetPack de programación de Android](https://github.com/joseluisgs/Kotlin-Jetpack-Android).

Entre las cosas que podemos ver en este ejemplo están:

- App de Android y Desktop con código compartido con Kotlin Multiplatform y Compose
- Material Design 3 con Compose con temas y colores
- Uso de Voyager para la navegación y gestión de rutas y estados de pantallas
- Estados reactivos, UDF (Unidirectional Data Flow) y MVVM (Model View ViewModel)
- Uso de Coroutines para el manejo de asincronía
- Uso de Koin para la inyección de dependencias
- Uso de Ktor para la comunicación con la API
- Uso de Kotlinx Serialization para la serialización de datos
- Uso de Libres para manejo de recursos multiplataforma
- Uso de Kamel para la carga de imágenes asíncronas
- SQLDelight para la persistencia de datos mutiplataforma
- Gestión de estados mediante Railway Oriented Programming (ROP y LCE (Loading, Content, Error))
- Iconos de Material Icons y Feather Icons

### API de películas

Una forma sencilla de obtener datos de películas es usar tu propio repositorio en GitHub.

Verás que todo está en el directorio [api](https://github.com/joseluisgs/FilmAppCompose/tree/main/api), donde
descargamos como raw el json de datos y las imágenes.

### Imagenes

#### Desktop
![imagen](./images/01.png)
![imagen](./images/02.png)
![imagen](./images/03.png)
![imagen](./images/04.png)

#### Android
![imagen](./images/05.png)
![imagen](./images/06.png)
![imagen](./images/07.png)
![imagen](./images/08.png)

#### Desktop y Android
![imagen](./images/09.png)
![imagen](./images/10.png)
![imagen](./images/11.png)
![imagen](./images/12.png)
![imagen](./images/13.png)



### Before running!

Check your system with KDoctor

- install JDK 8 on your machine
- add local.properties file to the project root and set a path to Android SDK there
- run ./gradlew podInstall in the project root

### Android

To run the application on android device/emulator:

- open project in Android Studio and run imported android run configuration

To build the application bundle:

- run `./gradlew :composeApp:assembleDebug`
- find `.apk` file in `composeApp/build/outputs/apk/debug/composeApp-debug.apk`

### Desktop

Run the desktop application: `./gradlew :composeApp:run`

## Autor

Codificado con :sparkling_heart: por [José Luis González Sánchez](https://twitter.com/JoseLuisGS_)

[![Twitter](https://img.shields.io/twitter/follow/JoseLuisGS_?style=social)](https://twitter.com/JoseLuisGS_)
[![GitHub](https://img.shields.io/github/followers/joseluisgs?style=social)](https://github.com/joseluisgs)
[![GitHub](https://img.shields.io/github/stars/joseluisgs?style=social)](https://github.com/joseluisgs)

### Contacto

<p>
  Cualquier cosa que necesites házmelo saber por si puedo ayudarte 💬.
</p>
<p>
 <a href="https://joseluisgs.dev" target="_blank">
        <img src="https://joseluisgs.github.io/img/favicon.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://github.com/joseluisgs" target="_blank">
        <img src="https://distreau.com/github.svg" 
    height="30">
    </a> &nbsp;&nbsp;
        <a href="https://twitter.com/JoseLuisGS_" target="_blank">
        <img src="https://i.imgur.com/U4Uiaef.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://www.linkedin.com/in/joseluisgonsan" target="_blank">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" 
    height="30">
    </a>  &nbsp;&nbsp;
    <a href="https://discordapp.com/users/joseluisgs#3560" target="_blank">
        <img src="https://logodownload.org/wp-content/uploads/2017/11/discord-logo-4-1.png" 
    height="30">
    </a> &nbsp;&nbsp;
    <a href="https://g.dev/joseluisgs" target="_blank">
        <img loading="lazy" src="https://googlediscovery.com/wp-content/uploads/google-developers.png" 
    height="30">
    </a>  &nbsp;&nbsp;
<a href="https://www.youtube.com/@joseluisgs" target="_blank">
        <img loading="lazy" src="https://upload.wikimedia.org/wikipedia/commons/e/ef/Youtube_logo.png" 
    height="30">
    </a>  
</p>

### ¿Un café?

<p><a href="https://www.buymeacoffee.com/joseluisgs"> <img align="left" src="https://cdn.buymeacoffee.com/buttons/v2/default-blue.png" height="50" alt="joseluisgs" /></a></p><br><br><br>

## Licencia de uso

Este repositorio y todo su contenido está licenciado bajo licencia **Creative Commons**, si desea saber más, vea
la [LICENSE](https://joseluisgs.dev/docs/license/). Por favor si compartes, usas o modificas este proyecto cita a su
autor, y usa las mismas condiciones para su uso docente, formativo o educativo y no comercial.

<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Licencia de Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">
JoseLuisGS</span>
by <a xmlns:cc="http://creativecommons.org/ns#" href="https://joseluisgs.dev/" property="cc:attributionName" rel="cc:attributionURL">
José Luis González Sánchez</a> is licensed under
a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons
Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional License</a>.<br />Creado a partir de la obra
en <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/joseluisgs" rel="dct:source">https://github.com/joseluisgs</a>.