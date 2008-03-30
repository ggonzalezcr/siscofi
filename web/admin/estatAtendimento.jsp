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
		alert("O campo da variação deve ser um inteiro entre 0 e 100!");
	}
	else if(isNaN(min))
		alert("O campo do tempo mínimo deve ser um número real!");
	else if(isNaN(max))
		alert("O campo do tempo máximo deve ser um número real!");
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
<title>estatísticas de atendimento</title>
</head>
<font face="verdana">
<html:form action="/atendimento.do?metodo=salvarAlteracoes">
  <h2>Ajuste dos parâmetros das estatísticas de atendimento</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
  	<p>Porcentagem de variação do tempo médio: <html:text size="2" property="variacao"></html:text>%</p>
  	<p>Tempo máximo de atendimento: <html:text size="10" property="tempoMaximoAtendimento"></html:text></p>
  	<p>Tempo mínimo de atendimento: <html:text size="10" property="tempoMinimoAtendimento"></html:text></p>
  	<p align="center">
	<input class="botao" type="button" onclick="validaCampos()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="cancelar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>