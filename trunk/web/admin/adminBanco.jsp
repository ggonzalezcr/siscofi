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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>Gerenciando banco de dados</title>
<script type="text/javascript">

function encaminhaConfig(){
	document.ConfiguracaoBDForm.action="adminBD.do?metodo=encaminhaConfig";
	document.ConfiguracaoBDForm.submit();
}

function submeter(){
	if(confirm("confirma a reinicialização do banco de dados?")){
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

	<p><input class="botao" type="button" onclick="encaminhaConfig()" value="Alterar Configurações"/></p>

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