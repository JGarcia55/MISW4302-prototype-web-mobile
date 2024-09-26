
# AlarMe - Aplicación de Alarmas

AlarMe es una aplicación de alarmas diseñada para ayudar a las personas de la tercera edad a gestionar sus alarmas para organizar sus actividades cotidianas. Existen dos versiones de la aplicación:

1. **Web** (directorio `web`)
2. **Mobile** (directorio `app`)

## Directorio Web

El directorio `web` contiene los archivos necesarios para ejecutar la aplicación en un entorno de navegador. Dentro del directorio encontrarás las siguientes carpetas y archivos principales:

### Estructura del Directorio

```
/web
│
├── /assets
│   ├── /css   # Archivos CSS 
│       ├── style.css   # Archivo principal css
│   ├── /js   # Archivos JS
│       ├── main.js   # Archivo principal js
│
├── index.html       # Login de la aplicación
├── home.html      # Página de inicio de la aplicación usando calendario
├── alarmas.html    # listado de alarmas + creación de alarmas
├── crear-alarma.html    # Formulario para la creación de alarmas
└── alarmas2.html       # Representación de agregar alarma en el listado
```

### Requisitos para Probar la Aplicación

Para probar la aplicación web, puedes hacerlo de dos maneras:

1. **Usando la extensión "Live Server" en Visual Studio Code**:
    - Abre el directorio `web` en Visual Studio Code.
    - Instala la extensión "Live Server" si aún no la tienes.
    - Haz clic derecho sobre `index.html` y selecciona "Open with Live Server".
    - Esto lanzará la aplicación en tu navegador y podrás interactuar con todas las páginas.

2. **Abrir directamente `index.html` en el navegador**:
    - Navega hasta el directorio `web`.
    - Haz doble clic en el archivo `index.html`.
    - Esto abrirá la aplicación en tu navegador por defecto.
    - Nota: Aunque esta opción debería funcionar sin problemas, es posible que algunas funcionalidades no sean óptimas en ciertos navegadores.

### Navegación en la Aplicación Web

La aplicación está dividida en varias páginas HTML conectadas entre sí mediante enlaces. Los usuarios pueden acceder a las siguientes secciones:

- **Página login (`index.html`)**: Aquí es donde los usuarios pueden realizar el login a la aplicación.
- **Página principal (`home.html`)**: Permite ver las alarmas listadas en un calendario.
- **Página de listado de alarmas (`alarmas.html`)**: Permite ver un listado de las alarmas creadas, además se puede ver una pantalla extra de una prueba de la notificación que puede mostrar la alarma.
- **Página de creación de alarma (`crear-alarma.html`)**: Contiene el formulario completo de la creación de alarma, además tiene una pantalla modal la cual podemos ver una interacción para agregar contactos para compartir la alarma.
- **Página de representación de alarma nueva (`alarmas2.html`)**: Permite ver una representación de que pasa cuando se agregar una alarma nueva (aparece una segunda alarma en la parte izquierda), de igual manera tiene las mismas funcionalidades de la página `alarmas.html`.

---

## Aplicación Mobile

El directorio `mobile` contiene los archivos necesarios para ejecutar la aplicación en un entorno de android studio. Dentro del directorio encontrarás las siguientes carpetas y archivos principales:

```
/mobile
│
├── /app
│   ├── /src  
│       ├── main
|            ├── java
|                ├── com.alarme.alarme
|                    ├── theme # Define la parte de UI, como colores, tipos, y temas
|                    ├── view
|                        ├── cellphone_register
|                            ├── CellphoneRegister.kt # Toda la UI de la pantalla de registro
|                            ├── CellphoneRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── contact_list
|                            ├── ContactListRegister.kt # Toda la UI de la pantalla de lista de contactos de respaldo
|                            ├── ContactListRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── contactregister
|                            ├── ContactRegister.kt # Toda la UI de la pantalla de registro de contactos de respaldo
|                            ├── ContactRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── core
|                            ├── BottomBar.kt # UI del Bottom bar que es cross a la app
|                            ├── SecondaryTopBar # UI de la top bar del registro de usuario y login
|                            ├── TopBar.kt # Toda la UI del TopBar principal
|                        ├── home
|                            ├── Alarm.kt # Data de alarma
|                            ├── AlarmHome # UI de lista de alarmas
|                            ├── AlarmHomeActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── maincontactregister
|                            ├── MainContactRegister  # UI de la pantalla para importar usuarios
|                            ├── MainContactRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── otp_code_register
|                            ├── OtpCodeRegister  # UI de la pantalla para validar código de teléfono
|                            ├── OtpCodeRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── user_register
|                            ├── OtpCodeRegister  # UI de la pantalla para registrar usuario
|                            ├── OtpCodeRegisterActivity # Lógica para poder manejar los estados de la pantalla
|                        ├── util # Funciones de utilidad
|            ├── res # recursos como imagenes, textos, y dimensiones
|            ├── AndroidManifest.xml # tiene definidas todas las pantallas
|            ├── ic_launcher-playstore.png # ícono de AlarMe para el shortcut de app
|            ├── ...
│
```
### Requisitos para Probar la Aplicación
1. Descargar el apk:
En la base del directorio del proyecto encontrarás un archivo app-debug.apk, debes descargarlo e instalarlo en tu celular/emulador (https://www.youtube.com/watch?v=ePQ79Ij0-Xc), y ahí ya lo puedes ejecutar como cualquier aplicación
2. En caso de no funcionar, activar opciones de desarrollador (se debe buscar en Google porque en cada celular es diferente)
---
### Requisitos para Probar la Aplicación en Android
1. Abrir el proyecto en la carpeta mobile en AS
2. Dar en sincronizar gradle
3. Crear emulador
4. Ejecutar (botón de play)

Con estos pasos podrás comenzar a probar la versión web de AlarMe sin problemas. ¡Explora las funcionalidades y organiza tu día a día de manera efectiva!

---
