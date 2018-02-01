# AndroidPOC
This repository contains classes for retrieving list of data from the json URL. It uses MVP design with RX Java, Dagger 2, Retrofit library. This Demo application is a native app which gives list of data with their images and content. User can select an item from the list to view more.


## Dependency

This app is developed with Android Studio 3.0 and latest Gradle version 3.0.1
Hence use
-Android Studio 3.0
-Compile SDK version 26

## Features

- list with images
- User can select an item to get more details
- Uses RX Java with android and MVP architecture
- Uses Retrofit library for network calls
- Uses Dependency Injection with Dagger2
- Unit testing with Mockito framework

## Folder Structure

- it is divided into 3 : Business, DI ( dependency Injection) , UI
- Business layer contains
      - Data = contains core API and Usecase classes for retrofit calls
      - model = contain the POJO classes Data object and DomainModel as JSON responses
- DI layer contains Dependency module and interface for Dagger
- UI layer contains - Activity, Fragment and MVP ( presenter, contract interface and Recylcer view adapter)

## BUILD and RUN

Use Android Studio 3.0 and Gradle 3.0 to build the project.
Application can be tested on Phone / emulator


## Improvement points

Based on time, I wish to improve on :

- Adding a card view layout for showing the actors list in Recycler view.
- Add a validation util class for null check exceptions.
- Add more unit test cases for testing the CoreUseCase class.
