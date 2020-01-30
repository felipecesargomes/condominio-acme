# condominio-acme
Projeto para a disciplina Java Web II - Prof. Carlos Barbosa - Requisições Verbos HTTP utilizando relacionamentos @OneToMany

<h2>Alguns Cadastros</h2>

http://localhost:8081/api/condominio <POST>

{
"nome": "Maison d'France",
"email": "maison@apt.com.br",
"telefone": 32131231
}

http://localhost:8081/api/condominio <POST>

{
"nome": "Gomes da Mata",
"email": "gomes@apt.com.br",
"telefone": 23122131
}

http://localhost:8081/api/unidade <POST>

{
"numeroUnidade": "1",
"blocoUnidade": "B"
}

http://localhost:8081/api/unidade <POST>

{
"numeroUnidade": "4",
"blocoUnidade": "C"
}

http://localhost:8081/api/unidade <POST>

{
"numeroUnidade": "10",
"blocoUnidade": "F"
}

<h2>1 - Enviar multa para unidade</h2>

http://localhost:8081/api/multa/unidade/1/condominio/1 <POST>

{
"descricaoMulta": "Multa por barulho demais",
"dataMulta": "22-03-2019",
"valorMulta": 50
}

http://localhost:8081/api/multa/ <GET> -> Listar Todas as multas existentes

<h2>2 - Enviar Avisos p/unidade</h2>

http://localhost:8081/api/aviso/condominio/1 <POST>

{
"descricaoAviso": "Vai ter reuniao no dia 02/02/2020"
}

<h2>3 - Apresentar as unidades com multas</h2>
http://localhost:8081/api/unidadecommulta

<h2>4 - Apresentar as unidades sem multas</h2>
http://localhost:8081/api/unidadesemmulta
