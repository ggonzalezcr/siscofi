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

function mostrasExemplo(valor){
	exemplo.innerHTML = "<b><span style='color:#" + valor + ";'>Exemplo da cor</span></b>"
}

function excluir(){
	var confirma = confirm("confirma a exclusão da classe?");
	if(confirma){
		document.ClasseForm.action="adminClasses.do?metodo=removerClasse";
		document.ClasseForm.submit();
	}
}

function submeter(){
	document.ClasseForm.action="adminClasses.do?metodo=alterarClasse";
	document.ClasseForm.submit();
}

function cancelar(){
	document.ClasseForm.action="adminClasses.do?metodo=cancelar";
	document.ClasseForm.submit();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Edicao de classe de atendimento</title>
</head>
<body >
<font face="verdana">
<html:form action="/adminClasses.do?metodo=alterarClasse">
	
  <h1>Alteração de classe de atendimento</h1>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
  	<p>Classe de atendimento: <html:text property="controle.classe" readonly="true"/></p>
 
  	Escolha a cor de exibição: <br>
  	Nova cor: 
	<html:select property="controle.cor" onchange="mostrasExemplo(this.value)"> 
		<html:options collection="cores" property="valorCor" labelProperty="nomeCor" />
 	</html:select> <span id=exemplo></span><br/>
  	<p>Prefixo:<html:text property="controle.prefixo" size="3" maxlength="3"></html:text></p>
  	<p>Quantidade Inicial: <html:text property="controle.quantidadeInicial" size="3" maxlength="3"> </html:text></p>
  	<p align="center">
	<input class="botao" type="submit" onclick="submeter()" value="Alterar">
	<input class="botao" type="button"  onclick="excluir()" value="Excluir">
	<input class="botao" type="button"  onclick="cancelar()" value="Cancelar">
	</p>
  </div>
  </html:form>
  </font>
 </body>
</html:html>