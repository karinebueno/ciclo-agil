#API Ciclo Ágil

Essa é uma API para testar o aplicativo de ciclo ágil.

##Requisitos Baixe e instale o INTELLIJ Baixe e instale a JDK mais recente JDK

Ferramentas e Tecnologias Utilizadas
Forma de executar os testes: Junit 5

Jeito de verificar os resultados: Junit5/Hamcrest

Linguagem de programação: Java

Simplificar requisições: RestAssured

Relatórios e dependências: Gradle

####Como rodar esse projeto Clone ou baixe o projeto.

#####A API "https://pa-ciclo-bff.vercel.app/auth/login"

A API possui os endpoints:

Método	Endpoint	Descrição
GET	/auth/login
POST	/auth/login	Loga com sucesso
GET	/auth/login
PUT	/auth/login
DELETE	/auth/login
Exemplo:

https://pa-ciclo-bff.vercel.app/auth/login
O usuário deve ser capaz de logar com sucesso!
Para cadastrar um cliente, vá no POSTMAN e crie um método POST. O corpo do método POST é um JSON e deve conter:

{ "email": "mary@jane.com", "password": "Mary@jane1234" }
Para uma visão completa dos códigos de resposta em cada endpoint, enquanto o seviço estiver sendo executado, veja o SWAGGER no endereço: SWAGGER