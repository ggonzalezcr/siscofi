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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sele��o de impressora</title>
<script type="text/javascript">
function voltar(){
	document.EmissaoForm.action="admImpressoras.do?metodo=voltar";
	document.EmissaoForm.submit();
}
</script>
</head>
<body>
<font face="verdana" color="blue">
<center><h2>Selecione a impressora que ser� <br> usada na impress�o das senhas:</h2></center><br>
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