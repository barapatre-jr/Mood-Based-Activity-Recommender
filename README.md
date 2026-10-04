# Mood-Based Activity Recommender

A complete, professional Java desktop application designed to assess the user's emotional state and provide tailored recommendations[cite: 6]. This project demonstrates real-world application of Object-Oriented Programming (OOP) concepts, graphical user interfaces (GUI), and state management[cite: 4, 6].

**Table of Contents**
1. [Project Introduction](#project-introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [System Requirements](#system-requirements)
5. [Installation Setup](#installation-setup)
6. [How to Run the Project](#how-to-run-the-project)
7. [Application Architecture](#application-architecture)
8. [Mood Categories Supported](#mood-categories-supported)
9. [Author & License](#author--license)

---

## Project Introduction
The Mood-Based Activity Recommender is an interactive application that evaluates how you are feeling through a quick, intuitive interface[cite: 4, 6]. Instead of generic suggestions, it dynamically maps your current mood to specifically curated activities, songs, books, and exercises to either match your energy or help improve your emotional well-being[cite: 6]. 

This project follows a clean architecture separating the user interface elements from the core logical enums and data processing models[cite: 4, 6].

---

## Features

### Core Assessment Module
* Dynamic mood selection interface with visual cues (Color-coding and Emojis)[cite: 4].
* Real-time state tracking of user selections.
* Automated validation of user input.

### Recommendation Engine Module
* **Activity Suggestions:** Daily tasks or hobbies matched to current energy levels[cite: 6].
* **Media Curation:** Specific song and book recommendations tailored to emotional states[cite: 6].
* **Health & Wellness:** Exercise prompts and physical activity suggestions[cite: 6].

### User Interface Module
* Clean, professional windowed layout using Java Swing[cite: 4].
* Custom typography and color schemes mapped to specific emotions[cite: 4].
* Interactive buttons, dialogs, and responsive layout management.

---

## Technologies Used

**Frontend (GUI)**
* **Java Swing:** For window rendering, panels, buttons, and layout[cite: 4].
* **Java AWT (Abstract Window Toolkit):** For color profiles, fonts, and event handling[cite: 4].

**Core Logic**
* **Java 11+:** Core programming language[cite: 6].
* **Object-Oriented Programming (OOP):** Encapsulation, Enums, and custom data structures[cite: 4, 6].
* **Java Time API:** For tracking when assessments are taken (`java.time.LocalDateTime`)[cite: 4].

---

## System Requirements

### Software Requirements
* Java Development Kit (JDK) 8 or higher
* Any standard Java IDE (IntelliJ IDEA, Eclipse, NetBeans, or VS Code)
* Operating System: Windows 10/11, macOS, or Linux

### Hardware Requirements
* Minimum 2GB RAM
* 50MB free disk space
* Any modern processor (Intel/AMD/Apple Silicon)

---

## Installation Setup

**Step 1: Install Java**
Download and install JDK 8 or higher from the official Oracle website or OpenJDK. Verify the installation by opening your terminal and running:
`java -version`

**Step 2: Clone the Project**
Clone this repository to your local machine using Git:
`git clone https://github.com/barapatre-jr/Mood-Based-Activity-Recommender.git`

**Step 3: Open in IDE**
1. Launch your preferred Java IDE.
2. Select "Open Project" and navigate to the cloned repository folder.
3. Allow the IDE to index the files and configure the JDK path.

---

## How to Run the Project

1. Navigate to the `src` folder in your project explorer.
2. Locate the main application file: `MoodActivityRecommenderGUI.java`[cite: 6].
3. Right-click the file and select **Run 'MoodActivityRecommenderGUI.main()'**.
4. The application window will launch automatically on your desktop.

---

## Application Architecture

The application utilizes a modular Object-Oriented approach:

* **View Layer:** `MoodActivityRecommenderGUI` handles all `javax.swing` components, action listeners, and UI updates[cite: 4, 6].
* **Data Model:** Custom `Enum Mood` structures store the constants for labels (e.g., "Happy", "Sad"), emojis, background colors, and foreground colors[cite: 4].
* **Controller Logic:** Event listeners capture button clicks, instantiate the appropriate recommendation objects, and push the data back to the View Layer.

---

## Mood Categories Supported

The system currently tracks and processes the following emotional states[cite: 4]:
* `HAPPY` (😀) 
* `SAD` (😔)
* `STRESSED` (😫)
* `BORED` (😐)
* `ANGRY` (😠)
* `ANXIOUS` (😰)
* `TIRED` (😴)
* `ENERGETIC` (⚡)

---

## Author
* **barapatre-jr**[cite: 5]
* Built as a Java Desktop Application project[cite: 6].

## License
This project is created for educational and portfolio purposes.
