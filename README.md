# Spring-Framework-Study
**This is my note on studying Java Spring Boot**
## Note 1117 Spring Security

   [Project example](spring-security/src/main/java/com/example/springsecurity)

   <img width="571" alt="33" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/07980cdc-eb3e-4272-aa54-a980fd9a0a49">

   <img width="533" alt="34" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/08f45d98-29e6-4e8a-81eb-71ff9a605b7a">

   <img width="812" alt="35" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/87bbe7a6-55f8-42b4-9905-144182ab8f0e">

   <img width="476" alt="36" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/202ef506-44ba-42c8-971e-1a8cfc10462f">



## Note 1106 Use JWT
### Get token from Talend API Tester
   1. Create a POST request to get token from /authenticate

   ![31](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/717afa76-3694-455b-b65c-7d71256b44b5)

   2. Create a GET request to use token. **Note**: The token must be the latest one get from /authenticate!!!
      
   ![32](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/25adefb3-5dad-4363-9fcf-76a989513db2)

## Note 1030 - Back End of Todo APP P1-
### Call REST APIs in React: Axios
   1. Install Axios
      `npm install axios`

   2. Import and use Axios [in Welcome page](FullStack/todo-app/src/components/todo/WelcomeComponent.jsx)

      ```javascript
      import axios from "axios";
      function callHelloWorldRestApi() {
        // Haed code the username here
        retrieveHelloWorldBean("lila")
          .then((response) => successfulResponse(response))
          .catch((error) => errorResponse(error))
          .finally(() => console.log("cleanup"));
        // "then" means when rest API called successful, then do it
      }
      ```
      And [APIService](FullStack/todo-app/src/components/todo/api/HelloWorldApiService.js)
      
      ```javascript
      import axios from "axios";
      // export function retrieveHelloWorldBean() {
      //   // How to call the rest apis in React: axios
      //   return axios.get("http://localhost:8080/hello-world-bean");
      // }
      
      // A simpler way to use axios: create an arrow function
      // export const retrieveHelloWorldBean = () =>
      //   axios.get("http://localhost:8080/hello-world-bean");
      
      const apiClient = axios.create({
        baseURL: "http://localhost:8080",
      });
      
      // How to get a parameter from URL:
      export const retrieveHelloWorldBean = (username) =>
        apiClient.get(`/hello-world/path-variable/${username}`);
      ```
      
      
### Enabling CORS(Cross-Origin Requests) Requests for Spring Boot REST API

   Create a java bean for enabling CORS in [RestfulWebServicesApplication](todoApp/src/main/java/com/rest/webservices/restfulwebservices/RestfulWebServicesApplication.java)
    
   ```java
    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            // Override addCorsMappings
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow any URl and any request from port 3000
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000"); // Notice: The origin should be an absolute path!
            }
    };
   ```


## Note 1022 - Full Stack P156 -196
### Create and Run React app
   1. Create React app in the folder at last step
   ![28](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/8370bb22-34a5-4594-9618-80ca37f26725)

   2. Run the app
   ![29](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/1343e1fd-d655-465a-b4b5-311fc500acd5)

   3. Some important commands
      
      <img width="630" alt="30" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/86a94a88-4137-4d24-a678-0a24d1500092">

   4. Some useful shortcut in VScode
      - Ctrl+B: Toggle the sidebar
      - Ctrl+P: Search files

   5. Make some changes:
      - Change the title of index.html
      - Change the content of [App.js](https://github.com/Lilall5829/VSCodeProject/blob/main/FullStack/todo-app/src/App.js): Remove everything in Appdiv and add new content
      - Change the content of [App.css](https://github.com/Lilall5829/VSCodeProject/blob/main/FullStack/todo-app/src/App.css): remove everything except the first one(.App)
   6. JSX
      - For JSX, **close tags are mandatory** and all couples of tags should wrap with div or empty wrapper(<>...</>)
      - **Custom** Components should start with **upper case letter**
      - Special "**classname**" rather than "class":
        ```jsx
        function FirstComponent() {
            return <div className="FirstComponent">First Component</div>;
        }
        ```

   7. [Babel](https://babeljs.io/)
      - Convert JSX TO JS

   8. [First React app](FullStack/todo-app/src)
      
      
## Note 1021 - Full Stack P152 -155
### Full Stack Architecture
   1. Make sure to install Node.js and npm. And initialize the JSON package:
   
   ![26](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/b6f5bd08-292d-46ab-b748-5bf67fac0707)

   2. Find the json package under `C:\Users\lilal` folder and drag the json package into VScode

   3. Install JQuery dependency

   ![27](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/2f727ca6-9130-47cc-a325-a84a829d66eb)


## Note 1019 - REST API P143-P151
### JPA - Retrieve Posts for users
   1. [Add getters and setters in the User class for Post](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/User.java)
   2. [Add get mapping of retrieving posts for user(By id)](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserJpaResource.java)
      
       ```java
       // Retrieve Posts for user
       @GetMapping("/jpa/users/{id}/posts")
       public List<Post> retrievePosts(@PathVariable int id){
           Optional<User> user = userRepository.findById(id);
           if (user.isEmpty())
               throw new UserNotFoundException("id:" + id);
           return user.get().getPosts();
       }
       ```

### JPA - Create a Post for users
  
   1. [Add invalidation, getters and setters in the Post class](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/Post.java)
   2. [Create repository for post](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/jpa/PostRepository.java)
   3. [Add post mapping of creating posts for user](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserJpaResource.java)

       ```java
       // Create a new post for a user
       @PostMapping("/jpa/users/{id}/posts")
       public ResponseEntity<Object> createPosts(@PathVariable int id, @Valid @RequestBody Post post){
           Optional<User> user = userRepository.findById(id);
           if (user.isEmpty())
               throw new UserNotFoundException("id:" + id);
           post.setUser(user.get());
   
           Post savedPost = postRepository.save(post);
           URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                   .path("/{id}")
                   .buildAndExpand(savedPost.getId())
                   .toUri(); // users/4 => /users/{id}
           return ResponseEntity.created(localtion).build();
       }
       ```
       
### JPA - Security
  
1. How to complete security authorization in Talend API Tester

   ![25](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/16dcddcd-459e-4d13-9356-948051aeb907)

2. [Overriding the default filter chain](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/security/SpringSecurityConfiguration.java), which defined by Spring security
   ```java
   @Configuration
   public class SpringSecurityConfiguration {
       @Bean
       public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
           // 1. All requests should be authenticated
           httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
           // 2. If a request is not authenticated, a web page is shown
           httpSecurity.httpBasic(withDefaults());
           // 3. CSRF -> POST, PUT
           httpSecurity.csrf().disable();
           return  httpSecurity.build();
       }
   }
   ```
     
## Note 1018 - REST API P140-P142
### REST API of Social Media
   1. Create [table](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/User.java)
      ```java
      // Rename "USER" because "USER" is a keyword of SQL
      @Entity(name = "user_details")
      public class User {
          @Id
          @GeneratedValue
          private Integer id;
      ......
      ```
   2. Add `spring.datasource.url=jdbc:h2:mem:testdb` and `spring.jpa.defer-datasource-initialization=true` to application.properties
   3. Create [SQL file](restful-web-services/src/main/resources/data.sql) **Notice: pay attention to the syntax, such as "values", and use '' rather than "" !**
   4. Go to `http://localhost:8080/h2-console/`
   5. Create [Repository](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/jpa/UserRepository.java)
   6. Create [JpaResource](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserJpaResource.java)
### JPA - User's Posts(Not Post of REST API!)
   1. Create a [Post entity](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/Post.java), and we want to post User
   2. Add `@OneToMany` annotation to [User entity](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/User.java), `@ManyToOne(fetch = FetchType.LAZY)` annotation to Post, and `@JsonIgnore` annotation to both of them
   3. Add `spring.jpa.show-sql=true` to application.properties
   4. Add more queries to [SQL files](restful-web-services/src/main/resources/data.sql) 


## Note 1017 - REST API P137-P139
### Spring Boot Actuator

   It helps us monitor and manage our application
   1. Add the dependency and add `management.endpoints.web.exposure.include=*` to application.properties
      
       ```xml
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-actuator</artifactId>
       </dependency>
       ```
     
   2. Go to `http://localhost:8080/actuator` and find more details, such as `http://localhost:8080/actuator/metrics/http.server.requests`.

### HAL Explorer

  <img width="636" alt="21" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/3a9b3f65-ea49-4cef-a264-d494b444a52f">
  
  1. Add the dependency and add `management.endpoints.web.exposure.include=*` to application.properties.

     ```xml
     <dependency>
         <groupId>org.springframework.data</groupId>
         <artifactId>spring-data-rest-hal-explorer</artifactId>
     </dependency>
     ```
     
  2. Go to `http://localhost:8080/explorer/` and find more details:
      
      ![22](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/90542993-011b-4e00-bded-20f4c2e9a3f1)

### Connect REST API to database



## Note 1016 - REST API P133-P136
### Versioning REST API
1. URI Versioning - Twitter
  ```
  http://localhost:8080/v1/person
  http://localhost:8080/v2/person
  ```

- Create [versioning controller](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/versioning/VersioningPersonController.java), [v1(outputs "name")](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/versioning/PersonV1.java), [v2(outputs "firstname" and "lastname")](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/versioning/PersonV2.java)

2. Request Parameter versioning - Amazon
  ```
  http://localhost:8080/person?version=1
  http://localhost:8080/person?version=2
  ```
3. (Custom) header versioning - Microsoft

   ![16](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/2349427a-4a79-40f1-94da-7c881482cad5)

4. Media type versioning(a.k.a "content negotiation" or "accept header") - Github

   ![17](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/e1f4d626-8b60-4e13-98dd-ea55fbb07f5d)

5. Summary

   <img width="506" alt="18" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/14dfde14-192a-4d65-aab9-c79dcfdedc32">

### HATEOAS
<img width="626" alt="19" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/71c89d95-b004-4449-b675-290c1f26d4bc">

1. Add dependency
    ```
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-hateoas</artifactId>
     </dependency>
    ```
  
2. Modify the [controller](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserResource.java)
   
    ```java
    // HATEOAS
      // EntityModel and WebMvcLinkBuilder
      @GetMapping("/users/{id}")
      public EntityModel<User> retrieveUser(@PathVariable int id){
          User user = userDaoService.findById(id);
          if (user == null)
              throw new UserNotFoundException("id:" + id);
          // Wrap the User, create an EntityModel
          EntityModel<User> entityModel = EntityModel.of(user);
          // Use WebMvcLinkBuilder to create a link
          WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
          // Add the link to the EntityModel
          entityModel.add(link.withRel("all-users"));
          return entityModel;
      }
      ```

### Serialization
1. Customize field names in response - Add `@JsonProperty` to [data fields](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/User.java)

  
2. Return only selected fields - filtering
   
   <img width="485" alt="20" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/b8830329-d946-4cb7-badb-5fd56b769306">

   - Static Filtering: add `@JsonIgnore` or `@JsonIgnoreProperties` in the [Bean](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/filtering/SomeBean.java). And it also works on [List](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/filtering/FilteringController.java)
   - Dynamic Filtering: add `@JsonFilter("SomeBeanFilter")` in the [Bean](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/filtering/SomeBean.java). Notice, the property "SomeBeanFilter" should match with "FilterProvider filters" of Controller. And modify [controller](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/filtering/FilteringController.java) as following:
     ```java
     // Dynamic filtering: MappingJacksonValue
     @GetMapping("/filtering")
     public MappingJacksonValue filtering(){
         SomeBean someBean = new SomeBean("value1","value2","value3");

         MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
         //filter setting, only allows field1 and field3
         SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
         FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

         mappingJacksonValue.setFilters(filters);
         return mappingJacksonValue;
     }
     ```



## Note 1015 - REST API P126-P132
### Add validations to the fields of REST API
1. Add dependency
  ```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-validation</artifactId>
     </dependency>
  ```
2. Add `@Valid` at [UserResource](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserResource.java)
3. Add `@Size` and `@Past` at the name and LocalDate fields in [User](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/User.java)
4. Add and **override** method `handleMethodArgumentNotValid()` to [customized exception handler](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/exception/CustomizedResponseEntityExceptionHandler.java) and show the customized exception information.

   ![11](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/717d3a21-6202-46ce-860c-30655d35dbb2)

### REST API Documentation - Swagger and Open API
1. Add [OpenAPI dependency](https://github.com/springdoc/springdoc-openapi/blob/main/springdoc-openapi-starter-webmvc-ui/pom.xml)
   ```xml
       <dependency>
           <groupId>org.springdoc</groupId>
           <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
           <version>2.1.0</version>
       </dependency>
   ```
2. Go to `http://localhost:8080/swagger-ui/index.html`. It shows details of your REST APIs and you can also execute and test them:

   ![12](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/2807a08a-a642-4459-8518-ee03f99975db)

3. `http://localhost:8080/v3/api-docs` shows API document in Json format:

   ![13](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/412d5700-efcf-4fed-bc18-550c28f8194d)

### Content Negotiation
1. Add dependency
   ```xml
       <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
       </dependency>
   ```
2. Add headers, assume that we want to display the http body in XML format:
  ![14](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/fdb8fef9-5006-4c0a-b3b7-fd48aae20455)

### Internationalization - i18n

1. Accept-Language: indicates natural language and **locale** that the consumer prefers. Example: en - English
2. [Add internationalized method](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/helloworld/HelloWorldController.java)
3. [Create messages.properties(EN)](restful-web-services/src/main/resources/messages.properties):`good.morning.message = Good Morning`
4. [Create messages_nl.properties(NL)](restful-web-services/src/main/resources/messages_nl.properties):`good.morning.message = Goedemorgen`, and add HTTP headers. The result will be Dutch:
    ![15](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/d2a76de2-3f67-4be8-b12e-552f676dc66a)


## Note 1011 - REST API P120-P125

**[HTTP response status codes ](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#server_error_responses)** 👈

### Use Talend API Tester to test POST request

1. Google "Taland API Tester" plugin and install it
2. Use it to test a POST request:

   ![7](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/2e448918-a9a5-412b-98b2-68a7782119c5)
3. Location of new user:

   ![8](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/1d274962-d64e-49c1-b616-cbc290215018)

4. How to handle exceptions:
   - [Service](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserDaoService.java)
   - [Exceptions class](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/user/UserNotFoundException.java)

5. [Return a proper error structure(time stamp, error message, and details) for developer or user if the user id doesn't exist.](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/exception)

   



   


## Note 1010 - REST API P112-P119
1. Which APIs will we create?

   ![23](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/8edade7d-f4fc-40b2-9b5b-8d3286bd5b46)

   
3. Create a new project. Add 4 dependencies: Spring Web, Spring Data JPA, H2 Database, and Spring Boot DevTools.
4. Create a [Controller](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/helloworld/HelloWorldController.java) and [Bean class](restful-web-services/src/main/java/com/rest/webservices/restfulwebservices/helloworld/HelloWorldBean.java).
5. Some questions:
   
   <img width="726" alt="bg" src="https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/d9a44e82-833b-4d0d-a2ba-576db3264196">


## Note 1009 - Make my first web app P105-P111
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
5. [Install and set Docker](https://github.com/in28minutes/spring-boot-master-class/tree/master/02.Spring-Boot-Web-Application-V2#docker)
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
   - Switch to SQL mode by `\sql`     
   - Then you can write some SQL queries.
     
     ![9](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/666d9e51-2095-4b51-8fc7-9209073f9ff0)

     ![10](https://github.com/Lilall5829/Spring-Framework-Study/assets/134081469/07eb889d-a244-4db1-9384-c3a3c08474b9)


     
     
   
     
  

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

### How to make a branch? Such as a branch named "feature-1"? 

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


