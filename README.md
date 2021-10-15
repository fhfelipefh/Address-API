<p align="center"><img src="img\logo.png"></p>

<p align="center">https://biblioteca.ibge.gov.br/visualizacao/livros/liv101639.pdf</p>

<p align="center">
  <small>Uma API Rest construida em Spring boot para cadastro de endereços brasileiros fictícios.</small>
</p>
<hr>
#### - Não conhece esses termos? Aqui está :smile::arrow_down:

* **API** ----- Uma API é uma interface capaz de comunicar aplicações e realizar tarefas sem precisar saber como eles foram implementados. 
* **REST** ---- Rest é estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services.
* **Spring** ------ É um framework open source para a plataforma Java e capaz de facilitar a criação de uma API Rest.
* **HTTP** -- HTTP é um protocolo que permite a obtenção de recursos, como documentos HTML. É a base de qualquer troca de dados na Web e um protocolo cliente-servidor, o que significa que as requisições são iniciadas pelo destinatário, geralmente um navegador da Web.

<small>Fonte: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Overview</small>
<hr>

## Como funciona? :mag_right:

### Teste de conexão: 

  Você pode fazer um teste de conexão utilizando o link localhost:8081/addresss e caso o servidor esteja em operação  verá uma página web com a mensagem "Hello, World!".
 
 <img src="img\helloworld.JPG" >
 <hr>
 
 ### Passo 2:
 
  Utilize o software Postman que pode ser encontrado em https://www.postman.com/ o qual será responsavel por fazer as requisições HTTP para o endereço da API na plataforma Heroku. 
  Caso utilize o método GET no endereço localhost:8081/address verá o mesmo resultado do seu navegador, o diferencial é poder utilizar fácilmente os outros métodos entre eles POST,PUT, e DELETE.
  
   <img src="img\postmanget.JPG" >
  <hr>
  
  ### Passo 3: :postbox:
   Você deve Utilizar o método POST para criar um novo endereço ficiticio, o formato utilizado é JSON:

    *Regras:
    - Estado deve conter no máximo duas letras.
    - Cep só pode receber 8 números.

 ```  
    {
     "houseNumber": "80",
     "street": "Rua de Teste",
     "cep": "12345678",
     "city": "PF",
     "state": "RS",
     "country": "BR",
     "type": "HOME"
     }
```
<small>Os Type compatíveis são: "HOME","APARTMENT","COMPANY","GOVERNMENT".
       Caso o esteja tudo bem você verá um body como imagem abaixo contendo um ID. 
</small>

<img src="img\postmanpost.JPG" >
        Os endereços são apagados após muito tempo de inatividade, pode ser necessário criar novos após algumas horas.
<hr>

  ### Passo 4: :dart:
  
  ### Utilize o Postman e use o método GET informando ID do objeto criado no endereço:
  
   #### No link acima o número 1 é o ID do objeto a ser localizado, caso tudo esteja correto irá ver o endereço informado e poderá o consultar o objeto criado enquanto ele existir no Banco de dados, caso o objeto desapareça será necessário criar novamente. 
   
<img src="img\objeto.JPG" >
   
  # Como editar uma informação? método PUT
  - O método de requisição HTTP PUT cria um novo recurso ou subsititui uma representação do recurso de destino com os novos dados.

  ## Utilizando PUT:
   <img src="img\put.JPG" >
   Você pode utilizar um JSON contendo o novo número.
   
   ## Como fazer uma pesquisa por CEP? :mag_right:
   <img src="img\getbycep.JPG" >
   Utilizando o CEP você pode pesquisar inserindo a informação com o método GET na barra de pesquisa usando os valores:
   
   ### https://localhost:8081/address/cep?cep=9999
   
   Onde o número "9999" é o número que você deseja pesquisar irá retornar os endereços com CEPs parecidos com o valor informado, caso use um navegador e o banco de dados possua    varios endereços você pode ver algo parecido com  o exemplo abaixo:
   
   <img src="img\getcepex.JPG">

* **Aviso** ---- Utilize apenas para salvar endereços fictícios.
<hr>
