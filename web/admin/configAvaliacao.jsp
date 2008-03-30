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
	document.ConfigAvaliacaoForm.action="configAvaliacao.do?metodo=voltar";
	document.ConfigAvaliacaoForm.submit();
}
function submeter(){
	if(document.ConfigAvaliacaoForm.numero.value!="" && document.ConfigAvaliacaoForm.numero.value>0){
		document.ConfigAvaliacaoForm.action="configAvaliacao.do?metodo=salvaConfig";
		document.ConfigAvaliacaoForm.submit();
	} else{
		alert("Forneça um valor maior que 0 (zero).");
	}
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Configuração de encaminhamento para avaliação</title>
</head>
<font face="verdana">
<html:form action="/configAvaliacao.do?metodo=salvaConfig">
  <h2>Configuração de encaminhamento para avaliação</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
	<p>Configure de quantos em quantos atendimentos, deve ser encaminhado para avaliação</p>
  	<p>Encaminhar 01 a cada : <html:text property="numero"></html:text></p>
  	<p>
	<input class="botao" type="button" onclick="submeter()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="voltar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>