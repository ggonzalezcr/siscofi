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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleção de impressora</title>
<script type="text/javascript">
function voltar(){
	document.EmissaoForm.action="admImpressoras.do?metodo=voltar";
	document.EmissaoForm.submit();
}
</script>
</head>
<body>
<font face="verdana" color="blue">
<center><h2>Selecione a impressora que será <br> usada na impressão das senhas:</h2></center><br>
<html:form action="/admImpressoras.do?metodo=selecionaImpressora">
	<center>
	<select name="impressora">
		<c:forEach var="print" items="${ListaDeImpressoras}">
    		<option value="<c:out value="${print}" />"><c:out value="${print}" /></option>
  	    </c:forEach>
	</select>
	<br><br>
	<input type="submit" class="botao" value="Selecionar"/>
	  <input class="botao" type="button" onclick="voltar()" value="voltar"/>
	</center>
   

</html:form>
</font>
</body>
</html:html>