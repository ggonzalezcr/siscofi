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
	document.ClasseForm.action="adminClasses.do?metodo=cancelar";
	document.ClasseForm.submit();
}
function submeter(){
	document.ClasseForm.action="adminClasses.do?metodo=criarClasse";
	document.ClasseForm.submit();
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Criar uma classe de atendimento</title>
</head>
<font face="verdana">
<html:form action="/adminClasses.do?metodo=criarClasse">
  <h2>Cria��o de classe de atendimento</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
  	<p>Nome: <html:text property="controle.classe"></html:text></p>
  	<p>
  	Escolha a cor de exibi��o: 
	<html:select property="controle.cor"> 
	    <c:forEach var="cor" items="${cores}"> 
			<option style="color:#<c:out value='${cor.valorCor}'/>;font-family:Arial Black;" value="<c:out value='${cor.valorCor}'/>"><c:out value="${cor.nomeCor}"/></option>
		</c:forEach>
 	</html:select><br>
 	</p>
 	
  	<p>Prefixo: <html:text property="controle.prefixo" size="3" maxlength="3"></html:text></p>

  	<p>Quantidade Inicial: <html:text property="controle.quantidadeInicial" size="3" maxlength="3" value="0"></html:text></p>
  	<p align="center">
	<input class="botao" type="submit" onclick="submeter()" value="criar">
	<input class="botao" type="button"  onclick="cancelar()" value="cancelar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>