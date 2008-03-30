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



<html:html>
<head>

<script>
function cancelar(){
	document.ConfiguracaoPainelForm.action="confPainel.do?metodo=cancelar";
	document.ConfiguracaoPainelForm.submit();
}
function submeter(){
	document.ConfiguracaoPainelForm.action="confPainel.do?metodo=salvar";
	document.ConfiguracaoPainelForm.submit();
}
function default(){
	var confirma = confirm("confirma a restauração das configurações do sistema?");
	if(confirma){
		document.ConfiguracaoPainelForm.action="confPainel.do?metodo=restaurarDefalt"
		document.ConfiguracaoPainelForm.submit();
	}
	
}

function mostrasExemplo(valor, valor2){
	valor2.innerHTML = "<b><span style='color:#" + valor + ";'>Exemplo da cor</span></b>"
}

</script>


<title>SISCOFI</title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo.css" rel="stylesheet" type="text/css">
</head>

<body>
<font face="verdana">
<span align="center">
<p align="center"><strong><font size="5">Configuração do Painel</font></strong></p>
<center><h3><font color="blue"><c:out value="${mensagem}"/></font></h3></center>

<html:form action="/confPainel.do?metodo=salvar">

	<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr align="right">
			<td align=right">
			<input class="b2" type="button" onclick="default()" value="Restaurar Configurações Iniciais">
			<br>	
			<br>
			<br>
			</td>
		</tr>
		
		<tr>
			<td>
			Selecione a cor de fundo do Painel
	    	<html:select property="confPainel.bgColor" onchange="mostrasExemplo(this.value, exemplo)"> 
				<html:options collection="cores" property="valorCor" labelProperty="nomeCor" />
 			</html:select> <span id=exemplo></span><br/>
			<br>
 	<br>
		</tr>
			<tr>
			<td>Mostrar Relógio: <html:select property="confPainel.showClock" size="1" >
				<html:option value="1" >SIM</</html:option>
				<html:option value="0">NAO</</html:option>
				</html:select>
			&nbsp;&nbsp;Selecione a Posição do Relógio: <html:select property="confPainel.clockPosition" size="1" >
				<html:option value="10">ESQUERDA</html:option>
				<html:option value="170">CENTRO</html:option>
				<html:option value="320">DIREITA</html:option>
				</html:select>
				<br>
				<br>
				</td>
		</tr>
		<tr>
			<td>Número de Repetições de exibição da senha: <html:select property="confPainel.repeat" size="1">
				<html:option value="1">01</html:option>
				<html:option value="2">02</html:option>
				<html:option value="3">03</html:option>
				</html:select>
				<br>
				<br>
				</td>
		</tr>
		<tr><td>Destacar a última senha chamada:<html:select property="confPainel.destacarUltimaSenha" size="1" >
				<html:option value="1" >SIM</</html:option>
				<html:option value="0">NAO</</html:option>
				</html:select><br><br></td>
		</tr>
		<tr>
			<td>Tempo exibindo a senha chamada (seg):<html:text property="confPainel.duracaoExibicao" size="2" maxlength="2"/></td>
		</tr>
		</table>
		
		<div id="container" align="center">
		<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center">
			<br>
			<b>Configuração da Mensagem:</b>
			<br>
			<br>
			</td>
		</tr>
		<tr>
			<td>Mensagem: <html:text size="50" property="confPainel.mensagem"/>
				 <br>
				 <br>
			</td>	 
		</tr>	
		<tr>
			<td>	 
			Intervalo (seg): <html:text property="confPainel.interval" size="4" maxlength="4"/>
				<br>
				<br>
				</td>

		</tr>
		<tr>
			<td>Velocidade: <html:select property="confPainel.speed" size="1">
				<html:option value="30">Rápida</html:option>
				<html:option value="70">Média/Rápida</html:option>
				<html:option value="150">Média</html:option>
				<html:option value="300">Média/Lenta</html:option>
				<html:option value="500">Lenta</html:option>
			</html:select>
			&nbsp;&nbsp;Cor:  
	 	<html:select property="confPainel.corMensagem" onchange="mostrasExemplo(this.value, exemplo2)"> 
				<html:options collection="cores" property="valorCor" labelProperty="nomeCor" />
 			</html:select> <span id=exemplo2></span>
			<br>
			<br>
			</td>
		</tr>
	</table>
	</div>
	<table width="70%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr align="center">
			<td>
			<input class="botao" type="submit" onclick="submeter()" value="OK">
			<input class="botao" type="button"   onclick="window.location='admin/administracao.jsp'" value="cancelar">
			</td>
		</tr>
	
	</table>
</html:form>
</font>
</body>
</html:html>