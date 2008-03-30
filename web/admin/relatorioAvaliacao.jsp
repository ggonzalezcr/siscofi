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
<title>Relatório de Avaliação</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
<script type="text/javascript" src="calendario.js"></script>
</head>
<body>
<font face="verdana">

<center><h3><c:out value="${mensagem}" /></h3></center>

<center><h1>Relatório de Estatísticas de Avaliação</h1></center>
<div id="container" align="center">

<form method="post" action="relatorio.do?metodo=resultadosAvaliacao">
	
	<br>
	
	<center><h2>Selecione as datas para emissão do relatório:</h2></center>
	
	<table align="center">
	<tr>
		<td>Data Inicial: </td>
		<td>
				<select name="diaInicial">
					<option value="01">01</option>

					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>

					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>

					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>

					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>

					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>

				</select> / 			
		
				<select name="mesInicial">
					<option value="01">Jan</option>
					<option value="02">Fev</option>

					<option value="03">Mar</option>
					<option value="04">Abr</option>
					<option value="05">Mai</option>
					<option value="06">Jun</option>
					<option value="07">Jul</option>
					<option value="08">Ago</option>

					<option value="09">Set</option>
					<option value="10">Out</option>
					<option value="11">Nov</option>
					<option value="12">Dez</option>
				</select> / 
				
				<select name="anoInicial">
					<option value="2007">2007</option>
					<option value="2008">2008</option>
					<option value="2009">2009</option>
					<option value="2010">2010</option>
					<option value="2011">2011</option>
					<option value="2012">2012</option>

					<option value="2013">2013</option>
					<option value="2014">2014</option>
					<option value="2015">2015</option>
				</select>  
				
		</td>
	</tr>

	<tr>	
		<td>Data Final:</td>
		<td>
				<select name="diaFinal">
					<option value="01">01</option>

					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>

					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>

					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>

					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>

					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>

				</select> / 			
		
				<select name="mesFinal">
				<option value="01">Jan</option>
					<option value="02">Fev</option>

					<option value="03">Mar</option>
					<option value="04">Abr</option>
					<option value="05">Mai</option>
					<option value="06">Jun</option>
					<option value="07">Jul</option>
					<option value="08">Ago</option>

					<option value="09">Set</option>
					<option value="10">Out</option>
					<option value="11">Nov</option>
					<option value="12">Dez</option>
				</select> / 
				<select name="anoFinal">
					<option value="2007">2007</option>
					<option value="2008">2008</option>
					<option value="2009">2009</option>
					<option value="2010">2010</option>
					<option value="2011">2011</option>
					<option value="2012">2012</option>

					<option value="2013">2013</option>
					<option value="2014">2014</option>
					<option value="2015">2015</option>
				</select> 

				
		</td>
	</tr>
	</table>
	
	<br>
	<input type="submit" class="botao" value="Gerar">
</form>
	<form method="post" action="relatorio.do?metodo=voltar">
		<p><input class="botao" type="submit" value="voltar"/></p>
	</form>

</div>
</font>

<div class="rodape" />
</body>
</html>