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

<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="core-rt" prefix="c"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Configuração de login</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript">
function submeter(){
	document.ConfigLoginForm.action="configLogin.do?metodo=alterarConfig";
	document.ConfigLoginForm.submit();
}

function voltar(){
	document.ConfigLoginForm.action="configLogin.do?metodo=voltar";
	document.ConfigLoginForm.submit();
}
</script>
</head>
<body>
<font face="verdana">
<div id="container" align="center">
<h2>Página de configuração do tipo de login</h2>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nesta página é possível determinar a forma de login usada pelos usuários do sistema. Alterações na forma de login não afetam o login do administrador do sistema.</h2>
<html:form action="configLogin.do?metodo=alterarConfig">
	<center>
	<p><center><h3><c:out value="${mensagem}"/></h3></center><br></p>
	<table>
	<tr>
			<td><b>Selecione o tipo de login para os usuários:</td>
		</tr>
			<c:forEach var="alternativa" items="${tipos}">
				<tr>
					<td>
						<c:if test="${tipoAtual == alternativa}">
							<input type="radio" name="tipoLogin" value="${alternativa}" checked>${alternativa}</input>
						</c:if>
						<c:if test="${tipoAtual != alternativa}">
							<input type="radio" name="tipoLogin" value="${alternativa}" >${alternativa}</input>
						</c:if>
					</td>
				</tr>
			</c:forEach>
	</table>
	</center>
	<br>
	<p align="center">
		<input type="button"  class="botao" value="Alterar" onclick="submeter()"/>
		<input type="button"  class="botao" value="Voltar" onclick="voltar()"/>	
	</p>
	<br>
</html:form> </font>
</div>
</body>
</html:html>