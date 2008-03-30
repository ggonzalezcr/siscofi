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
 <%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatório de Atendimento</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<font face="verdana">

<center><h3><c:out value="${mensagem}" /></h3></center>

<center><h1>Relatório de Estatísticas de Atendimentos</h1></center>
<div id="container" align="center">
<center><h1>Relatorio de Atendimentos</h1></center>
<input type="hidden" id=titulo value="<center><h1>Relatório de Estatísticas de Atendimento</h1></center><p align='left'>Período: de <c:out value='${dados.dataInicial}'/> até <c:out value='${dados.dataFinal}'/>.</p>"> 
<p align="left">Período: de <c:out value="${dados.dataInicial}"/> até <c:out value="${dados.dataFinal}"/>.</p>
<p align="left">Neste período foram realizados <c:out value="${dados.totalAtendimentos}"/> atendimentos, apresentando os seguintes resultados:</p>
<p align="left">
<br>
<table align="center">
	<tr>
		<td>
			<p align="left"> Tempo Médio de atendimento  <c:out value="${dados.tempoMedioAtendimento}"/> minutos.
		</td>
	</tr>
	<tr>
		<td>
			<p align="left"> Média de Atendimento por Atendente: <c:out value="${dados.mediaAtendente}"/> atendimentos/atendente
		</td>
	</tr>
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/graficoPorAtendente.jpg"   onclick="popupme(this)"></td>
	</tr>
		
</table>
<br>
<table align="center">
	<tr>
		<td>
			<p align="left"> Média de Atendimento por Classe: <c:out value="${dados.mediaClasse}"/> atendimentos/classe
		</td>
	</tr>
	<tr>	
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/graficoPorClasse.jpg"   onclick="popupme(this)"></td>
	</tr>
	
</table>
<br>
<table align="center">
	<tr>
		<td>
			<p align="left"> Média de Atendimento por Guichê: <c:out value="${dados.mediaGuiche}"/> atendimentos/guichê
		</td>
	</tr>
	<tr>
		<td rowspan="6" colspan="1" align="center"><img src="admin/images/graficoPorGuiche.jpg"   onclick="popupme(this)"></td>
	</tr>

</table>

<form method="post" action="relatorio.do?metodo=encaminhaRelatorioAtendimento">
	<p><input class="botao" type="submit" value="voltar"/></p>
</form>

</div>
</font>

<div class="rodape" />
</body>
</html>