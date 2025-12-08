# SaaS Lanchonete  
Um sistema SaaS (Software como Serviço) desenvolvido para gerenciar múltiplas lanchonetes de forma isolada (multi-tenancy).  
Cada estabelecimento possui seu próprio espaço seguro para gerenciar pedidos, produtos e usuários.

---

## Tecnologias Utilizadas

### **Backend**
- Java 17+
- Spring Boot 3.x
- Spring Security + JWT Authentication
- Spring Data JPA / Hibernate
- PostgreSQL (via Docker)
- Multi-Tenant (Database Schema per Tenant)
- Lombok
- Maven

### **Infraestrutura**
- Docker / Docker Compose
- PostgreSQL 16

---

## Arquitetura

O projeto segue uma arquitetura **SaaS com multi-tenancy**, onde:

- Cada empresa (lanchonete) é um **Tenant**
- Cada Tenant possui seu **próprio schema no PostgreSQL**
- Durante o login, o sistema identifica o tenant do usuário e sincroniza automaticamente o schema
- Todas as requisições HTTP carregam o tenant no header

