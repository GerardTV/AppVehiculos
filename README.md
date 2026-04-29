# 🚗 AppVehiculos - Proyecto de Programación Orientada a Objetos

## 📚 Descripción

**AppVehiculos** es un proyecto educativo diseñado para aprender los fundamentos de la **Programación Orientada a Objetos (POO)** a través de la construcción progresiva de una aplicación de gestión de vehículos.

El objetivo principal no es solo el resultado final, sino **entender el proceso de diseño y evolución del código**, siguiendo una serie de commits donde se van introduciendo conceptos clave paso a paso.

---

## 🎯 Objetivos de aprendizaje

Este proyecto está pensado para trabajar:

* Clases y objetos
* Atributos y métodos
* Encapsulación
* Herencia
* Polimorfismo
* Abstracción
* Buenas prácticas de diseño

---

## 🧠 Metodología

El proyecto está construido de forma incremental. Se recomienda:

👉 **Seguir los commits en orden**, ya que en ellos se explica:

1. Diseño inicial del problema
2. Creación de primeras clases
3. Evolución del modelo
4. Refactorización del código
5. Aplicación de conceptos avanzados de POO

💡 La idea es que el alumno vea **cómo crece un proyecto real**, no solo el resultado final.

---

## 🏗️ Estructura del proyecto

El sistema modela un conjunto de vehículos mediante clases.

Ejemplo conceptual:

```
Vehiculo
 ├── Coche
 ├── Moto
 └── Camion
```

Cada clase representa:

* **Vehiculo (clase base)**
  Contiene atributos comunes como:

  * marca
  * modelo
  * velocidad

* **Clases hijas (herencia)**
  Especializan el comportamiento de acelerar

  * Coche 
  * Moto 
  * Bicicleta 

---

## 🔑 Conceptos de POO aplicados

### 1. Encapsulación

Se protegen los atributos usando getters/setters.

### 2. Herencia

Las clases hijas reutilizan código de la clase base.

### 3. Polimorfismo

Métodos que se comportan de forma distinta según el tipo de vehículo.

### 4. Abstracción

Se modela la realidad simplificando los elementos clave.

---


## 🧱 Estructuras de datos utilizadas

- `Set` para evitar duplicados.
- `TreeSet` para mantener ordenación y coherencia en los datos.
- Identificador único (`id`) para distinguir correctamente cada vehículo.

---

## 🏗️ Patrones de diseño

En la aplicación se han aplicado distintos patrones de diseño para mejorar la estructura y mantenibilidad del código:

### 📦 DAO (Data Access Object)
- Separación de la lógica de acceso a datos.
- Encapsula las operaciones de persistencia (ficheros y base de datos).
- Permite desacoplar la lógica de negocio del almacenamiento.

### 🔁 Singleton
- Garantiza una única instancia de los gestores principales (por ejemplo, acceso a base de datos o repositorios).
- Control centralizado de recursos compartidos.

### 🏭 Factory
- Encargado de la creación de objetos relacionados con vehículos o persistencia.
- Centraliza la instanciación de clases para mejorar flexibilidad y escalabilidad.

---

## 💾 Persistencia de datos

La aplicación soporta diferentes formas de persistencia:

### 📄 Ficheros CSV
- Lectura y escritura de datos en formato CSV.
- Permite guardar y recuperar vehículos de forma sencilla.

### 🗄️ Base de datos (JDBC)
- Conexión a base de datos relacional mediante JDBC.
- Creación y gestión de la tabla `Vehiculo`.
- Corrección de problemas de conexión durante el desarrollo.

---

## ☕ Programación funcional (Streams)

Se ha incorporado el uso de **Streams de Java** para el tratamiento de colecciones:

- Filtrado de vehículos con `filter`.
- Sustitución de bucles tradicionales por un enfoque más declarativo.
- Mejora de legibilidad y mantenimiento del código.


## ▶️ Ejecución del proyecto

1. Clonar el repositorio:

```bash
git clone https://github.com/GerardTV/AppVehiculos.git
```

2. Abrir el proyecto en tu IDE (IntelliJ, Eclipse, VSCode...)

3. Ejecutar la clase principal

---

## 🧪 Ejemplo de uso

```java
Vehiculo coche = new Coche("Toyota", "Corolla", 4);
Vehiculo moto = new Moto("Yamaha", "R1", 1000);

coche.acelerar();
moto.acelerar();
```

---

## 📌 Recomendación

No te limites a ejecutar el código.

👉 **Explora los commits y entiende por qué se hicieron los cambios.**

Ahí es donde está el verdadero aprendizaje.

---

## 📄 Licencia

Uso educativo.

---

