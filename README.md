
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

*(Este apartado está en desarrollo y será completado más adelante.)*

---

Con estos pasos podrás comenzar a probar la versión web de AlarMe sin problemas. ¡Explora las funcionalidades y organiza tu día a día de manera efectiva!

---
