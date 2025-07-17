# 🎓 Student Management System (JavaFX GUI)

The **Student Management System** is a beginner-friendly JavaFX desktop application designed to help users add, view, update, and delete student records. Built using **JavaFX**, this GUI application is a step above traditional CLI apps — introducing users to the world of responsive interfaces, layout design, and event-driven programming in Java.

---

## 💻 Project Overview

This project provides an intuitive and vibrant interface to manage basic student information, such as:

* Student Name
* Roll Number
* Email Address

With clearly labeled fields, styled buttons, and real-time updates to the student list, this app offers a smooth user experience suitable for **desktop platforms**.

---

## ✨ Key Features

✅ **Modern JavaFX GUI Interface**
A visually appealing, structured layout using VBox, HBox, and dynamic form elements. Buttons are styled with bright colors and responsive actions.

✅ **Live CRUD Operations**
Users can easily **add**, **update**, or **delete** student entries, and see real-time updates in a scrollable ListView.

✅ **Efficient List Management**
Leverages JavaFX’s `ObservableList` and `ListView` to dynamically render and manage student entries.

✅ **Interactive Selection and Auto-fill**
When a student is selected from the list, their details automatically populate the form for easy editing.

✅ **Custom Fonts and Colors**
Styled using inline CSS with Bookman Old Style bold fonts and an aesthetically pleasing color palette to enhance user engagement.

---

## 🧠 Educational Objectives

This project is ideal for students or beginners learning JavaFX and GUI design. By working through it, you'll learn:

* 📌 How to create a **JavaFX application** from scratch
* 📌 How to use **layout containers** like `VBox`, `HBox`, and `BorderPane`
* 📌 Real-time **event handling** using lambda functions
* 📌 Binding data with `ObservableList` and `ListView`
* 📌 Designing clean and colorful UI with inline **CSS styles**
* 📌 Organizing code in a modular, maintainable structure

---

## 🌟 Prerequisites

To compile and run this project, ensure the following are installed:

* **Java JDK 17+** (Java 22 tested and recommended)
* **JavaFX SDK 24.0.1** (Ensure correct path configuration)

> ✅ You can download JavaFX SDK here:
> [https://gluonhq.com/products/javafx/](https://gluonhq.com/products/javafx/)

---

## 🚀 How to Compile and Run

Open your terminal/command prompt and navigate to the project folder.

### 🔧 Compilation

```bash
javac --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls StudentGUI.java
```

Replace `"path-to-javafx-sdk/lib"` with the correct path to your JavaFX `lib` directory.

### ▶️ Execution

```bash
java --module-path "path-to-javafx-sdk/lib" --add-modules javafx.controls StudentGUI
```

If needed (e.g., on Windows 10/11), you may also include:

```bash
--add-opens javafx.graphics/com.sun.javafx.tk.quantum=ALL-UNNAMED
--add-exports javafx.graphics/com.sun.glass.ui=ALL-UNNAMED
```

---

## 🙌 Acknowledgments

This project is part of my **Java Development Internship** at ShadowFox. It helped reinforce the foundations of JavaFX GUI programming with a focus on real-world usability and beginner-friendly design.

---

## 💻Images

<img width="744" height="933" alt="image" src="https://github.com/user-attachments/assets/73ab8287-4af5-4acc-a5ca-12e9cd70e497" />

---
