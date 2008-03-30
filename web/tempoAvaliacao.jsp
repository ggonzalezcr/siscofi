<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<head>
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coleta de Dados - Tempo M�dio de Avaliacao</title>
<script type="text/javascript">
function cancelar(){
	document.TempoAtendimentoForm.action="tempoAtendimento.do?metodo=coletaDados";
	document.TempoAtendimentoForm.submit();
}
function submeter(){
	if(document.TempoAtendimentoForm.quantidadePessoas.value < 0 || isNaN(document.TempoAtendimentoForm.quantidadePessoas.value)){
		alert("A quantidade de pessoas na entrega n�o pode ser negativa!");
	} else if(document.TempoAtendimentoForm.tempoMedioAtendimento.value < 0.0 || isNaN(document.TempoAtendimentoForm.tempoMedioAtendimento.value)){
		alert("O tempo m�dio para as avalia��es n�o pode ser negativo!");
	} else{
		document.TempoAtendimentoForm.action="tempoatendimento.do?metodo=salvarDadosAtendimento";
		document.TempoAtendimentoForm.submit();
	}
}
</script>

</head>
<body>
<div id="container" align="center">
<html:form action="/entregaTitulo.do?metodo=salvo">
  <h2>Coleta de dados do tempo de Avalia��o do Atendiemnto</h2><br>
  <center><h3><font color="blue"><c:out value="${mensagem}"/></font></h3></center>
<p></p>
  	<p>Quantas pessoas avaliaram o atendimento: <html:text property="quantidadePessoas" size="5" maxlength="5"></html:text></p>
  	<p>Qual � o tempo m�dio para a avalia��o do atendimento: <html:text property="tempoMedioAvaliacao" size="5" maxlength="5"></html:text></p>
  	<p>
	<input class="botao" type="button" onclick="submeter()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="voltar">
	</p>
</html:form>
</div>
</body>
</html:html>