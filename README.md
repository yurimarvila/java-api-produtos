# ☕ API Produtos — Spring Boot REST

API REST completa desenvolvida com Spring Boot para gerenciamento de produtos, com banco de dados PostgreSQL, validação de dados e tratamento de erros profissional.

---

## 🎯 Objetivo

Consolidar os fundamentos de desenvolvimento back-end Java — API REST, JPA, validação e tratamento de erros — construindo uma API real e progressiva, preparando a base para sistemas corporativos com Spring Boot.

---

## 🛠️ Tecnologias

- Java 25 LTS
- Spring Boot 4.1
- PostgreSQL
- JPA / Hibernate
- Bean Validation
- Maven
- Visual Studio Code

---

## 🏗️ Arquitetura do Projeto

```
api-produtos/
└── src/main/java/br/com/banco/api_produtos/
    ├── controller/
    │   └── ProdutoController.java   # Endpoints HTTP — recebe e responde requisições
    ├── service/
    │   └── ProdutoService.java      # Lógica de negócio — cadastrar, buscar, atualizar, deletar
    ├── repository/
    │   └── ProdutoRepository.java   # Acesso ao banco — JpaRepository
    ├── model/
    │   └── Produto.java             # Entidade — mapeada como tabela no banco
    ├── dto/
    │   └── ProdutoDTO.java          # Objeto de transferência — dados recebidos da requisição
    └── exception/
        └── GlobalExceptionHandler.java  # Tratamento centralizado de erros
```

---

## 📝 Etapas de Desenvolvimento

### Etapa 3.1 — API REST em Memória

Estrutura base da API com CRUD completo usando ArrayList em memória.

**Destaques:**

- Controller com 5 endpoints mapeados via anotações Spring
- Service com lógica de negócio isolada
- DTO separando o que o cliente envia do model interno
- Cópia defensiva no retorno da lista

**Conceitos:** `@RestController`, `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestBody`, `@Autowired`

---

### Etapa 3.2 — Banco de Dados com JPA

Substituição do ArrayList pelo PostgreSQL usando Spring Data JPA.

**Destaques:**

- `Produto` anotado como `@Entity` — vira tabela no banco automaticamente
- `ProdutoRepository` herdando `JpaRepository` — sem escrever SQL
- Injeção de dependência com `@Autowired` no lugar de `new`
- H2 em memória para desenvolvimento, PostgreSQL para produção

**Conceitos:** `@Entity`, `@Id`, `@GeneratedValue`, `JpaRepository`, `@Service`, injeção de dependência

---

### Etapa 3.3 — Validação e Tratamento de Erros

Proteção contra dados inválidos com retorno de erros claros e padronizados.

**Destaques:**

- `@NotBlank` no nome — rejeita vazio ou nulo
- `@Positive` no preço e quantidade — rejeita valores negativos
- `@Valid` no controller ativa a validação antes de processar
- `GlobalExceptionHandler` retorna JSON com campo e mensagem de erro

**Conceitos:** Bean Validation, `@Valid`, `@RestControllerAdvice`, `@ExceptionHandler`

---

### Etapa 3.4 — PostgreSQL

Migração do banco em memória para banco de dados real persistente.

**Destaques:**

- Driver PostgreSQL no `pom.xml`
- Configuração de datasource no `application.properties`
- Dados persistem após reinicialização da aplicação
- `ddl-auto=update` cria e atualiza tabelas automaticamente

**Conceitos:** datasource, dialect, persistência real

---

### Etapa 3.5 — Projeto Final

Finalização profissional com status HTTP corretos em todos os endpoints.

**Destaques:**

- `ResponseEntity` com status semânticos: 200, 201, 404
- POST retorna 201 (Created) com o produto criado
- GET/PUT/DELETE por ID retornam 404 quando não encontrado
- API pronta para uso em ambiente real

**Conceitos:** `ResponseEntity`, status HTTP semânticos

---

## 🔌 Endpoints

| Método | URL            | Descrição               | Status de sucesso |
| ------ | -------------- | ----------------------- | ----------------- |
| GET    | /produtos      | Lista todos os produtos | 200               |
| GET    | /produtos/{id} | Busca produto por ID    | 200               |
| POST   | /produtos      | Cadastra novo produto   | 201               |
| PUT    | /produtos/{id} | Atualiza produto        | 200               |
| DELETE | /produtos/{id} | Remove produto          | 200               |

---

## 📋 Exemplos de Requisição

**Cadastrar produto — POST /produtos**

```json
{
  "nome": "Notebook",
  "preco": 3000.0,
  "quantidade": 5
}
```

**Resposta — 201 Created**

```json
{
  "id": 1,
  "nome": "Notebook",
  "preco": 3000.0,
  "quantidade": 5
}
```

**Validação — POST com dados inválidos**

```json
{
  "nome": "",
  "preco": -500.0,
  "quantidade": -3
}
```

**Resposta — 400 Bad Request**

```json
{
  "nome": "Nome é obrigatório",
  "preco": "Preço deve ser positivo",
  "quantidade": "Quantidade deve ser positiva"
}
```

---

## 🚀 Como Executar

**Pré-requisitos:** Java 25, Maven, PostgreSQL

1. Clone o repositório

```bash
git clone https://github.com/yurimarvila/api-produtos.git
```

2. Crie o banco de dados no PostgreSQL

```sql
CREATE DATABASE api_produtos;
```

3. Configure as credenciais em `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/api_produtos
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

4. Execute a aplicação

```bash
./mvnw spring-boot:run
```

5. Acesse `http://localhost:8080/produtos`

---

## 📈 Próximos Passos — Fase 4

- Sistema bancário completo: contas, clientes, transações
- Spring Security + JWT para autenticação
- Relacionamentos JPA (OneToMany, ManyToOne)
- Testes unitários com JUnit + Mockito
- Docker + Docker Compose
- Swagger para documentação
- Deploy em produção

---

## 👨‍💻 Autor

**Yuri Fernandes Marvila** — estudante de Ciência da Computação, focado em desenvolvimento back-end com Java e Spring Boot.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Yuri_Fernandes-blue)](https://www.linkedin.com/in/yuri-fernandes-marvila)
[![GitHub](https://img.shields.io/badge/GitHub-yurimarvila-black)](https://github.com/yurimarvila)
