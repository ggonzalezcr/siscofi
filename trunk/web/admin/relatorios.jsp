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
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administração</title>
<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<br>
<font face="verdana">
<h1>Relatórios - SISCOFI</h1><br/><br/>
	<center><h3><c:out value="${mensagem}" /></h3></center>
<div id="container" align="center">

	<html:form action="/atendimento.do?metodo=encaminhaEstat">
       <input class="botao" type="submit" value="Estatísticas Básicas">
	</html:form>

	<html:form action="/relatorio.do?metodo=encaminhaRelatorioAvaliacao">
       <input class="botao" type="submit"
              width="500" height="500" value="Relatório de Avaliação"/>
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