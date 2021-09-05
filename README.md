# ChocolateFactory

## Architecture
The arcchitecture of the app is a Clean Architecture with MvvM.
The diferent layers are containt on the same Android module but don't have interactions from the internal layers to the external ones following Clean Architecture guide lines. 

![Esquema Clean](https://user-images.githubusercontent.com/22010618/132135079-7198a96b-e18b-4c9f-ba36-f6e3c6e10c5e.png)

#### UI 
It's the more extern layer and contains all the Android framework related. Activities, ViewModels,fragments, xml, Sqlite Db (Room)... 
#### Data / UseCases
It's the layer of the aplication logic, it contains the use cases and the repository. It allows the comunication between UI and Domain
#### Domain
It's the most intern layer and contains the business logic, entities of the app

## Dependencies 

#### Coroutines 
For async calls, long runing operations

#### Koin 
Dependency injection

#### Timber
Android logging

#### Retrofit
HTTP client for server calls

#### Glide
Image loading abd caching

#### Room 
Sqlite Db

*Note : using Room with Mac M1 microships has this known issue https://youtrack.jetbrains.com/issue/DBE-12342. 
I add kapt 'org.xerial:sqlite-jdbc:3.34.0' into build.graddle module app ass suggested in the issue to fixed







