## UserRestController

A classe `UserRestController` é um exemplo de um controlador em uma aplicação Spring Boot que lida com requisições relacionadas a usuários em uma API RESTful.

### Endpoints

#### POST /api/users

Cria um novo usuário com base nos dados fornecidos no corpo da solicitação (`@RequestBody`). O objeto `User` é validado usando a anotação `@Valid` para garantir que os campos estejam preenchidos corretamente. O usuário criado é retornado com o código de status HTTP 201 - Created.

Exemplo de requisição:
```http
POST /api/users
Content-Type: application/json

{
  "userName": "john_doe",
  "password": "senhasigilosa",
  "dataNascimento": "1990-05-15"
}
```

#### GET /api/users

Recupera uma lista de todos os usuários cadastrados. Retorna a lista de usuários com o código de status HTTP 200 - OK.

Exemplo de resposta:
```http
GET /api/users
Content-Type: application/json

[
  {
    "id": 1,
    "userName": "john_doe",
    "password": "senhasigilosa",
    "dataNascimento": "1990-05-15"
  },
  {
    "id": 2,
    "userName": "jane_smith",
    "password": "outrasenha",
    "dataNascimento": "1985-10-20"
  }
]
```

#### PUT /api/users/{id}

Atualiza um usuário existente com base no ID fornecido como parâmetro na URL (`@PathVariable`). Os dados atualizados são passados no corpo da requisição (`@RequestBody`). O objeto `User` é validado usando a anotação `@Valid` para garantir que os campos estejam preenchidos corretamente. O usuário atualizado é retornado com o código de status HTTP 200 - OK.

Exemplo de requisição:
```http
PUT /api/users/1
Content-Type: application/json

{
  "userName": "john_doe",
  "password": "novasenha",
  "dataNascimento": "1990-05-15"
}
```

#### DELETE /api/users/{id}

Remove um usuário existente com base no ID fornecido como parâmetro na URL (`@PathVariable`). O usuário é removido e não há corpo de resposta. Retorna o código de status HTTP 204 - No Content.

Exemplo de requisição:
```http
DELETE /api/users/1
```

### Observações

- Certifique-se de importar as classes necessárias.
- A anotação `@Autowired` é usada para obter uma instância da classe `UserService` por meio de injeção de dependência.
- A anotação `@PostMapping`, `@GetMapping`, `@PutMapping` e `@DeleteMapping` são usadas para mapear os métodos aos respectivos verbos HTTP.
- A anotação `@ResponseStatus` é usada para definir o código de status HTTP retornado pelos métodos.

Este é apenas um exemplo e pode precisar ser adaptado de acordo com os requisitos específicos da sua aplicação.
