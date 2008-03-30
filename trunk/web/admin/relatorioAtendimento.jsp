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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relat�rio de Atendimento</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<font face="verdana">

<center><h3><c:out value="${mensagem}" /></h3></center>

<center><h1>Relat�rio de Estat�sticas de Atendimentos</h1></center>
<div id="container" align="center">
<center><h1>Relatorio de Atendimentos</h1></center>
<input type="hidden" id=titulo value="<center><h1>Relat�rio de Estat�sticas de Atendimento</h1></center><p align='left'>Per�odo: de <c:out value='${dados.dataInicial}'/> at� <c:out value='${dados.dataFinal}'/>.</p>"> 
<p align="left">Per�odo: de <c:out value="${dados.dataInicial}"/> at� <c:out value="${dados.dataFinal}"/>.</p>
<p align="left">Neste per�odo foram realizados <c:out value="${dados.totalAtendimentos}"/> atendimentos, apresentando os seguintes resultados:</p>
<p align="left">
<br>
<table align="center">
	<tr>
		<td>
			<p align="left"> Tempo M�dio de atendimento  <c:out value="${dados.tempoMedioAtendimento}"/> minutos.
		</td>
	</tr>
	<tr>
		<td>
			<p align="left"> M�dia de Atendimento por Atendente: <c:out value="${dados.mediaAtendente}"/> atendimentos/atendente
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
			<p align="left"> M�dia de Atendimento por Classe: <c:out value="${dados.mediaClasse}"/> atendimentos/classe
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
			<p align="left"> M�dia de Atendimento por Guich�: <c:out value="${dados.mediaGuiche}"/> atendimentos/guich�
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