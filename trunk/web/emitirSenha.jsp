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
<link rel="stylesheet" type="text/css" href="estilo.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Emiss�o de senha</title>
</head>

<body>
<center><h1>Emiss�o de senhas - SISCOFI</h1></center><br/><br/>
<div id="container" align="center">
<html:form action="/emiteSenha.do?metodo=emiteSenha">
  <h2><c:out value="${mensagem}"/></h2>

  <p align="center">
  <label>Selecione o tipo de guich�:  </label>
  
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
