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
	document.ConfigAvaliacaoForm.action="configAvaliacao.do?metodo=voltar";
	document.ConfigAvaliacaoForm.submit();
}
function submeter(){
	if(document.ConfigAvaliacaoForm.numero.value!="" && document.ConfigAvaliacaoForm.numero.value>0){
		document.ConfigAvaliacaoForm.action="configAvaliacao.do?metodo=salvaConfig";
		document.ConfigAvaliacaoForm.submit();
	} else{
		alert("Forne�a um valor maior que 0 (zero).");
	}
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Configura��o de encaminhamento para avalia��o</title>
</head>
<font face="verdana">
<html:form action="/configAvaliacao.do?metodo=salvaConfig">
  <h2>Configura��o de encaminhamento para avalia��o</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
	<p>Configure de quantos em quantos atendimentos, deve ser encaminhado para avalia��o</p>
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