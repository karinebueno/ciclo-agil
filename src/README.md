#API Ciclo Ágil


Essa é uma API para testar o aplicativo de ciclo ágil.

##Requisitos
Baixe e instale o [INTELLIJ](https://www.jetbrains.com/idea/)
Baixe e instale a JDK mais recente [JDK](https://www.oracle.com/java/technologies/downloads/#java8)

###Como rodar esse projeto
Clone ou baixe o rpoejto.

####A API
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

Para uma visão completa dos códigos de resposta em cada endpoint, enquanto o seviço estiver sendo executado, veja o SWAGGER no endereço: http://??