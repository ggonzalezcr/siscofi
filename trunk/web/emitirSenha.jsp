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
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Emissão de senha</title>
</head>

<body>
<center><h1>Emissão de senhas - SISCOFI</h1></center><br/><br/>
<div id="container" align="center">
<html:form action="/emiteSenha.do?metodo=emiteSenha">
  <h2><c:out value="${mensagem}"/></h2>

  <p align="center">
  <label>Selecione o tipo de guichê:  </label>
  
	<html:select property="emissao.classe"> 
		<html:options collection="classes" property="classe" labelProperty="classe" />
 	</html:select>
 
  </p>
  
  <p align="center">
  <label>Quantas senhas deseja emitir? </label>
 
 	 <html:text maxlength="3" size="3" property="emissao.total" /> 
	 
  </p>
  <p>&nbsp;</p>
  
  <p align="center">
  <input type="submit" class="botao" value="Emitir"/>
  <input class="botao" type="button" onclick="window.location='index.jsp'" value="voltar"/>
  </p>
  <br>
</html:form>
 </div>
</body>
</html:html>
