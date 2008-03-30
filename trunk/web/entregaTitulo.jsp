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
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entrega de títulos</title>
<script type="text/javascript">
function cancelar(){
	document.EntregaTituloForm.action="entregaTitulo.do?metodo=coletaDados";
	document.EntregaTituloForm.submit();
}
function submeter(){
	if(document.EntregaTituloForm.quantidadePessoas.value < 0 || isNaN(document.EntregaTituloForm.quantidadePessoas.value)){
		alert("A quantidade de pessoas na entrega não pode ser negativa!");
	} else if(document.EntregaTituloForm.tempoMedioEntrega.value < 0.0 || isNaN(document.EntregaTituloForm.tempoMedioEntrega.value)){
		alert("O tempo médio para entrega de títulos não pode ser negativo!");
	} else{
		document.EntregaTituloForm.action="entregaTitulo.do?metodo=salvarDadosEntrega";
		document.EntregaTituloForm.submit();
	}
}
</script>
</head>
<body>
<div id="container" align="center">
<html:form action="/entregaTitulo.do?metodo=salvo">
  <h2>Coleta de dados da entrega de títulos</h2><br>
  <center><h3><font color="blue"><c:out value="${mensagem}"/></font></h3></center>
<p></p>
  	<p>Quantas pessoas há na entrega de título: <html:text property="quantidadePessoas" size="5" maxlength="5"></html:text></p>
  	<p>Qual é o tempo médio para a entrega de títulos: <html:text property="tempoMedioEntrega" size="5" maxlength="5"></html:text></p>
  	<p>
	<input class="botao" type="button" onclick="submeter()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="voltar">
	</p>
</html:form>
</div>
</body>
</html:html>