# Address-API


<p align="center">
  <small>Uma API Rest construida em Spring boot para cadastro de endereços brasileiros fictícios.</small>
</p>

#### - Não conhece esses termos? Aqui está :smile::arrow_down:

* **API** ----- Uma API é uma interface capaz de comunicar aplicações e realizar tarefas sem precisar saber como eles foram implementados. 
* **REST** ---- Rest é estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services.
* **Spring** ------ É uma framework open source para a plataforma Java e capaz de facilitar a criação de uma API Rest.
* **HTTP** -- HTTP é um protocolo que permite a obtenção de recursos, como documentos HTML. É a base de qualquer troca de dados na Web e um protocolo cliente-servidor, o que significa que as requisições são iniciadas pelo destinatário, geralmente um navegador da Web.

<small>Fonte: https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Overview</small>

## Como funciona? :mag_right:

###Teste de conexão: 

 Você pode fazer um teste de conexão utilizando o link https://addressapiby.herokuapp.com/address/ e caso o servidor esteja em operação verá uma página web com a mensagem "Hello, World!", a API está hospedada na  plataforma Heroku que pode ser acessada em heroku.com. 
 
 ###Passo 2:
 
  Utilize o software Postman que pode ser encontrado em https://www.postman.com/ o qual será responsavel por fazer as requisições HTTP para o endereço da API na plataforma Heroku. 
  Caso utilize o método GET no endereço https://addressapiby.herokuapp.com/address/ verá o mesmo resultado do seu navegador, o diferencial é poder utilizar fácilmente os outros métodos entre eles POST,PUT,PATCH e DELETE.
  
  ###Passo 3:
   Você deve Utilizar o método POST para criar um novo endereço ficiticio no formato JSON:
 ```  
    {
     "houseNumber": "80",
     "street": "Rua de Teste",
     "cep": "99999-999",
     "city": "PF",
     "state": "RS",
     "country": "BR",
     "type": "HOME"
     }
```

    Os atributos são Strings e podem receber letras e números com exceção de "type" que é um ENUM e só pode receber 4 valores (HOME,APARTMENT, COMPANY,GOVERNMENT) isso fará requisições de POST fora desse valores específicos serem negadas. 
    Após clicar em 'send' no Postman a requisição de criação será enviada para a API e irá criar um novo endereço no banco de dados, (os endereços serão apagados ocasionalmente) e você poderá ver o ID do endereço criado Postman e então irá utiliza-lo obter o objeto atribuindo o valor do ID no endereço após a '/' no endereço https://addressapiby.herokuapp.com/address/1 onde ao invés de "1" irá informar o ID ao qual precisa buscar. 

 
