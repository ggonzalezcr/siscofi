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
<script>
function abrirJanela(){
	window.open("chamaSenha.do?metodo=encaminhaLogin","","width=450,height=350,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no");
}
</script>
</head>
<body>
<br>
<h1>Sistema de Controle de Filas - SISCOFI</h1><br/><br/>
<div id="container" align="center">

	<p>
		<input class="botao" type="button" onclick="window.location='loginEmitir.jsp'" value="Imprimir Senha"/>
    </p>

	<p>
   	<input class="botao" name="painel" type="button" onclick="abrirJanela()"
      			width="500" height="500" value="Chamar Senha"/>
	</p>      
	<p>				   
	<html:form action="/avalia.do?metodo=encaminha">
       <input class="botao" name="avaliar" type="submit"
              width="500" height="500" value="Avalia��o"/>
	</html:form>
	</p>
	<!-- 
	<p>
	<html:form action="/entregaTitulo.do?metodo=coletaDados">
       <input class="botao" name="imprimir" type="submit"
              width="500" height="500" value="Coleta de dados"/>
	</html:form> 
    </p>      
    -->
	<p>
	<html:form action="/adminBD.do?metodo=voltarAdmin">
       <input class="botao" name="imprimir" type="submit"
              width="500" height="500" value="Administra��o"/>
	</html:form>
	</p>
    
</div>
<div class="rodape"></div>
<br><br><br><br><br><br><br><br>
<p align="right"><a href="copyright.htm">Copyright</a><p>
</body>
</html:html>
