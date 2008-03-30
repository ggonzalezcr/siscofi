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
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Gerenciando banco de dados</title>
<script type="text/javascript">

function encaminhaConfig(){
	document.ConfiguracaoBDForm.action="adminBD.do?metodo=encaminhaConfig";
	document.ConfiguracaoBDForm.submit();
}

function submeter(){
	if(confirm("confirma a reinicializa��o do banco de dados?")){
		document.ConfiguracaoBDForm.action="adminBD.do?metodo=resetDB";
		document.ConfiguracaoBDForm.submit();
		return true;
	}
	return false;
}

function voltar(){
	document.ConfiguracaoBDForm.action="adminBD.do?metodo=voltarAdmin";
	document.ConfiguracaoBDForm.submit();
}

</script>

</head>
<body>
<br>
<h2>Gerenciamento do Banco de Dados</h2><br/><br/>
	<center><h3><font face="verdana" color="blue"><c:out value="${OK}" />
			</font></h3></center><br>

<div id="container" align="center">

	<p><input class="botao" type="button" onclick="encaminhaConfig()" value="Alterar Configura��es"/></p>

	<p>
	<html:form action="/adminBD.do?metodo=resetDB">
       <input class="botao" name="reset" type="button" onclick="return submeter()"
              width="500" height="500" value="Reiniciar BD"/>
	</html:form>
	</p>      
	<p><input class="botao" type="button" onclick="voltar()" value="voltar"/></p>
	
</div>
<div class="rodape"></div>

</body>
</html:html>