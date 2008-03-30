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

<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sistema de Controle de Filas - SISCOFI</title>
<link rel="stylesheet" type="text/css" href="estilo.css">
</head>
<body>
<br>
<h1>Se��o de coleta de dados</h1><br/><br/>
<div id="container" align="center">
	<p>
		<html:form action="/entregaTitulo.do?metodo=encaminharDadosEntrega">
    	   <input class="botao" name="avaliar" type="submit"
              width="500" height="500" value="Entrega de T�tulo"/>
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
