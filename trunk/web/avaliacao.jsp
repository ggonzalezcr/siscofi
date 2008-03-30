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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Administração</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<font face="verdana">
<h1>Sistema de Controle de Filas - SISCOFI</h1><br/><br/>
<center><h3><font face="verdana"><c:out value="${mensagem}" /></font></h3></center>
<h2>Avaliação do atendimento</h2>
<div id="container" align="center">

	<html:form action="/avalia.do?metodo=encaminhaAvaliacao">
  		<p>
  		<input class="botao" name="avaliacao" type="submit"  value="Avaliar"/>
   	    </p>
	</html:form>

	<html:form action="/avalia.do?metodo=gerarPDF">
  		<p>
  		<input class="botao" name="imprimir" type="submit"  value="Imprimir"/>
   	    </p>
	</html:form>
	
	<html:form action="/avalia.do?metodo=voltar">
		<p><input class="botao" type="submit" value="voltar"/></p>
	</html:form>
</div>
</font>
</body>
</html:html>
