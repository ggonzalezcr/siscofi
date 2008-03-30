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
  	<label>Selecione o tipo de guichê:  </label>
  		
	<html:select property="chamaSenha.classe" onchange="mudarClasse()"> 
	    <html:options collection="classes" property="classe" labelProperty="classe" />
 	</html:select><br><br>
 	<font color="blue">Última senha chamada: <c:out value="${atual}"/></font>
 	<br><br>
 		<input class="botao" type="button" onclick="proximo()" value="Proximo"/>
    <br><br>
  		<input class="botao" type="button" onclick="proximoNovamente()" value="Proximo Novamente"/>
  	<br><br><br>
  		Digite a próxima senha:
  		<html:text property="chamaSenha.senhaASerChamada"></html:text><br><br>
  		<input type="button" class="botao" onclick="chamarSenha()" value="Chamar"/>
  		
  </p>
  </font>
</html:form>
  
</body>
</html:html>