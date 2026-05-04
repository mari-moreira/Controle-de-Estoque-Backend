# Controle-de-Estoque-Backend
Controle de Estoque da Distribuidora Rocha

## 📦 Controle de Estoque Backend

Sistema backend REST para controle de estoque com módulos de Cliente e Fornecedor, desenvolvido com Spring Boot + MySQL.

---

## 🛠️ Tecnologias utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- MySQL 8
- Lombok
- Maven

---

## 📁 Estrutura do projeto

```
Controle-de-Estoque-Backend/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/estoque/
│       │       ├── EstoqueApplication.java       ← Classe principal
│       │       ├── ModuloCliente/
│       │       │   ├── Controller/ClienteController.java
│       │       │   ├── Entity/Cliente.java
│       │       │   ├── Repository/ClienteRepository.java
│       │       │   └── Service/ClienteService.java
│       │       └── ModuloFornecedor/
│       │           ├── Controller/FornecedorController.java
│       │           ├── Entity/Fornecedor.java
│       │           ├── Repository/FornecedorRepository.java
│       │           └── Service/FornecedorService.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [MySQL 8](https://dev.mysql.com/downloads/mysql/)
- [Insomnia](https://insomnia.rest/) para testar os endpoints

---

## 🗄️ Configuração do banco de dados

### 1. Criar o banco de dados

```sql
CREATE DATABASE estoque;
```

### 2. Configurar o `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/estoque
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> ⚠️ Substitua `SUA_SENHA_AQUI` pela sua senha do MySQL.

---

## ▶️ Como rodar o projeto

1. Abra o projeto no IntelliJ
2. Faça o Reload do Maven (botão direito no `pom.xml` → Maven → Reload Project)
3. Copie o `application.properties` para `target/classes`:
```cmd
copy "src\main\resources\application.properties" "target\classes\application.properties"
```
4. Clique com botão direito em `EstoqueApplication.java` → **Run 'EstoqueApplication'**

O projeto estará rodando quando aparecer:
```
Tomcat started on port 8080
Started EstoqueApplication in X seconds
```

---

## 🌐 Testando os endpoints com Insomnia

> Base URL: `http://localhost:8080`
> Todas as requisições com body usam **Body → JSON** no Insomnia

---

### 👤 Clientes

#### ✅ Listar todos os clientes
```
Método: GET
URL: http://localhost:8080/clientes
Body: nenhum
```
Resposta esperada:
```json
[]
```

---

#### ✅ Buscar cliente por ID
```
Método: GET
URL: http://localhost:8080/clientes/1
Body: nenhum
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Maria Silva",
  "cpf": "123.456.789-00",
  "telefone": "(71) 99999-9999",
  "endereco": "Rua das Flores, 123"
}
```

---

#### ✅ Cadastrar cliente
```
Método: POST
URL: http://localhost:8080/clientes
Body (JSON):
```
```json
{
  "nome": "Maria Silva",
  "cpf": "123.456.789-00",
  "telefone": "(71) 99999-9999",
  "endereco": "Rua das Flores, 123"
}
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Maria Silva",
  "cpf": "123.456.789-00",
  "telefone": "(71) 99999-9999",
  "endereco": "Rua das Flores, 123"
}
```

---

#### ✅ Atualizar cliente
```
Método: PUT
URL: http://localhost:8080/clientes/1
Body (JSON):
```
```json
{
  "nome": "Maria Silva Atualizada",
  "cpf": "123.456.789-00",
  "telefone": "(71) 88888-8888",
  "endereco": "Rua Nova, 456"
}
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Maria Silva Atualizada",
  "cpf": "123.456.789-00",
  "telefone": "(71) 88888-8888",
  "endereco": "Rua Nova, 456"
}
```

---

#### ✅ Deletar cliente
```
Método: DELETE
URL: http://localhost:8080/clientes/1
Body: nenhum
```
Resposta esperada: `204 No Content` (sem body)

---

### 🏭 Fornecedores

#### ✅ Listar todos os fornecedores
```
Método: GET
URL: http://localhost:8080/fornecedores
Body: nenhum
```
Resposta esperada:
```json
[]
```

---

#### ✅ Buscar fornecedor por ID
```
Método: GET
URL: http://localhost:8080/fornecedores/1
Body: nenhum
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Fornecedor ABC",
  "cnpj": "12.345.678/0001-99",
  "telefone": "(11) 99999-9999",
  "endereco": "Av. Industrial, 100",
  "cidade": "São Paulo",
  "produtoFornecidoA": "Parafusos",
  "produtoFornecidoB": "Porcas"
}
```

---

#### ✅ Cadastrar fornecedor
```
Método: POST
URL: http://localhost:8080/fornecedores
Body (JSON):
```
```json
{
  "nome": "Fornecedor ABC",
  "cnpj": "12.345.678/0001-99",
  "telefone": "(11) 99999-9999",
  "endereco": "Av. Industrial, 100",
  "cidade": "São Paulo",
  "produtoFornecidoA": "Parafusos",
  "produtoFornecidoB": "Porcas"
}
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Fornecedor ABC",
  "cnpj": "12.345.678/0001-99",
  "telefone": "(11) 99999-9999",
  "endereco": "Av. Industrial, 100",
  "cidade": "São Paulo",
  "produtoFornecidoA": "Parafusos",
  "produtoFornecidoB": "Porcas"
}
```

---

#### ✅ Atualizar fornecedor
```
Método: PUT
URL: http://localhost:8080/fornecedores/1
Body (JSON):
```
```json
{
  "nome": "Fornecedor ABC Atualizado",
  "cnpj": "12.345.678/0001-99",
  "telefone": "(11) 88888-8888",
  "endereco": "Av. Nova, 200",
  "cidade": "Campinas",
  "produtoFornecidoA": "Parafusos",
  "produtoFornecidoB": "Rebites"
}
```
Resposta esperada:
```json
{
  "id": 1,
  "nome": "Fornecedor ABC Atualizado",
  "cnpj": "12.345.678/0001-99",
  "telefone": "(11) 88888-8888",
  "endereco": "Av. Nova, 200",
  "cidade": "Campinas",
  "produtoFornecidoA": "Parafusos",
  "produtoFornecidoB": "Rebites"
}
```

---

#### ✅ Deletar fornecedor
```
Método: DELETE
URL: http://localhost:8080/fornecedores/1
Body: nenhum
```
Resposta esperada: `204 No Content` (sem body)

---

## 🐛 Problemas comuns

### `Failed to configure a DataSource`
Copie o `application.properties` manualmente para `target/classes`:
```cmd
copy "src\main\resources\application.properties" "target\classes\application.properties"
```

### `Access denied for user 'root'`
A senha no `application.properties` está incorreta. Verifique sua senha do MySQL.

### `Cannot resolve symbol 'springframework'`
Faça o Reload do Maven: botão direito no `pom.xml` → Maven → Reload Project.

### `Ambiguous mapping`
Dois controllers estão usando a mesma rota. Verifique o `@RequestMapping` de cada controller.

---

## 📝 O que foi necessário adicionar ao repositório original

O repositório original estava incompleto. Os seguintes itens foram adicionados:

- `pom.xml` com todas as dependências
- Estrutura de pastas `src/main/java/com/estoque/`
- Classe principal `EstoqueApplication.java`
- Arquivo `src/main/resources/application.properties`
- Correção dos `package` e `import` em todos os arquivos Java
- Correção da rota duplicada no `ClienteController.java`