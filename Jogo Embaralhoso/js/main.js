// JavaScript Document

var frutas = ['banana','maçã', 'tomate', 'mamão', 'Abacaxi', 'uva', 'limão', 'acerola', 'laranja', 'goiaba', 'jaca']
var palavra_embaralhada='';
var palavra='';
var resp_jogo='';
$(document).ready(function(){
	proximaRodada();
})


function proximaRodada(){
	palavra = frutas[rand(frutas.length)];
	palavra_embaralhada=embaralhaPalavra(palavra);
	resp_jogo = palavra.toLowerCase();
	$('.scrambled').text(palavra_embaralhada);
	$("#resposta").val('');
}

function rand(n){
	return Math.floor(Math.random()*n);
}

$("#submit").click(function(event){
	event.preventDefault();
	var sResp = $("#resposta");
	var resp_jogador = sResp.val().toLowerCase();
	var usuario = $("#usuario").val().replace(" ", "_");
	if (usuario != ""){
		if (resp_jogador == resp_jogo){
			sResp.addClass('borda-verde');
			insereNoPlacar(usuario,1);
		} else{
			sResp.addClass('borda-vermelha');
			insereNoPlacar(usuario,-1);
		}
	}
	proximaRodada();
}	

);
function embaralhaPalavra(str){
	var embaralhada = '';
	var i = 0;
	str=str.split('');
	while(str.length>0){
        i = str.length * Math.random() << 0;
        embaralhada += str[i];
        str.splice(i,1);
	}
	return embaralhada;
}

function newLine(user,placar){
	var lin = $("<tr>");	
	lin.attr("id",user + "-tr");
	var colUser = $("<td>").text(user);
	colUser.attr("id",user + "-user");
	var colWord = $("<td>").text(placar);
	colWord.attr("id",user + "-word");
	
	colUser.appendTo(lin);
	colWord.appendTo(lin);
	return lin;
}

function insereNoPlacar(usuario,placar){
	var corpoTabela= $(".placar").find("tbody");
	placar = parseInt(placar);
		
	if ($('#'+usuario+'-tr').length){
		var Spontuacao = $('#'+usuario+'-word');
		var pontuacao = Spontuacao.text();
		pontuacao = parseInt(pontuacao);
		pontuacao+=placar;
		Spontuacao.text(pontuacao);
	} else{
		var linha = newLine(usuario,placar);
		corpoTabela.append(linha);
	}
}