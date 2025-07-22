# 📚 LiterAlura

**LiterAlura** es una aplicación de consola desarrollada en Java que consume datos de la API pública de [Gutendex](https://gutendex.com/), mostrando una lista de libros populares. Es parte del desafío Backend de Oracle Next Education y Alura Latam.

## 🚀 Características

- 🔗 Conexión a la API de libros del Proyecto Gutenberg  
- 📄 Conversión automática de datos JSON a objetos Java  
- 📚 Visualización de libros por título, autor, idioma y descargas  
- 📊 Ordenamiento por distintos criterios  
- 💻 Interfaz de usuario por consola  

## 🛠️ Tecnologías utilizadas

- Java 17+  
- Maven  
- Gson (Google)  
- HTTP Client (`java.net.http`)  
- Proyecto estructurado en arquitectura limpia (modelo, servicio, vista)  

## 📁 Estructura del proyecto
literatura/
│
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── alura/
│ └── literatura/
│ ├── Principal.java
│ ├── DatosLibro.java
│ ├── GutendexCliente.java
│ ├── ConvierteDatos.java
│ └── Libro.java
│
├── pom.xml
└── README.md


## ⚙️ Requisitos

- JDK 17 o superior  
- Maven instalado (o usar el wrapper `mvnw`)  

## ▶️ Cómo ejecutar

1. Clona o descarga este repositorio: git clone https://github.com/tu-usuario/literatura.git
cd literatura

markdown
Copiar
Editar


2. Ejecuta el proyecto desde consola con Maven:

### En Linux/MacOS:
./mvnw compile exec:java -Dexec.mainClass="com.alura.literatura.Principal"

### En Windows:
mvnw.cmd compile exec:java -Dexec.mainClass="com.alura.literatura.Principal"


## 📌 Notas adicionales

- Este proyecto puede ser extendido para guardar libros favoritos, añadir persistencia con bases de datos o implementar una interfaz gráfica.  
- Los datos son obtenidos de la API pública del Proyecto Gutenberg y pertenecen al dominio público.  

---

### 🧠 Créditos

Desarrollado por Camilo Giraldo como parte del programa **Oracle Next Education + Alura Latam** 💻📚



