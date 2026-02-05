# 🏦 Desafio Técnico Itaú — Backend Java

Este projeto é uma **implementação do desafio técnico de backend do Itaú**, desenvolvido em **Java com Spring Boot**.

O objetivo é construir uma **API REST** capaz de receber transações financeiras e calcular estatísticas em tempo real, seguindo rigorosamente as regras definidas no desafio original.

🔗 Desafio de referência:  
https://github.com/feltex/desafio-itau-backend

---

## 📌 Visão Geral

A API permite:

- Registrar transações financeiras
- Calcular estatísticas das transações realizadas nos últimos **60 segundos**
- Limpar todas as transações armazenadas

📌 Todas as transações são mantidas **em memória**, sem uso de banco de dados.

---

## 🚀 Endpoints da API

### POST `/transacao`

Endpoint responsável por registrar uma nova transação.

#### Corpo da requisição:
```json
{
  "valor": 123.45,
  "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

#### Regras de validação:

- valor deve ser maior ou igual a zero
- dataHora não pode estar no futuro
- Todos os campos são obrigatórios
- O formato da data deve seguir o padrão ISO 8601

#### Respostas possíveis:

- `201 Created` — transação registrada com sucesso
- `422 Unprocessable Entity` — transação inválida
- `400 Bad Request` — JSON inválido

---

### GET /estatistica

Retorna as estatísticas das transações realizadas nos últimos segundos passados atráves de um parâmetro chamado `ultimosSegundos`.

#### Exemplo de resposta:
```json
{
  "count": 10,
  "sum": 1234.56,
  "avg": 123.456,
  "min": 12.34,
  "max": 123.56
}
```

##### Caso não existam transações no período, todos os valores retornados serão `0`.

---

### DELETE /transacao

Remove todas as transações armazenadas em memória.

#### Resposta:
- `200 OK` — transações removidas com sucesso

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Swaggerpara documentação
- Maven
- Docker

---

## ▶️ Como executar o projeto
1. Clone o repositório
```sh
git clone https://github.com/AntonioNeto18/Desafio-itau-java.git
cd Desafio-itau-java
```
2. Execute usando docker
```sh
docker-compose up -d  # Inicia a aplicação
docker-compose down   # Para a aplicação
```

---

#### A api ficará disponível em `http://localhost:8080`
#### Acesse a docs do swagger acessando `http://localhost:8080/docs`
