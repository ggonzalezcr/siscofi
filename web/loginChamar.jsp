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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript">
function verifica(){
	if(document.ChamaSenhaForm.guiche.value==""){
		alert("Digite o n�mero do guich�.");
		document.ChamaSenhaForm.guiche.focus();
		return false;
	} else if(isNaN(document.ChamaSenhaForm.guiche.value)){
		alert("O guich� deve ser um n�mero.");
		document.ChamaSenhaForm.guiche.value="";
		document.ChamaSenhaForm.guiche.focus();
		return false;
	}
	return true;
}
</script>
</head>
<html:errors/>
<body>
<font face="Verdana">
<center><h3><font color="red"><c:out value="${mensagem}"/></font></h3></center>
<center><h2>P�gina de autentica��o</h2></center><br><br>

<html:form action="/chamaSenha.do?metodo=autentica" focus="login.login">
	<table align="center">
		<tr>
			<td>Login : </td>
			<td><html:text property="login.login"></html:text></td>
		</tr>
		<tr>
			<td>Senha : </td>
			<td><html:password property="login.password"></html:password></td>
		</tr>
		<tr>
			<td>Guich� : </td>
			<td><html:text property="guiche"></html:text></td>
		</tr>

		<tr>
			<td></td>
			<td><input class="botao" type="submit" value="Enviar" onclick="return verifica()"/></td>
		</tr>
	</table>
</html:form>
</font>
</body>
</html:html>