<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<td width="20%">Tempo médio de atendimento</td>
	</c:if>
	<c:if test="${guichesAtivos == 1}"> 
	<td width="20%">Número de guichês ativos</td>
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