# Spring-Framework-Study
**This is my note on studying Java Spring Boot**
## Note 1005 - Make my first web app
* [Project Code :point_left:](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp)
* [How to validate user's input? :point_left:](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/todo/Todo.java)
*  `@SessionAttributes` is an annotation used to specify which model attributes should be stored in the HTTP session between multiple requests for a particular controller. It allows you to persist specific model attributes across multiple HTTP requests within a user's session, making it accessible throughout their interaction with a particular controller.

* Here's how we can use the `@SessionAttributes` annotation:

  * Define a Controller Class: Create a controller class where you want to use session attributes.

  * Annotate the Controller Class: Annotate the controller class with `@SessionAttributes`, specifying the names of the model attributes that you want to keep in the session.

  * Use Model Attributes: In your controller methods, use the `@ModelAttribute` annotation to add attributes to the model. These attributes will be stored in the session if their names match the names specified in `@SessionAttributes`.

  * Access Session Attributes: You can access session attributes in subsequent requests by simply declaring the attribute in your controller method parameters.
  * [Example :point_left:](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/todo/TodoController.java)


## Note 1004 - Learn jpa and hibernate
* [Example for JDBC :point_left:](learn-jpa-and-hibernate/src/main/java/com/example/springboot/learnjpaandhibernate/course/jdbc/CourseJdbcRepository.java)
* [Example for JPA :point_left:](learn-jpa-and-hibernate/src/main/java/com/example/springboot/learnjpaandhibernate/course/jpa/CourseJpaRepository.java)
* [Example for Spring JPA :point_left:](learn-jpa-and-hibernate/src/main/java/com/example/springboot/learnjpaandhibernate/course/springdatajpa/CourseSpringDataJpaRepository.java)
* [Application.properties :point_left:](learn-jpa-and-hibernate/src/main/resources/application.properties)
* [Denpedencies :point_left:](learn-jpa-and-hibernate/pom.xml)


## Note 0930 Examples of fundamental terminologies in JAVA Spring
* [Examples :point_left:](demo1/demo1/src/main/java/com/example/demo2/example)


## Note 0921 - Git commands
`git commit -am "commit message"` is the shortcut of commit + add but only for modifying file, not for creating a new file.

How to make a branch? Such as a branch named "feature-1"? 

* Use `git checkout` to switch between the different branches.

* Use `git diff <branch name>` to show the different branches' differences.

* Use `git merge <branch name>` to merge the branch to the master branch.

* Use `git reset <optional: file name or commit hash value (get from git log)>`
  * "reset": This subcommand is used to reset the current branch to a specified commit. It can be used in different modes, including --hard, --soft, and --mixed.
  * "--hard": This option specifies the reset mode as "hard," which means that not only will the branch pointer be moved to the specified commit, but all changes in your working directory and staging area will be discarded. Any commits that came after the specified commit will also be permanently removed from the branch's history.

``` git
git status
git branch
git checkout -b feature-1
get branch
git checkout master
git diff feature-1
git push -u origin feature-1
git checkout feature-1
git merge
...(make some change in feature-1)...
git checkout master
git pull
git branch -d feature-1 //delete feature-1
git reset --hard <hash value> //

```

