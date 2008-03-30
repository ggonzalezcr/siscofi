<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
 
<%@page import="coletaDados.MonitoramentoCentral"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monitoramento de Centrais</title>
</head>
<body>
<html:form action="/monitoramento.do?metodo=listaDadosMonitoramento">
<table border="2" bordercolor="black" CELLPADDING=5>
	<tr>
	
	<td width="20%">Classes</td>
	<c:if test="${atendimentos == 1}"> 
	<td width="20%">Quantidade de atendimentos</td>
	</c:if>
	<c:if test="${senhas == 1}"> 
	<td width="20%">Senhas a Serem Atendidas</td>
	</c:if>
	<c:if test="${tempoMedio == 1}"> 
	<td width="20%">Tempo m�dio de atendimento</td>
	</c:if>
	<c:if test="${guichesAtivos == 1}"> 
	<td width="20%">N�mero de guich�s ativos</td>
	</c:if>
	</tr>
	<c:forEach var="monitoramentos" items="${monit}">
	<tr>
		<td>
		<c:out value="${monitoramentos.classeAtendimento}" /></td>
		<c:if test="${atendimentos == 1}">
			<td>
			<c:out value="${monitoramentos.atendimentos}" />
			</td>	 
		</c:if>
		
		<c:if test="${senhas == 1}">
			<td>
			<c:out value="${monitoramentos.senhasASeremAtendidas}" />
			</td>	 
		</c:if>
		
		<c:if test="${tempoMedio == 1}">
			<td>
			<c:out value="${monitoramentos.tempoMedioAtendimento}" /> min
			</td>	 
		</c:if>
		
		<c:if test="${guichesAtivos == 1}">
			<td>
			<c:out value="${monitoramentos.guichesAtivos}" />
			</td>	 
		</c:if>
		
	</tr>
		
	</c:forEach>
	<tr>
	<td>Total</td>
	
	<c:if test="${atendimentos == 1}"> 
	<td width="20%"><c:out value="${totais.totalAtendimentos}"/></td>
	</c:if>
	
	<c:if test="${senhas == 1}"> 
	<td width="20%"><c:out value="${totais.totalSenhasASeremAtendidas}"/></td>
	</c:if>
	
	<c:if test="${tempoMedio == 1}"> 
	<td width="20%"><c:out value="${totais.totalTempoMedio}"/> min</td>
	</c:if>
	
	<c:if test="${guichesAtivos == 1}"> 
	<td width="20%"><c:out value="${totais.totalGuichesAtivos}"/></td>
	</c:if>
	
	</tr>
</table>

</html:form>

</body>
</html>