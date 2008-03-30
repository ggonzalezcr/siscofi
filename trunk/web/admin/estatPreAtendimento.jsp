<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="core" prefix="c" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="estilo.css">
<title>parâmetros pré-atendimento</title>
<script>
function cancelar(){
	document.EstatisticasForm.action="atendimento.do?metodo=adminEstatisticas";
	document.EstatisticasForm.submit();
}

function validaCampos(){
	var fluxo = document.EstatisticasForm.fluxoChegada.value;
	if(isNaN(fluxo)){
		document.EstatisticasForm.fluxoChegada.value = "";
		document.EstatisticasForm.fluxoChegada.focus();
		alert("O campo do fluxo de chegada deve ser um número real!");
	}else{
		document.EstatisticasForm.submit();
	}
}

</script>
</head>
<font face="verdana">
<html:form action="/atendimento.do?metodo=salvaParamPreAtendimento">
  <h2>Ajuste dos Parâmetros Pré-Atendimento</h2>
  <br>
  <center><h3><c:out value="${mensagem}"/></h3></center>
<div id="container" align="center">
  	<p>Fluxo de chegada: <html:text size="2" property="fluxoChegada"></html:text>(eleitores/min)</p>
  	<p align="center">
	<input class="botao" type="button"  onclick="validaCampos()" value="salvar">
	<input class="botao" type="button"  onclick="cancelar()" value="cancelar">
	</p>
  </div>
  </html:form>
 </body>
 </font>
</html:html>