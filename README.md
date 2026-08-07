# 🛠️ Sistema de Ordem de Serviço — Back-end

> Projeto full stack **100% experimental**, criado como laboratório pessoal de aprendizado. Este repositório é a **parte do back-end**: uma API REST em Java + Spring Boot, construída do zero para praticar conceitos de Clean Code, Clean Architecture, boas práticas de desenvolvimento, infraestrutura, CI/CD e deploy em nuvem.

Não é um projeto pensado para produção — é um campo de testes deliberado, onde erros, refatorações e reconstruções fazem parte do processo de aprendizado.

---

## 🎯 Objetivo do projeto

Esse back-end nasceu de uma disciplina extensionista da faculdade, envolvendo um projeto real de migração de dados para uma ISP, e evoluiu para um projeto pessoal de estudo. A ideia central é simples: **usar um domínio de negócio pequeno e conhecido (ordens de serviço) para experimentar, errar e aprender conceitos que vão muito além do CRUD básico.**

Principais frentes de aprendizado:

- 🧱 **Clean Code** — nomes que comunicam intenção, funções pequenas e coesas, código que se lê como prosa.
- 🏛️ **Clean Architecture / Ports & Adapters** — separação real entre domínio, aplicação e infraestrutura, com a regra de dependência sendo respeitada de verdade, não só no nome dos pacotes.
- ☕ **Desenvolvimento Java moderno** — Spring Boot, Spring Data JPA, boas práticas de modelagem de entidades e DTOs, tratamento de exceções.
- 🐳 **Infraestrutura** — containerização com Docker, organização de ambiente de desenvolvimento e produção.
- 🔄 **CI/CD** — pipelines de build, teste e deploy automatizado.
- ☁️ **Cloud** — deploy na AWS, banco de dados gerenciado, boas práticas de configuração de ambiente.

---

## 🧩 Sobre a arquitetura

O projeto segue os princípios de **Clean Architecture / Arquitetura Hexagonal**, com a regra de dependência sempre apontando para dentro:

```
domain/           → regras de negócio puras, sem dependência de framework
├── entities/
├── enums/
├── exceptions/
└── repositories/   → interfaces (ports), sem implementação

application/       → orquestração dos casos de uso
├── services/
├── dto/
└── mapper/

infrastructure/     → detalhes técnicos e implementações concretas
├── adapter/in/web/         → controllers REST
├── adapter/out/persistence/ → implementação de repositórios, entidades JPA
└── config/
```

A camada `domain` não conhece `application` nem `infrastructure`. A camada `application` não conhece detalhes de `infrastructure`. Toda comunicação entre formatos diferentes de dado (DTO ↔ Entidade de domínio ↔ Entidade JPA) passa por **mappers** dedicados, mantendo cada camada isolada e testável de forma independente.

---

## 🚧 Status do projeto

> **Em construção ativa e experimental.** Funcionalidades, estrutura de pastas e até decisões de arquitetura podem mudar conforme novos conceitos são estudados e aplicados.

- [x] CRUD de Ordens de Serviço
- [x] Separação em camadas (Domain / Application / Infrastructure)
- [x] Mapeamento entre DTOs, entidade de domínio e entidade JPA
- [x] Busca por nome do cliente
- [ ] Upload de imagens (foto do produto)
- [ ] Tratamento global de exceções (`@RestControllerAdvice`)
- [ ] Testes unitários e de integração
- [ ] Containerização com Docker
- [ ] Pipeline de CI/CD
- [ ] Deploy na AWS

---

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot** (Web, Data JPA)
- **MySQL** (banco de dados relacional)
- **Maven**

---

## ▶️ Como rodar localmente

```bash
# clonar o repositório
git clone https://github.com/seu-usuario/sistema-ordem-servico-backend.git
cd sistema-ordem-servico-backend

# configurar o banco de dados em application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/ordem_servico
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

# rodar a aplicação
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`.

---

## 🔗 Parte Front-end

Este repositório contém apenas o back-end. A aplicação front-end (mobile, React Native) que consome esta API está em um repositório separado.

---

## 📄 Licença

Projeto de estudo pessoal, sem fins comerciais. Sinta-se à vontade para explorar, sugerir melhorias ou usar como referência de aprendizado.
