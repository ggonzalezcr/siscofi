<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
 Este arquivo � parte do programa Siscofi
 
 Siscofi � um software livre; voc� pode redistribui-lo e/ou
 modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como
 publicada pela Funda��o do Software Livre (FSF); na vers�o 3 da
 Licen�a.
 
 Este programa � distribu�do na esperan�a que possa ser �til,
 mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 MERCADO ou APLICA��O EM PARTICULAR. Veja a
 Licen�a P�blica Geral GNU para maiores detalhes.

 Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 junto com este programa, se n�o, escreva para a Funda��o do Software
 Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 
 Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 -->

<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="core-rt" prefix="c"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Administra��o</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript">
function submeter(){
	document.FormularioForm.action="avalia.do?metodo=salvaAvaliacao";
	document.FormularioForm.submit();
}

function voltar(){
	document.avaliacao.action="avalia.do?metodo=voltar";
	document.avaliacao.submit();
}
function validaRadio(){
	
	<c:set var="j" value="0" scope="page" />
	<logic:iterate id="alternativa" collection="${formulario.alternativas1}" >
		var marcado = false;
		for(i=0; i<5; i++){
			<c:set var="j" value="${j+1}" scope="page" />
			marcado = document.avaliacao.resposta${j}[i].checked || marcado;
		}
		if(!marcado){
			alert("Responda a quest�o " + '${j}' + " para prosseguir a avalia��o!");
			return marcado;
		}
	</logic:iterate>
	
	return true;
	
/*	var elemento = document.getElementById("atalho");
	var raiz = elemento.parentNode;
	alert(raiz.resposta1.value);
	
	for(i = 0; i < 4; i++){
		alert(raiz[i].name);
	}*/
}
</script>
</head>
<body>
<font face="verdana">
<center><font color="blue"><h4>${mensagem}</h4></font></center>
<h2>Formul�rio de avalia��o</h2>
<form method="post" name="avaliacao" action="avalia.do?metodo=salvaAvaliacao">
<input type="hidden" id=atalho value="123">
	<table>

		<tr>
			<td><b>Quest�o 1)</b>${formulario.questao1}</td>
		</tr>
		<tr>
			<td>			
			<c:set var="j" value="0" scope="page" />
			<logic:iterate id="alternativa" collection="${formulario.alternativas1}" >
				<c:set var="j" value="${j +1}" />
				<input type="radio" name="resposta1" value="${j}">${alternativa}&nbsp;</input>
			</logic:iterate>
			</td>
		</tr>
		
				<tr>
			<td><br><b>Quest�o 2)</b>${formulario.questao2}</td>
		</tr>
		<tr>
			<td>
			<c:set var="j" value="0" scope="page" />
			<logic:iterate id="alternativa" collection="${formulario.alternativas2}">
				<c:set var="j" value="${j+1}" scope="page" />
				<input type="radio" name="resposta2" value="${j}">${alternativa}&nbsp;</input>
			</logic:iterate>
			</td>
		</tr>

		<tr>
			<td><br><b>Quest�o 3)</b>${formulario.questao3}</td>
		</tr>
		<tr>
			<td>
			<c:set var="j" value="0" scope="page" />
			<logic:iterate id="alternativa" collection="${formulario.alternativas3}">
				<c:set var="j" value="${j+1}" scope="page" />
				<input type="radio" name="resposta3" value="${j}">${alternativa}&nbsp;</input>
			</logic:iterate>
			</td>
		</tr>

		<tr>
			<td><br><b>Quest�o 4)</b>${formulario.questao4}</td>
		</tr>
		<tr>
			<td>
			<c:set var="j" value="0" scope="page" />
			<logic:iterate id="alternativa" collection="${formulario.alternativas4}">
				<c:set var="j" value="${j+1}" scope="page" />
				<p><input type="radio" name="resposta4" value="${j}">${alternativa}&nbsp;</input></p>
			</logic:iterate>
			</td>
		</tr>

		<tr>
			<td><br><b>Quest�o 5)</b>${formulario.questao5}</td>
		</tr>
		<tr>
			<td>
			<c:set var="j" value="0" scope="page" />
			<logic:iterate id="alternativa" collection="${formulario.alternativas5}">
				<c:set var="j" value="${j+1}" scope="page" />
				<input type="radio" name="resposta5" value="${j}">${alternativa}&nbsp;</input>
			</logic:iterate>
			</td>
		</tr>

		<tr>
			<td><br><b>Quest�o 6)</b>${formulario.questao6}</td>
		</tr>
		<tr>
			<td><textarea name="formulario.resposta6" cols="100" wrap="soft"></textarea></td>
		</tr>

		<tr>
			<td><br><b>Quest�o 7)</b>${formulario.questao7}</td>
		</tr>
		<tr>
			<td><textarea name="formulario.resposta7" cols="100" wrap="soft"></textarea></td>
		</tr>
		
	</table>
	<br>
	<p align="center">
		<input type="submit"  class="botao" value="Salvar" onclick="return validaRadio()"/>
		<input type="button"  class="botao" value="Voltar" onclick="voltar()"/>	
	</p>
	<br>
	<br>
</form> </font>
</body>
</html:html>