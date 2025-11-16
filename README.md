# ✍️ Document Signing API

Bem-vindo ao meu projeto backend desenvolvido para gerenciar a assinatura eletrônica de documentos, focado em escalabilidade e desacoplamento de regras de negócio.

## 🚀 Sobre o Projeto

O objetivo desta API é permitir que usuários cadastrem e assinem digitalmente documentos. O sistema garante a integridade das assinaturas, verificando a posse do documento e registrando metadados de auditoria como data e hora da assinatura.

Este projeto foi desenvolvido com foco total em **Qualidade de Código** e **Design de Software**, servindo como um estudo prático de arquitetura avançada em Java.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **PostgreSQL**
* **Maven**
* **Spring Boot**

## 🏛️ Arquitetura e Boas Práticas

Este projeto segue rigorosamente os princípios da **Clean Architecture**.

Principais conceitos aplicados:

* **Domain-Centric:** As regras de negócio estão no centro e não dependem de nenhuma biblioteca externa.
* **Rich Domain Model:** As entidades não são apenas dados; elas possuem comportamento e validam suas próprias regras.
* **Repository Pattern:** Uso de Gateways para abstrair a persistência de dados.
* **Injeção de Dependência:** Inversão de controle para manter os Casos de Uso desacoplados das implementações concretas.
* **DTOs (Data Transfer Objects):** Para separar os dados da API dos objetos de domínio.
