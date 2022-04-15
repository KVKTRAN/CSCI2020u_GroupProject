# Messenging App

## Introduction
Our project is a server based messenging application. Users may host servers or join existing servers to chat with other users in the server.

## Usage

When running the app, users are prompted to either host a server, or join an existing one. 

![](2022-04-14-21-49-56.png)

When hosting, the user is asked to pick a server name and password.

![](2022-04-14-21-51-33.png)

When joining, the user is asked for the server name, password, and a username. They will then be able to message everyone in the server.

![](2022-04-14-21-54-06.png)

## Requirements
Java JDK 17.0.2
Gradle 
Javafx SDK 17.0.2

## Setup

1. Download the project
2. Open the project in IntelliJ
3. Select LoginApplication.java under src > main > java > com.example.groupproject
4. From the Run menu, click on Edit Configurations 
5. Click on Modify options, check "Add VM options"
6. Configure according to the screenshot ![](2022-04-14-22-10-14.png) 
7. In VM options, paste this: --module-path "C:\Program Files\Java\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
8. Click apply and ok
9. Run LoginApplication

## Video Demo
https://youtu.be/AzaHc6qWIPw

