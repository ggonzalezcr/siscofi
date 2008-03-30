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
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chamada de Senhas</title>
<script type="text/javascript">

function proximo(){
	document.ChamaSenhaForm.action="chamaSenha.do?metodo=proximo";
	document.ChamaSenhaForm.submit();
}

function mudarClasse(){
	document.ChamaSenhaForm.action="chamaSenha.do?metodo=alterarControle";
	document.ChamaSenhaForm.submit();
}

function chamarSenha(){
	document.ChamaSenhaForm.action="chamaSenha.do?metodo=chamarSenha";
	document.ChamaSenhaForm.submit();
}

function proximoNovamente(){
	document.ChamaSenhaForm.action="chamaSenha.do?metodo=proximoNovamente";
	document.ChamaSenhaForm.submit();
}

function logout(){
	document.ChamaSenhaForm.action="chamaSenha.do?metodo=logout";
	document.ChamaSenhaForm.submit();
}
</script>
</head>
<body>
<html:form action="/chamaSenha.do?metodo=chamarSenha">
  <center><h3><font color="red"><c:out value="${mensagem}"/></font></h3></center>
  <p align="right"><u><a onclick="logout()" color="blue">logout</a></u></p>
  <input type="hidden" name="atual" value="<c:out value="${atual}"/>"/>
  <input type="hidden" name="temProximo" value="<c:out value="${temProximo}"/>"/>
  <font face="verdana">
  <p align="center">
  	<label>Selecione o tipo de guich�:  </label>
  		
	<html:select property="chamaSenha.classe" onchange="mudarClasse()"> 
	    <html:options collection="classes" property="classe" labelProperty="classe" />
 	</html:select><br><br>
 	<font color="blue">�ltima senha chamada: <c:out value="${atual}"/></font>
 	<br><br>
 		<input class="botao" type="button" onclick="proximo()" value="Proximo"/>
    <br><br>
  		<input class="botao" type="button" onclick="proximoNovamente()" value="Proximo Novamente"/>
  	<br><br><br>
  		Digite a pr�xima senha:
  		<html:text property="chamaSenha.senhaASerChamada"></html:text><br><br>
  		<input type="button" class="botao" onclick="chamarSenha()" value="Chamar"/>
  		
  </p>
  </font>
</html:form>
  
</body>
</html:html>