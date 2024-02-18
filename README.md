# Minimal AIML chatbot

Minimal chatbot using **Program AB** implementation of the **AIML 2.0** draft specification.

![Version](https://img.shields.io/badge/version-0.0.3-2AAB92.svg)
![Static Badge](https://img.shields.io/badge/Last%20update-20%20Dec%202022-blue)

[![Version](https://img.shields.io/badge/JDK-17-red.svg)](https://jdk.java.net/17/)
[![Version](https://img.shields.io/badge/Spring%20Boot-2.7.5-green.svg)](https://spring.io/projects/spring-boot)
[![Version](https://img.shields.io/badge/ZK-9.6.0-blue.svg)](https://www.zkoss.org/)
[![Version](https://img.shields.io/badge/Bootstrap-5.2.2-purple.svg)](https://getbootstrap.com/)

---

# Table of Contents

* [About the Project](#about-the-project)
* [Installation](#installation)
* [Usage](#usage)
* [License](#license)

# About the project

<table>
  <tr>
    <td>
        <img alt="Java logo" src="logo-java.svg" height="72"/>
    </td>
    <td>
        <img alt="Spring logo" src="logo-spring.svg" height="36"/>
    </td>
    <td>
        <img alt="ZK logo" src="logo-zk.svg" height="96"/>
    </td>
    <td>
        <img alt="H2 logo" src="logo-bootstrap.svg" height="56"/>
    </td>
  </tr>
</table>

This program provides a minimal **Spring Boot** application with a **ZK** frontend allowing to interact with a rule-based chatbot easily.

It uses the **Program AB** library : <https://code.google.com/archive/p/program-ab/>

This project is for testing purpose. The custom bot is very basic and just understand some French sentences, the goal was to test some minimal interactions,
not to have a complete production-ready chatbot.

# Installation

1. Clone the repository :
    ```shell script
    git clone https://github.com/Yann39/aiml-chatbot
    ```
2. Build the JAR file using **Maven** :
   ```shell script
   mvn clean package
   ```
3. Execute application from Intellij or run the JAR file :
   ```shell script
   java -jar /target/eth-hash-app.jar
   ```
4. Reach <http://localhost:8080/>

# Usage

There are 2 bots :

- `super` : the default provided bot with the Program AB library.
- `custom` : our custom bot

You can change the bot by changing the `BOT_NAME` constant in the main view model (`MainVm`).

Then simply run the program and reach <http://localhost:8080>.

<table>
  <tr>
    <td>
      <img alt="Spring logo" src="screen-chatbot2.png"/>
    </td>
    <td>
      <img alt="Spring logo" src="screen-chatbot.png"/>
    </td>
  </tr>
</table>

# License

[General Public License (GPL) v3](https://www.gnu.org/licenses/gpl-3.0.en.html)

This program is free software: you can redistribute it and/or modify it under the terms of the GNU
General Public License as published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not,
see <http://www.gnu.org/licenses/>.