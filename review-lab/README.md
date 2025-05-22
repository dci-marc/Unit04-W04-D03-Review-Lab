## Lab: Pet Adoption Management System (Spring Boot, JPA, Thymeleaf, Validation, Redis, Cloudinary)

### Objective

Build a full-stack Spring Boot web application to manage pets available for adoption, adoption centers, and adopters.


### Part 1: Project Setup

#### Step 1: Generate a Spring Boot Project

Use [https://start.spring.io](https://start.spring.io) to generate a Spring Boot project with the following dependencies:

* **Spring Web**
* **Spring Data JPA**
* **PostgreSQL Driver**
* **Thymeleaf**
* **Validation**
* **Lombok**


---

## Part 2: Configuration

### In `application.properties`, configure your PostgreSQL database connection:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

---

## Part 3: Create Your First Entity (Model)

Create a model called `Pet` with the following fields:

- `Long petId `
- `String name `
- `String breed `
- `int age `


---




## Part 4: Build Repository, Service, Controller

### Example:

* `PetRepository extends JpaRepository<Pet, Long>`
* `PetService` → CRUD logic
* `PetController`:

  * `/pets` – list
  * `/pets/new` – create form
  * `/pets/edit/{id}` – edit form
  * `/pets/delete/{id}` – delete
  * `/pets/save` – POST form

---

## Part 5: Create Thymeleaf Templates

Pages:

* `pets/index.html`
* `pets/form.html`
* Include field error messages:

```html
<div th:if="${#fields.hasErrors('name')}" th:errors="*{name}">Name Error</div>
```

---

## Part 6: Add Two More Models

### `AdoptionCenter` (One-to-Many with Pets)

```java
@Entity
public class AdoptionCenter {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Center name is required")
    private String name;

    private String location;

    @OneToMany(mappedBy = "center")
    private List<Pet> pets;
}
```

---

### `Adopter` (Many-to-Many with Pets)

```java
@Entity
public class Adopter {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String fullName;

    private String phone;

    @ManyToMany(mappedBy = "adopters")
    private List<Pet> adoptedPets;
}
```

---

## Part 7: Validation in Thymeleaf

Make sure if a user fails validation, they see helpful messages in the form.

Use:

```html
<form th:action="@{/pets/save}" th:object="${pet}" method="post">
  <input th:field="*{name}" />
  <div th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></div>
</form>
```

---


## BONUS SECTION

### Bonus 1: Redis Caching

1. Add the `spring-boot-starter-data-redis` dependency.
2. Configure `application.properties`:

```properties
spring.cache.type=redis
spring.redis.host=localhost
spring.redis.port=6379
```

3. In your service layer, cache resource fetches:



4. Enable caching:

```java
@SpringBootApplication
@EnableCaching
public class YourApp {
}
```

---

### Bonus 2: Cloudinary Integration (Image Upload)

1. Add the Cloudinary Java SDK dependency.

2. Create a service to handle image upload:

```java
@Service
public class CloudinaryService {
    private final Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "your_cloud_name",
        "api_key", "your_api_key",
        "api_secret", "your_api_secret"
    ));

    public String upload(MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("secure_url").toString();
    }
}
```

3. Add a `String imageUrl` field to `Pet`, and store the Cloudinary image URL after upload.

4. Add an upload input in your Thymeleaf form:

```html
<input type="file" name="image">
```


