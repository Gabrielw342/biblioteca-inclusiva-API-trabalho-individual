📚 Biblioteca Inclusiva - API REST
👨‍🎓 Nome do aluno

Gabriel Wendling

📖 Descrição do projeto e tema escolhido

Este projeto é uma API REST desenvolvida com Spring Boot e PostgreSQL, com o objetivo de simular um sistema de biblioteca inclusiva.

A aplicação permite o gerenciamento de usuários, livros, categorias e empréstimos, incluindo relacionamentos entre entidades e implementação de paginação (paging) para otimização de consultas.

O projeto tem como objetivo aplicar conceitos de backend com Spring Boot, como:

APIs REST
JPA/Hibernate
DTOs
Relacionamentos entre entidades
Validações
Paginação de dados
🛠️ Tecnologias utilizadas
Java 17+
Spring Boot
Spring Web
Spring Data JPA
Hibernate
PostgreSQL
Maven
Swagger
Postman
🧱 Estrutura do projeto
com.biblioteca.bibliotecainclusa
│
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exceptions
├── repository
└── service
🔗 Principais entidades
Usuario
Livro
Categoria
Emprestimo
PerfilAcessibilidade
📌 Relacionamentos
Categoria 1:N Livro
Usuario 1:N Emprestimo
Livro 1:N Emprestimo
Usuario 1:1 PerfilAcessibilidade
(Extra) Curso N:N Aluno
⚙️ Funcionalidades
👤 Usuário
Criar usuário
Listar usuários
Deletar usuário
Listagem com paginação (paging)
📖 Livro
Criar livro
Listar livros
Buscar por ID
Deletar livro
Listagem com paginação (paging)
🗂️ Categoria
Criar categoria
Listar categorias
🔄 Empréstimo
Criar empréstimo
Listar empréstimos
Relacionar usuário e livro
📄 Paginação (Paging)

Este projeto utiliza Spring Data JPA Paging para otimizar listagens.

Exemplos:
GET /usuarios?page=0&size=10
GET /livros?page=0&size=5
📌 Benefícios:
Evita sobrecarga de dados
Melhora performance da API
Controle de quantidade de registros
Melhor integração com frontend
📡 Como executar o projeto
1. Clonar o repositório
git clone https://github.com/seu-usuario/biblioteca-inclusiva-API-trabalho-individual.git
2. Configurar banco PostgreSQL

Criar banco:

biblioteca_inclusiva

Configurar application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_inclusiva
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Rodar o projeto
mvn spring-boot:run
4. Swagger
http://localhost:8080/swagger-ui.html
🔗 Exemplos de endpoints
👤 Usuário

POST

POST /usuarios
{
  "nome": "João",
  "email": "joao@email.com",
  "cpf": "12345678900"
}

GET (Paging)

GET /usuarios?page=0&size=10
📖 Livro

POST

POST /livros
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "categoriaId": 1
}
🗂️ Categoria

POST

POST /categorias
{
  "nome": "Ficção"
}
🔄 Empréstimo

POST

POST /emprestimos
{
  "usuarioId": 1,
  "livroId": 1,
  "dataEmprestimo": "2026-05-21",
  "dataDevolucao": "2026-05-30"
}
🧪 Testes

Todos os testes foram realizados utilizando o Postman, incluindo:

CRUD completo
Relacionamentos
Validações
Paginação (Paging)
👨‍💻 Autor

Gabriel Wendling
(e muitos videos do youtube sobre api)
Projeto acadêmico - API REST com Spring Boot
