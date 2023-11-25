[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

![WeekGUI2.png](..%2F..%2FWeekGUI2.png)

SOLID Principles

1. Single-Responsibility Principle:
All the classes in this assignment have only one job. For example,
TaskConstructor and EventConstructor classes are only responsible for creating 
tasks and events, respectively. These class do not update the view or act
as a controller.

2. Open-Closed Principle
All classes, modules and methods can be open for extension, 
but closed for modification. For example, the class guiFileFinder 
implements the interface WelcomeGuiView. The class inherits the load method 
which it needs to load new scene. If another filefinder object was needed, the class would implement 
the interface WelcomeGuiView extend functionality but not change existing code.
All handle methods in the class HandleBarNewScreensDisplay can be abstracted to handle the loading
of multiple fxml files.

3.  Liskov Substitution Principle
All subclasses can be substituted for their parent class. A model
abstract class which all model classes extend from could be used.

4. Interface Segregation Principle
Classes should not be forced to implement an interface it does not need.
For example, the class guiFileFinder implements the interface WelcomeGuiView.
The class inherits the load method which it needs to load new scene.

5. Dependency Inversion Principle
Classes can depend on abstractions instead of concrete objects. For example, the class guiFileFinder
implements the interface WelcomeGuiView. The class inherits the load method
which it needs to load new scene. If a class wanted to have an instance of a GuiFileFinder, 
the class would depend on the WelcomeGuiView interface instead of the GuiFileFinder concrete class.

Additional, non-implemented Feature:
All handle methods in the class HandleBarNewScreensDisplay can be abstracted to handle the loading
of multiple fxml files. A vertical layout can be implemented using this abstracted method to load
a vertical layout.

