<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--

 Este arquivo é parte do programa Siscofi
 
 Siscofi é um software livre; você pode redistribui-lo e/ou
 modificá-lo dentro dos termos da Licença Pública Geral GNU como
 publicada pela Fundação do Software Livre (FSF); na versão 3 da
 Licença.
 
 Este programa é distribuído na esperança que possa ser útil,
 mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a qualquer
 MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 Licença Pública Geral GNU para maiores detalhes.

 Você deve ter recebido uma cópia da Licença Pública Geral GNU
 junto com este programa, se não, escreva para a Fundação do Software
 Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 
 Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 -->
<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de Avaliação</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script>
	var NAO_HA_ANTERIOR = "Não existe resposta anterior a atual.";
	var NAO_HA_PROXIMO = "Não existe resposta posterior a atual.";
	//array de respostas
	var respostas_06;
	var respostas_07;
	//posicao dos array
	var posicaoResp06 = -1;
	var posicaoResp07 = -1;
	//Carrega num array as respostas para as perguntas 06 e 07
	function carregar(){
		carregar06("respostas_06");
		carregar07("respostas_07");
	}
	
	//Carrega num array as respostas para as perguntas 06
	function carregar06(id){
		var elemento = document.getElementById("respostas06");
		respostas_06 = new Array(elemento.length);
		for(k = 0; k < elemento.length; k++){
			respostas_06[k] = elemento.options[k].value;
		}
		elemento.parentNode.removeChild(elemento);
		proximo6(posicaoResp06);
	}
	
	//Carrega num array as respostas para as perguntas 07
	function carregar07(id){
		var elemento = document.getElementById("respostas07");
		respostas_07 = new Array(elemento.length);
		for(k = 0; k < elemento.length; k++){
			respostas_07[k] = elemento.options[k].value;
		}
		elemento.parentNode.removeChild(elemento);
		proximo7(posicaoResp07);
	}
	
	//Avança uma posição em um dos arrays
	function proximo6(){
		soma6(1);
		exibir6();
	}
	
	//Retrocede uma posição em um dos arrays
	function anterior6(){
		soma6(-1);
		exibir6();
	}
	
	function exibir6(){
		titulo = document.getElementById("titulo06");
		exibicao = document.getElementById("resp06");
		titulo.innerHTML= "- Resposta " + (posicaoResp06+1) + " de " + respostas_06.length;
		exibicao.value = respostas_06[posicaoResp06];
	}
	
	//Avança uma posição em um dos arrays
	function proximo7(){
		soma7(1);
		exibir7();
	}
	
		//Retrocede uma posição em um dos arrays
	function anterior7(){
		soma7(-1);
		exibir7();
	}
	
	function exibir7(){
		titulo = document.getElementById("titulo07");
		exibicao = document.getElementById("resp07");
		titulo.innerHTML= "- Resposta " + (posicaoResp07+1) + " de " + respostas_07.length;
		exibicao.value = respostas_07[posicaoResp07];
	}
	
	function soma6(valor){
		posicaoResp06 = posicaoResp06 + valor;
		if(posicaoResp06 < 0 ){
			alert(NAO_HA_ANTERIOR);
			posicaoResp06 = 0;
		} else if(posicaoResp06 >= respostas_06.length){
			alert(NAO_HA_PROXIMO);
			posicaoResp06 = respostas_06.length-1;
		}
	}
	
	function soma7(valor){
		posicaoResp07 = posicaoResp07 + valor;
		if(posicaoResp07 < 0 ){
			alert(NAO_HA_ANTERIOR);
			posicaoResp07 = 0;
		} else if(posicaoResp07 >= respostas_07.length){
			alert(NAO_HA_PROXIMO);
			posicaoResp07 = respostas_07.length-1;
		}
	}
	
	function popupme(elemento){
		window.open(elemento.src, "gráfico", "height=395,width=515,status=no,toolbar=no, menubar=no, resizable=no");
	}
	
	function imprimir06(){
		novoDocumento = window.open("", "respostas06", "height=1,width=1,status=no,toolbar=no, menubar=no, resizable=no,scrollbar=yes");
		elemento = document.getElementById("titulo");
		novoDocumento.document.write(elemento.value + "<br> Respostas à questão 06:<br>");
		for(i = 0; i < respostas_06.length; i++){
			novoDocumento.document.write("<p>" + i + " - " + respostas_06[i] + "</p>" );
		}
		novoDocumento.window.print();
		novoDocumento.window.close();
	}
	
	function imprimir07(){
		novoDocumento = window.open("", "respostas07", "height=1,width=1,status=no,toolbar=no, menubar=no, resizable=no,scrollbar=yes");
		elemento = document.getElementById("titulo");
		novoDocumento.document.write(elemento.value + "<br> Respostas à questão 07:<br>");
		for(i = 0; i < respostas_07.length; i++){
			novoDocumento.document.write("<p>" + i + " - " + respostas_07[i] + "</p>" );
		}
		novoDocumento.window.print();
		novoDocumento.window.close();
	}
</script>
</head>
<body onload="carregar()">
<font face="verdana">

<center><h3><c:out value="${mensagem}" /></h3></center>

<center><h1>Relatório de Estatísticas de Avaliação</h1></center>
<div id="container" align="center">
<center><h1>Relatorio de avaliações</h1></center>
<input type="hidden" id=titulo value="<center><h1>Relatório de Estatísticas de Avaliação</h1></center><p align='left'>Período: de <c:out value='${dados.dataInicial}'/> até <c:out value='${dados.dataFinal}'/>.</p>"> 
<p align="left">Período: de <c:out value="${dados.dataInicial}"/> até <c:out value="${dados.dataFinal}"/>.</p>
<p align="left">Neste período foram realizadas <c:out value="${dados.total}"/> avaliações, apresentando os seguintes resultados:</p>
<p align="left">
<br>
<table align="center">
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/grafico01.jpg"  " onclick="popupme(this)"></td>
	</tr>
		
</table>
<br>
<table align="center">
	<tr>	
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/grafico02.jpg"  " onclick="popupme(this)"></td>
	</tr>
	
</table>
<br>
<table align="center">
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/grafico03.jpg"  " onclick="popupme(this)"></td>
	</tr>

</table>
<br>
<table align="center">
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/grafico04.jpg"  " onclick="popupme(this)"></td>
	</tr>

</table>

<br>
<table align="center">
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/grafico05.jpg"  " onclick="popupme(this)"></td>
	</tr>

 </table>
  	
<br>
<br>  	
<p align="left"><b>Questao 06: <c:out value="${dados.questao6}"/></b></p>
	<p align="left" id=titulo06></p><br/>
	<textarea wrap="soft" readonly="true" rows="3" cols="90" id=resp06></textarea>
	</p>
<input type="button" class="botaoSecundario" value="Anterior" onclick="anterior6()"/> 
<input type="button" class="botaoSecundario" value="Próxima" onclick="proximo6()"/>
<input type="button" class="botaoSecundario" value="Imprimir todas" onclick="imprimir06()"/><br/>
<select id=respostas06> 
	<c:forEach var="resposta" items="${dados.respostas06}">
		<option value="<c:out value='${resposta}'/>"></option>
  	</c:forEach>
</select>

<br>
<br>
<p align="left"><b>Questao 07: <c:out value="${dados.questao7}"/></b></p>
	<p align="left" id=titulo07></p><br/>
	<textarea wrap="soft" readonly="true" rows="3" cols="90" id=resp07></textarea>
	</p>
<input type="button" class="botaoSecundario" value="Anterior" onclick="anterior7()"/> 
<input type="button" class="botaoSecundario" value="Próxima" onclick="proximo7()"/>
<input type="button" class="botaoSecundario" value="Imprimir todas" onclick="imprimir07()"/>
<br/>
<select id=respostas07> 
	<c:forEach var="resposta" items="${dados.respostas07}">
		<option value="<c:out value='${resposta}'/>"></option>
  	</c:forEach>
</select>
</p>

<form method="post" action="relatorio.do?metodo=encaminhaRelatorioAvaliacao">
	<p><input class="botao" type="submit" value="voltar"/></p>
</form>

</div>
</font>

<div class="rodape" />
</body>
</html>