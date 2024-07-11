#API Ciclo Ágil


Essa é uma API para testar o aplicativo de ciclo ágil.

##Requisitos
Baixe e instale o [INTELLIJ](https://www.jetbrains.com/idea/)
Baixe e instale a JDK mais recente [JDK](https://www.oracle.com/java/technologies/downloads/#java8)

### Ferramentas e Tecnologias Utilizadas
Forma de executar os testes: Junit 5

Jeito de verificar os resultados: Junit5/Hamcrest

Linguagem de programação: Java

Simplificar requisições: RestAssured

Relatórios e dependências: Gradle

####Como rodar esse projeto
Clone ou baixe o projeto.

#####A API
"https://pa-ciclo-bff.vercel.app/auth/login"

A API possui os endpoints:

| Método | Endpoint       | Descrição         |
|--------|----------------|-------------------|
| GET    | /auth/login    |                   |
| POST   | /auth/login    | Loga com sucesso  |
| GET    | /auth/login    |                   |
| PUT    | /auth/login    |                   |
| DELETE | /auth/login    |                   |

Exemplo:

<div style="background-color: #ffffff; padding: 10px; border: 1px solid #cccccc;">
    https://pa-ciclo-bff.vercel.app/auth/login

    O usuário deve ser capaz de logar com sucesso!
</div>

Para cadastrar um cliente, vá no POSTMAN e crie um método POST.
O corpo do método POST é um JSON e deve conter:
<div style="background-color: #ffffff; padding: 10px; border: 1px solid #cccccc;">
    {
        "email": "mary@jane.com",
        "password": "Mary@jane1234"
    }
</div>

Para uma visão completa dos códigos de resposta em cada endpoint, enquanto o seviço estiver sendo executado, veja o SWAGGER no endereço: [SWAGGER](https://documenter.getpostman.com/view/33379987/2sA3JM72FJ#87711308-650f-4109-b7fe-5b7fa6eddc46)