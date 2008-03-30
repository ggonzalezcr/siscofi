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

<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>
<html:html>
<script>
function cancelar(){
	document.EstatisticasForm.action="atendimento.do?metodo=adminEstatisticas";
	document.EstatisticasForm.submit();
}

function validaCampos(){
	var variacao = document.EstatisticasForm.variacao.value;
	var min = document.EstatisticasForm.tempoMinimoAtendimento.value;
	var max = document.EstatisticasForm.tempoMaximoAtendimento.value;
	if(isNaN(variacao) || variacao < 0 || variacao > 100){
		alert("O campo da varia��o deve ser um inteiro entre 0 e 100!");
	}
	else if(isNaN(min))
		alert("O campo do tempo m�nimo deve ser um n�mero real!");
	else if(isNaN(max))
		alert("O campo do tempo m�ximo deve ser um n�mero real!");
	else{
		document.EstatisticasForm.variacao.value = parseInt(variacao);
		submeter();
	}
}

function submeter(){
	document.EstatisticasForm.action="atendimento.do?metodo=salvarAlteracoes";
	document.EstatisticasForm.submit();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>estat�sticas de atendimento</title>
</head>
<font face="verdana">
<html:form action="/atendimento.do?metodo=salvarAlteracoes">
  <h2>Ajuste dos par�metros das estat�sticas de atendimento</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
  	<p>Porcentagem de varia��o do tempo m�dio: <html:text size="2" property="variacao"></html:text>%</p>
  	<p>Tempo m�ximo de atendimento: <html:text size="10" property="tempoMaximoAtendimento"></html:text></p>
  	<p>Tempo m�nimo de atendimento: <html:text size="10" property="tempoMinimoAtendimento"></html:text></p>
  	<p align="center">
	<input class="botao" type="button" onclick="validaCampos()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="cancelar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>