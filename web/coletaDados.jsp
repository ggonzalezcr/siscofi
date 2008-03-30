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

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sistema de Controle de Filas - SISCOFI</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<br>
<h1>Seção de coleta de dados</h1><br/><br/>
<div id="container" align="center">
	<p>
		<html:form action="/entregaTitulo.do?metodo=encaminharDadosEntrega">
    	   <input class="botao" name="avaliar" type="submit"
              width="500" height="500" value="Entrega de Título"/>
		</html:form>
	</p>      
		<p>
		<html:form action="/entregaTitulo.do?metodo=voltar">
    	   <input class="botao" name="avaliar" type="submit"
              width="500" height="500" value="voltar"/>
		</html:form>
	</p>
</div>
<div class="rodape"></div>
</body>
</html:html>
