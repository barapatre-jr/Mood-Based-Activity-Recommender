# Mood-Based Activity Recommender

![Java](https://img.shields.io/badge/Java-11%2B-orange)
![Java Swing](https://img.shields.io/badge/GUI-Java%20Swing-brightgreen)
![OOP](https://img.shields.io/badge/Concept-Object%20Oriented%20Programming-blue)
![Database](https://img.shields.io/badge/Database-MySQL-lightblue)

## 📌 About the Project

**Mood-Based Activity Recommender** is a Java desktop application that recommends different activities, songs, books, and exercises based on the user's current mood.

The idea behind this project is simple: people have different moods during the day, and the type of activity that suits them can also be different. Instead of showing the same suggestions to everyone, this application first asks the user to select their current mood and then provides recommendations related to that mood.

For example, if a user selects **Stressed**, the application can suggest relaxing activities, calm music, reading, breathing exercises, or light physical activities. If the user selects **Energetic**, the application can provide more active and productive suggestions.

The project is developed using **Java and Java Swing** and is mainly created to demonstrate practical implementation of **Object-Oriented Programming (OOP)** concepts along with GUI development.

---

# 📑 Table of Contents

1. [Project Objectives](#1-project-objectives)
2. [Main Features](#2-main-features)
3. [How the Application Works](#3-how-the-application-works)
4. [Moods Supported](#4-moods-supported)
5. [Technologies Used](#5-technologies-used)
6. [OOP Concepts Used](#6-oop-concepts-used)
7. [Project Structure](#7-project-structure)
8. [System Requirements](#8-system-requirements)
9. [Installation and Setup](#9-installation-and-setup)
10. [MySQL Database Setup](#10-mysql-database-setup)
11. [Recommendation Logic](#11-recommendation-logic)
12. [Application Architecture](#12-application-architecture)
13. [Four Main Modules](#13-four-main-modules)
14. [Advantages](#14-advantages)
15. [Limitations](#15-limitations)
16. [Future Scope](#16-future-scope)
17. [Example User Flow](#17-example-user-flow)
18. [Conclusion](#18-conclusion)
19. [Author](#19-author)

---

# 1. Project Objectives

The main objectives of this project are:

* To develop a simple application for mood-based recommendations.
* To understand how Java can be used to create a desktop GUI application.
* To apply Object-Oriented Programming concepts in a practical project.
* To organize recommendations according to different moods.
* To provide an easy-to-use graphical interface.
* To display different recommendations based on the user's mood.
* To understand event handling in Java Swing.
* To create a project that can be extended with database and AI-based features in the future.

---

# 2. Main Features

## 😊 Mood Assessment

The application allows users to select their current mood from a list of available moods.

The available moods include:

* 😊 Happy
* 😢 Sad
* 😫 Stressed
* 😐 Bored
* 😠 Angry
* 😟 Anxious
* 😴 Tired
* ⚡ Energetic

---

## 🎯 Mood-Based Recommendations

After selecting a mood, the application provides recommendations suitable for that particular emotional state.

Recommendations can include:

* Activities
* Songs
* Books
* Exercises
* Relaxation techniques
* Productive activities
* Hobbies

---

## 🖥️ Graphical User Interface

The application uses **Java Swing** to create the graphical interface.

Some of the GUI components used include:

* `JFrame`
* `JPanel`
* `JLabel`
* `JButton`
* `JComboBox`
* `JTextArea`
* `JOptionPane`

The user can interact with the application using buttons, dropdowns, and other graphical components instead of entering commands in the terminal.

---

## 🎨 Dynamic Interface

The interface can change according to the selected mood.

For example, the application can update:

* Background colors
* Text colors
* Mood information
* Recommendation sections
* Selected mood indicators

This makes the application more interactive and easier to use.

---

## 🕒 Assessment Time

The application can also record the date and time of an assessment.

Java's `java.time` package can be used for this purpose.

Example:

```text
Assessment Date: 04 October 2026
Assessment Time: 01:30 PM
```

---

# 3. How the Application Works

The basic working of the application is:

```text
User opens application
        ↓
Mood assessment screen appears
        ↓
User selects current mood
        ↓
Application processes the selected mood
        ↓
Recommendation engine finds suitable options
        ↓
Activities, songs, books and exercises are displayed
        ↓
User chooses an activity
```

### Step 1 — Start the Application

The user launches the Java application.

The main window appears with the project title and available options.

### Step 2 — Select Mood

The user selects their current mood.

For example:

```text
Select Your Current Mood:

😊 Happy
😢 Sad
😫 Stressed
😐 Bored
😠 Angry
😟 Anxious
😴 Tired
⚡ Energetic
```

### Step 3 — Process Mood

The selected mood is passed to the recommendation logic.

The application checks the recommendations associated with that mood.

### Step 4 — Generate Recommendations

The system finds suitable recommendations such as:

* Activities
* Songs
* Books
* Exercises
* Lifestyle suggestions

### Step 5 — Display Results

The recommendations are displayed through the GUI.

The user can then select an option according to their preference.

---

# 4. Moods Supported

The application currently focuses on the following moods:

| Mood        | Example Recommendations                              |
| ----------- | ---------------------------------------------------- |
| 😊 Happy    | Music, social activities, creative hobbies           |
| 😢 Sad      | Relaxing music, reading, talking with friends        |
| 😫 Stressed | Breathing exercises, meditation, short walks         |
| 😐 Bored    | Games, hobbies, learning something new               |
| 😠 Angry    | Exercise, relaxation, calming activities             |
| 😟 Anxious  | Breathing exercises, meditation, peaceful activities |
| 😴 Tired    | Rest, light stretching, relaxing music               |
| ⚡ Energetic | Exercise, sports, productive activities              |

The recommendation data can be modified or expanded according to project requirements.

---

# 5. Technologies Used

## Programming Language

**Java 11+**

Java is used for:

* Application logic
* Classes and objects
* Methods
* Data handling
* GUI programming
* Event handling

---

## GUI

**Java Swing**

Java Swing is used to create the desktop interface.

Important components include:

```java
JFrame
JPanel
JLabel
JButton
JComboBox
JTextArea
JOptionPane
```

---

## Java AWT

The `java.awt` package is used for:

* Layout management
* Colors
* Fonts
* Component positioning
* GUI-related operations

Examples:

```java
Color
Font
FlowLayout
BorderLayout
GridLayout
```

---

## Java Time API

The `java.time` package is used for handling date and time.

Examples:

```java
LocalDate
LocalTime
LocalDateTime
DateTimeFormatter
```

---

## Java Collections

Java Collections can be used to store and manage recommendation data.

Examples:

```java
ArrayList
List
Map
HashMap
```

---

## Database

**MySQL** can be used for storing application data such as:

* User information
* Mood selections
* Assessment history
* Recommendations
* Activity records

Database functionality can be added or used depending on the project version.

---

# 6. OOP Concepts Used

This project demonstrates several important Object-Oriented Programming concepts.

## 6.1 Classes and Objects

Classes are used to represent different parts of the application.

For example:

```java
class Recommendation {
    String activity;
    String song;
    String book;
}
```

An object can be created from this class:

```java
Recommendation recommendation = new Recommendation();
```

---

## 6.2 Encapsulation

Encapsulation is used to keep data protected inside a class and access it using methods.

Example:

```java
private String mood;

public String getMood() {
    return mood;
}

public void setMood(String mood) {
    this.mood = mood;
}
```

---

## 6.3 Abstraction

The user does not need to know how the recommendation is internally generated.

The user simply selects a mood, while the application handles the recommendation logic internally.

---

## 6.4 Constructors

Constructors are used to initialize objects.

Example:

```java
public Recommendation(String activity, String song, String book) {
    this.activity = activity;
    this.song = song;
    this.book = book;
}
```

---

## 6.5 Methods

Methods divide the application into smaller tasks.

Examples:

```text
selectMood()
getRecommendation()
displayRecommendation()
resetAssessment()
```

This makes the code easier to understand and maintain.

---

## 6.6 Enumeration

An `enum` can be used to represent the different moods.

Example:

```java
enum Mood {
    HAPPY,
    SAD,
    STRESSED,
    BORED,
    ANGRY,
    ANXIOUS,
    TIRED,
    ENERGETIC
}
```

Using an enum provides a structured way of managing mood values.

---

# 7. Project Structure

A possible project structure is:

```text
Mood-Based-Activity-Recommender/
│
├── src/
│   ├── Main.java
│   ├── Mood.java
│   ├── Recommendation.java
│   ├── RecommendationEngine.java
│   ├── MoodAssessment.java
│   └── GUI.java
│
├── database/
│   └── mood_recommender.sql
│
├── resources/
│   └── images/
│
├── README.md
│
└── .gitignore
```

> The exact file names may be different depending on the final implementation of the project.

---

# 8. System Requirements

## Hardware Requirements

| Component | Minimum Requirement  |
| --------- | -------------------- |
| Processor | Dual-Core Processor  |
| RAM       | 2 GB                 |
| Storage   | 50 MB free space     |
| Display   | 1366 × 768 or higher |

## Software Requirements

| Software         | Requirement                                  |
| ---------------- | -------------------------------------------- |
| Operating System | Windows 10/11, Linux, or macOS               |
| Java             | JDK 11 or above                              |
| IDE              | IntelliJ IDEA / Eclipse / NetBeans / VS Code |
| Database         | MySQL (if required)                          |

---

# 9. Installation and Setup

## Step 1 — Install Java

Install JDK 11 or a newer version.

After installation, open Command Prompt or Terminal and check the Java version:

```bash
java -version
```

Also check the Java compiler:

```bash
javac -version
```

If both commands display a version number, Java has been installed correctly.

---

## Step 2 — Install an IDE

The project can be opened using any Java-compatible IDE.

Recommended IDEs:

* IntelliJ IDEA
* Eclipse
* NetBeans
* Visual Studio Code

---

## Step 3 — Clone the Repository

Clone the GitHub repository using:

```bash
git clone <repository-url>
```

Then open the project folder in your preferred IDE.

---

## Step 4 — Compile the Project

If running the project directly from the command line, compile the Java source files using:

```bash
javac *.java
```

The exact command may vary depending on the project folder structure.

---

## Step 5 — Run the Application

Run the main Java class.

For example:

```bash
java Main
```

If using IntelliJ IDEA or another IDE, the application can also be started using the **Run** button.

---

# 10. MySQL Database Setup

If the database version of the project is being used, MySQL can be installed and configured.

### Create Database

```sql
CREATE DATABASE mood_recommender;
```

Select the database:

```sql
USE mood_recommender;
```

Tables can then be created for users, moods, assessments, and recommendations.

Example:

```sql
CREATE TABLE assessments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mood VARCHAR(50),
    assessment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### JDBC Connection

Java can connect to MySQL using JDBC.

Example:

```java
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mood_recommender",
    "root",
    "password"
);
```

Replace the username and password with the credentials configured on the local system.

---

# 11. Recommendation Logic

The recommendation engine connects each mood with a suitable set of suggestions.

A simplified version of the logic is:

```text
HAPPY
→ Energetic music
→ Social activities
→ Creative hobbies

SAD
→ Relaxing music
→ Reading
→ Talking with friends

STRESSED
→ Breathing exercises
→ Meditation
→ Short walk

BORED
→ Games
→ Hobbies
→ Learning activities

ANGRY
→ Exercise
→ Relaxation
→ Calming activities

ANXIOUS
→ Breathing exercises
→ Meditation
→ Quiet activities

TIRED
→ Rest
→ Light stretching
→ Relaxing music

ENERGETIC
→ Exercise
→ Sports
→ Productive activities
```

The recommendation data can be expanded later to provide more choices.

---

# 12. Application Architecture

The project follows an **MVC-inspired architecture**.

## Model

The Model represents the application's data.

Possible model classes include:

```text
Mood
Recommendation
User
Assessment
```

---

## View

The View is responsible for what the user sees.

Java Swing components are used to create the graphical interface.

Examples:

```text
JFrame
JPanel
JLabel
JButton
JTextArea
```

---

## Controller / Application Logic

The controller or logic layer processes user actions and connects the GUI with the recommendation system.

The general flow is:

```text
User
 ↓
GUI
 ↓
Mood Selection
 ↓
Recommendation Engine
 ↓
Recommendation Data
 ↓
GUI
 ↓
User
```

This separation makes the project easier to understand and modify.

---

# 13. Four Main Modules

## Module 1 — Mood Assessment

This module is responsible for:

* Displaying available moods
* Taking the user's mood selection
* Storing the selected mood
* Managing the assessment state

---

## Module 2 — Recommendation Engine

This module handles:

* Processing the selected mood
* Finding suitable recommendations
* Categorizing activities
* Displaying appropriate suggestions

---

## Module 3 — GUI State Management

This module handles the graphical interface.

Responsibilities include:

* Updating the interface
* Changing colors
* Displaying selected mood
* Updating recommendation panels
* Handling button clicks
* Managing user interaction

---

## Module 4 — Data / Database Management

This module handles application data.

Responsibilities include:

* Storing recommendation data
* Managing user information
* Saving assessment history
* Retrieving stored records
* Connecting Java with MySQL

---

# 14. Advantages

Some advantages of the project are:

1. Simple and easy-to-use interface.
2. Recommendations are based on the selected mood.
3. Demonstrates practical Java programming.
4. Demonstrates important OOP concepts.
5. Uses a graphical interface instead of a console-only application.
6. Can be connected to a database.
7. Can be expanded with additional moods and recommendations.
8. Can be converted into a web or mobile application in the future.

---

# 15. Limitations

The current project has some limitations:

* Recommendations are mainly based on predefined data.
* The application does not diagnose mental health conditions.
* The recommendation quality depends on the available data.
* The desktop version requires Java to be installed.
* The basic version does not automatically learn from user behavior.
* Recommendations may not be suitable for every individual.

The application should therefore be considered a **general lifestyle recommendation tool**, not a medical or psychological diagnosis system.

---

# 16. Future Scope

There are several ways in which this project can be improved.

## 🤖 AI-Based Recommendations

An AI or machine learning model could be integrated to provide more personalized recommendations based on previous user choices.

## 📱 Android Application

The same concept could be developed as an Android application so that users can access it directly from their smartphones.

## 🌐 Web Application

A web version could allow users to access the system through a browser.

## 👤 User Accounts

Login and registration functionality could be added to maintain individual user profiles.

## 📊 Mood History

The application could store previous mood assessments and display them using charts or graphs.

## 🎵 Music API Integration

A music API could be integrated to provide actual song recommendations based on the selected mood.

## ⏱️ Time-Based Recommendations

The application could ask how much free time the user has.

For example:

```text
How much free time do you have?

5 minutes
15 minutes
30 minutes
1 hour+
```

The system could then recommend activities that fit the available time.

## 🎯 Personalized Recommendations

Additional information such as interests, preferred activities, energy level, and previous choices could be used to improve recommendations.

---

# 17. Example User Flow

A typical session can look like this:

```text
┌─────────────────────────┐
│     Start Application   │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│    Welcome Screen       │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│    Mood Assessment      │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│   Select Current Mood   │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│ Recommendation Engine   │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│ Activities / Songs /    │
│ Books / Exercises       │
└────────────┬────────────┘
             ↓
┌─────────────────────────┐
│  User Selects Activity  │
└─────────────────────────┘
```

---

# 18. Conclusion

The **Mood-Based Activity Recommender** is a Java-based desktop application created to provide simple and useful recommendations according to a user's current mood.

The project combines **Java, Java Swing, Collections, Date and Time APIs, and Object-Oriented Programming concepts** to create a complete application.

It also provides a practical example of how concepts such as classes, objects, constructors, encapsulation, abstraction, methods, and enums can be used together in a real project.

The current version provides a basic foundation for mood-based recommendations. In the future, the project can be extended with AI-based personalization, user accounts, recommendation history, APIs, database improvements, and mobile or web support.

---

# 19. Author

**Project Name:** Mood-Based Activity Recommender

**Project Type:** Java OOP Desktop Application

**Technology:** Java, Java Swing, MySQL

**Developed for:** Academic / College Project

---

## 📄 License

This project is created for educational and academic purposes.

If you want to reuse or modify the project, you are free to do so for learning and development purposes.
