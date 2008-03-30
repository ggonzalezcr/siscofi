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

<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Configurando o banco de dados</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
	<br>
	<h2>Alterando configura��es do Banco de Dados</h2><br/><br/>
	<center><h3><font face="verdana" color="red"><c:out value="${Falha}" />
			</font></h3></center><br>
	<center><h3><font face="verdana" color="blue"><c:out value="${OK}" />
			</font></h3></center><br>

<div id="container" align="center">
	<p>
    <html:form action="/adminBD.do?metodo=alteraConfig">

	<table align="center">
		<tr>
			<td>Login: </td>
			<td><html:text property="conexao.login" /></td>
		</tr>
		<tr>
			<td>Senha: </td>
			<td><html:password property="conexao.senha" /></td>
		</tr>
		<tr>
			<td>IP: </td>
			<td><html:text property="conexao.ip" /></td>
		</tr>
		<tr>
			<td>Porta: </td>
			<td><html:text property="conexao.porta" /></td>
		</tr>
	
	</table>
 		<br>
       <center><input class="botao" name="alterar" type="submit"
              width="500" height="500" value="Salvar"/></center>
     </html:form>
     </p> 
              
</div>
	<p>
    <html:form action="/adminBD.do?metodo=testaConexao">
       <center><input class="botao" name="alterar" type="submit"
              width="500" height="500" value="Testa Conexao"/></center>
	</html:form> 
	</p>
	<p>
	<html:form action="/adminBD.do?metodo=voltar">
		<center><input class="botao" type="submit" value="voltar"/></center>
	</html:form>
	</p>
	

<div class="rodape"></div>
</body>
</html>