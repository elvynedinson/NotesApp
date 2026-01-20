# NotesApp 📝

Aplicación nativa para Android desarrollada con **Kotlin** y **Jetpack Compose**, cuyo objetivo es gestionar notas de forma local aplicando buenas prácticas de arquitectura y manejo de estado.

---

## ✨ Funcionalidades

- Crear notas
- Listar notas almacenadas localmente
- Editar notas existentes
- Eliminar notas con confirmación
- Persistencia de datos usando Room

---

## 🏗️ Arquitectura

El proyecto sigue el patrón **MVVM (Model - View - ViewModel)**:

- **UI (Jetpack Compose)**  
  Renderiza el estado y emite eventos de usuario.

- **ViewModel**  
  Gestiona la lógica de negocio y expone el estado usando Flow/StateFlow.

- **Repository**  
  Abstrae el acceso a datos y comunica la app con la base de datos local.

- **Room**  
  Maneja la persistencia local de las notas.

---

## 🛠️ Tecnologías utilizadas

- Kotlin
- Jetpack Compose
- ViewModel
- Coroutines
- Flow / StateFlow (usando `stateIn`)
- Room
- MVVM Architecture

---

## 📚 Aprendizajes

- Manejo de estado en Jetpack Compose
- Separación de responsabilidades siguiendo MVVM
- Integración de Room con Coroutines y Flow
- Uso de ViewModel como fuente de estado para la UI
- Implementación de un CRUD completo

---

## 🚧 Estado del proyecto

Proyecto finalizado con fines educativos y de aprendizaje.
