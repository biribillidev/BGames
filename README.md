# 🎮 BGames API

API REST desenvolvida com Spring Boot para gerenciamento de jogos, desenvolvedoras e categorias, inspirada em plataformas como Steam e Epic Games.

# 👨‍💻 Autor

João Vitor Biribilli Ravelli - RM565594 - 2TDSPG

---

## 🚀 Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database (em memória)  
- Maven  
- Lombok  
- Bean Validation
- Insomnia

---

## 📚 Funcionalidades

- CRUD completo de:
  - 🎮 Games
  - 🏢 Developers
  - 🏷️ Categories  

- Relacionamentos:
  - Game → Developer (ManyToOne)
  - Game ↔ Category (ManyToMany)

- Validação:
  - Validações padrão (`@NotNull`, `@NotBlank`, etc.)
  - Validação customizada (`@ValidPlatform`)

- Tratamento global de erros (ValidationHandler)

- Paginação e ordenação

- Filtros e buscas (mais de 5 endpoints)

- Projections (Summary)

---

## 🧱 Estrutura do projeto
```
src/main/java/fiap/com/br/bgames
├── controller
│ ├── CategoryController
│ ├── DeveloperController
│ └── GameController
├── dto
│ ├── CategoryRequest / Response
│ ├── DeveloperRequest / Response
│ └── GameRequest / Response
├── entity
│ ├── Category
│ ├── Developer
│ └── Game
├── repository
│ ├── CategoryRepository
│ ├── DeveloperRepository
│ └── GameRepository
├── service
│ ├── CategoryService
│ ├── DeveloperService
│ └── GameService
├── summary
│ ├── CategorySummary
│ ├── DeveloperSummary
│ └── GameSummary
├── validation
│ ├── ValidationHandler
│ ├── ValidPlatform
│ └── PlatformValidator
└── BGamesApplication
```
---

## 🔗 Endpoints principais

### 🎮 Games

| Método | Endpoint |
|------|--------|
| GET | /games |
| GET | /games/{id} |
| POST | /games |
| PUT | /games/{id} |
| DELETE | /games/{id} |

---

### 🔎 Filtros (Games)

| Endpoint |
|--------|
| /games/search?name= |
| /games/by-platform?platform= |
| /games/by-developer?name= |
| /games/by-category?name= |
| /games/released-after?date= |
| /games/summary?name= |
| /games?page=0&size=5 |
| /games?page=0&size=5&sort=name,asc |
---

### 🏢 Developers

| Método | Endpoint |
|------|--------|
| GET | /developers |
| GET | /developers/{id} |
| POST | /developers |
| PUT | /developers/{id} |
| DELETE | /developers/{id} |
| GET | /developers/search?name= |

---

### 🏷️ Categories

| Método | Endpoint |
|------|--------|
| GET | /categories |
| GET | /categories/{id} |
| POST | /categories |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |
| GET | /categories/search?name= |

---

## 📥 Exemplos de requisição(Siga a Ordem)

### Criar Category

```json
{
  "name": "Horror",
  "description": "Jogos de terror com atmosfera tensa",
  "active": true
}
```

### Criar Developer
```json
{
  "name": "Behaviour Interactive",
  "foundedDate": "1992-01-01",
  "active": true
}
```

### Criar Game
```json
{
  "name": "Dead by Daylight",
  "platform": "PC",
  "releaseDate": "2016-06-14",
  "developer": { "id": 1 },
  "categories": [
    { "id": 1 }
  ]
}
```

## ⚙️ Como executar o projeto

### 1. Clonar repositório
git clone https://github.com/biribillidev/BGames.git

### 2. Entrar na pasta
cd BGames

### 3. Rodar aplicação
mvn spring-boot:run
