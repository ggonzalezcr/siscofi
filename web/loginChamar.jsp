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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript">
function verifica(){
	if(document.ChamaSenhaForm.guiche.value==""){
		alert("Digite o número do guichê.");
		document.ChamaSenhaForm.guiche.focus();
		return false;
	} else if(isNaN(document.ChamaSenhaForm.guiche.value)){
		alert("O guichê deve ser um número.");
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
<center><h2>Página de autenticação</h2></center><br><br>

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
			<td>Guichê : </td>
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