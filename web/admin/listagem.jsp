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
<head>
<script>

function validate(){

	if(document.ClasseForm.classe.value == '')
		alert('N�o h� classes para se alterar!');
	else{
		document.ClasseForm.action="adminClasses.do?metodo=editarClasse";
		document.ClasseForm.submit();	
	}
}

function cancelar(){
	document.ClasseForm.action="adminClasses.do?metodo=cancelar";
	document.ClasseForm.submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Listagem de classes de atendimento</title>
</head>
<body>
<font face="verdana">
<html:form action="/adminClasses.do?metodo=editarClasse">
  <h1>Listagem de classes de atendimento</h1><br/>
  <h2>Selecione a classe de atendimento a ser alterada:</h2>
  <br/>
  <center><h3><c:out value="${mensagem}"/></h3></center>
	<div id="container" align="center">
	<html:select property="classe"> 
	    <c:forEach var="classe" items="${classes}"> 
			<option value="<c:out value='${classe}'/>"><c:out value="${classe}"/></option>
		</c:forEach>
 	</html:select><br/>
  	<p align="center">
	<input class="botao" type="button" onclick="validate()" value="alterar">
	<input class="botao" type="button"  onclick="cancelar()" value="voltar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>