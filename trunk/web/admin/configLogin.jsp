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

<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="core-rt" prefix="c"%>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Configura��o de login</title>
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
<h2>P�gina de configura��o do tipo de login</h2>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nesta p�gina � poss�vel determinar a forma de login usada pelos usu�rios do sistema. Altera��es na forma de login n�o afetam o login do administrador do sistema.</h2>
<html:form action="configLogin.do?metodo=alterarConfig">
	<center>
	<p><center><h3><c:out value="${mensagem}"/></h3></center><br></p>
	<table>
	<tr>
			<td><b>Selecione o tipo de login para os usu�rios:</td>
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