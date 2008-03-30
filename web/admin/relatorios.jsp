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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administra��o</title>
<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<br>
<font face="verdana">
<h1>Relat�rios - SISCOFI</h1><br/><br/>
	<center><h3><c:out value="${mensagem}" /></h3></center>
<div id="container" align="center">

	<html:form action="/atendimento.do?metodo=encaminhaEstat">
       <input class="botao" type="submit" value="Estat�sticas B�sicas">
	</html:form>

	<html:form action="/relatorio.do?metodo=encaminhaRelatorioAvaliacao">
       <input class="botao" type="submit"
              width="500" height="500" value="Relat�rio de Avalia��o"/>
	</html:form>
	
	<html:form action="/relatorio.do?metodo=encaminhaRelatorioAtendimento">
       <input class="botao" type="submit"
              width="500" height="500" value="Rel. de Atendimento"/>
	</html:form>  
		    
	<form method="post" action="relatorio.do?metodo=voltarAdmin">
		<p><input class="botao" type="submit" value="voltar"/></p>
	</form>
	
</div>
</font>

<div class="rodape"></div>
</body>
</html:html>