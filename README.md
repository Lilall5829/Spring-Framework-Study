# Spring-Framework-Study
**This is my note on studying Java Spring Boot**
## Note 1009 - Make my first web app P105-P104
1. Mapping [Todo data](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/todo/Todo.java) to database by `@Entitiy`, `@Id`, `@GeneratedValue` and `@Column`.
   ```java
   @Entity(name = "TodoABC") //Rename your table in h2 database
   public class Todo {
       public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
           this.id = id;
           this.username = username;
           this.description = description;
           this.targetDate = targetDate;
           this.done = done;
       }
       @Id
       @GeneratedValue
       private int id;
       @Column(name="name") //Rename your column in h2 database
       private String username;
   ```
2. Populate data to start off
   - [Create an SQL file](myfirstwebapp/src/main/resources/data.sql)
   - [Set app properties:](myfirstwebapp/src/main/resources/application.properties) `spring.jpa.defer-datasource-initialization=true` Make sure the SQL will execute after the table is created, or there will be an error.

3. Create an interface as [TodoRepository](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/todo/TodoRepository.java) and [a new controller of JPA](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/todo/TodoControllerJPA.java). And comment on the `@Controller` of the old controller.
4. Use some methods of `todoRepository`
5. [Install and set Docker](02.Spring-Boot-Web-Application-V2)
   - [How to fix the error: docker: Error response from daemon: Ports are not available: exposing port TCP 0.0.0.0:3306 -> 0.0.0.0:0: listen tcp 0.0.0.0:3306: bind: Only one usage of each socket address (protocol/network address/port) is normally permitted.](https://www.dark-hamster.com/application/how-to-solve-error-message-error-response-from-daemon-ports-are-not-available-exposing-port-tcp-when-running-docker-compose-in-microsoft-windows/)
   - Before using MySQL, we need to comment on the dependency and the application properties of h2 database and add new dependency:
    ```
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    ```
    - Add new applcation properties:
      ```
      #The following values come from the command of initializing Docker
      spring.datasource.url=jdbc:mysql://localhost:3306/todos
      spring.datasource.username=todos-user
      spring.datasource.password=dummytodos
      #The following values come from MySQL8Dialect(double click shift and search it)
      spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
      #The following code makes JPA create a table automatically
      spring.jpa.hibernate.ddl-auto=update
      ```
6. Open MySql Shell and input `\connect todos-user@localhost:3306`
   - Set the schema to todos by `\use todos`
   - Use SQL by `\sql`
     Then you can write some SQL queries.
   
     
  

## Note 1008 - Make my first web app P98-P104
1. How to reduce duplicate code in JSP files
   - [Put them into separate JSP files, like header, navigation, footer, etc.](myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/common)
   - [And link them to other JSP files like:](myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/addTodo.jsp)
    ```jsp
    <%@ include file="common/header.jspf" %>

    <%@ include file="common/navigation.jspf" %>
    ```
2. Spring Security and set new users
   
   There will automatically generate a login page. All URLs are protected by Spring Security. So, you need to log in before using the app.

   The user name is "user," and the password will differ every time you log in. It will be shown in the log information in the console like:
   ```
   Using generated security password: xxxxxx-xxxx-xxxx-xxxx-xxxxxx
   This generated password is for development use only. Your security configuration must be updated before running your application in production.
   ```
   - Add dependency on Spring Security
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    ```
    - Set your own users and passwords: Create [SpringSecurityConfiguration](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/security/SpringSecurityConfiguration.java) and [WelcomeController](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/login/WelcomeController.java)

3. Add JPA and H2 Database
   - Add dependency on JPA
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   <dependency>
       <groupId>com.h2database</groupId>
       <artifactId>h2</artifactId>
       <scope>runtime</scope>
   </dependency>
   ```
5. Start H2
   - The URL of starting H2 is `http://localhost:8080/h2-console`
   - Add JDBC URL to [application.properties](myfirstwebapp/src/main/resources/application.properties):`spring.datasource.url=jdbc:h2:mem:testdb`. This URL will be inputted on the login page
   - Set some [security config](myfirstwebapp/src/main/java/com/springboot/myfirstwebapp/security/SpringSecurityConfiguration.java)
     ```java
      @Bean 
      public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
         //Don't forget to import Customizer.withDefaults!
         http.formLogin(withDefaults());
         http.csrf().disable();
         http.headers().frameOptions().disable();
         return http.build();
      }
     ```

    
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


