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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Administra��o</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<font face="verdana">
<h1>Sistema de Controle de Filas - SISCOFI</h1><br/><br/>
	<html:form action="/atendimento.do?metodo=encaminhaEstat">
	<h2>Estat�sticas b�sicas de atendimento</h2>
  		<center><table border="2">
  		<tr>
  		 		<td width="50%">Classe de atendimento</td>
  		 		<td width="25%">Atendimentos realizados</td>
  		 		<td width="25%">Atendimentos restantes</td>
	 	</tr>
  		 <c:forEach var="atendimento" items="${atendimentos.listagem}">
  		 	<tr>
  		 		<td><c:out value="${atendimento.classeAtendimento}"/></td>
  		 		<td><c:out value="${atendimento.totalAtendidos}"/></td>
  		 		<td><c:out value="${atendimento.atendimentosRestantes}"/></td>
  		 	</tr>	
			<option style="color:#<c:out value='${cor.valorCor}'/>;font-family:Arial Black;" value="<c:out value='${cor.valorCor}'/>"><c:out value="${cor.nomeCor}"/></option>
		</c:forEach>
  		</table></center>
	</html:form>
	
	<center><html:form action="/relatorio.do?metodo=encaminhaRelatorios">
		<p><input class="botao" type="submit" value="voltar"/></p>
	</html:form></center>
</font>
</body>
</html:html>
