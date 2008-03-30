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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administra��o</title>
<link rel="stylesheet" type="text/css" href="estilo.css">

<script type="text/javascript">
function confirmaStart(){
	var confirma = confirm("confirma a inicializa��o do Sistema?");
	return confirma;
	
}

function confirmaFinish(){
	var confirma = confirm("confirma a finaliza��o do Sistema?");
	return confirma;
	
}

function abrirPainel(){
	window.open("admin/painel.html","Painel","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,fullscreen=yes");
}
</script>

</head>
<body>
<br>
<h1>Administra��o - SISCOFI</h1><br/><br/>
	<center><h3><font face="verdana"><c:out value="${mensagem}" /></font></h3></center>
<div id="container" align="center">
	<p>
   	<input class="botao" name="painel" type="button" onclick="abrirPainel()"
      			width="500" height="500" value="Painel de Informa��es"/>
    </p>
	<p>
	<html:form action="/admImpressoras.do?metodo=listaImpressoras">
       <input class="botao" type="submit"
              width="500" height="500" value="Gerenciar Impressora"/>
	</html:form>      
    </p>
    <p>
    <html:form action="/adminClasses.do?metodo=adminClasses">
       <input class="botao" type="submit"
              width="500" height="500" value="Gerenciar Classes"/>
	</html:form> 
	</p>
    <p>
    <html:form action="/atendimento.do?metodo=adminEstatisticas">
       <input class="botao" type="submit"
              width="500" height="500" value="Gerenciar Estatisticas"/>
	</html:form> 
	</p>
	<p>
	<html:form action="/confPainel.do?metodo=encaminhaConfi">
       <input class="botao" type="submit"
              width="500" height="500" value="Gerenciar Painel"/>
	</html:form>
	</p>      
	<html:form action="/adminBD.do?metodo=encaminhaAdmin">
       <input class="botao" type="submit" value="Banco de Dados">
	</html:form>
	
	<html:form action="/startFinish.do?metodo=inicializa">
       <input class="botao" type="submit"   onclick="return confirmaStart()" value="Iniciar Sistema">
	</html:form>
	            
	 <html:form action="/startFinish.do?metodo=finaliza">
       <input class="botao" type="submit" onclick="return confirmaFinish()" value="Finalizar Sistema">
	</html:form>
	
	<html:form action="/relatorio.do?metodo=encaminhaRelatorios">
       <input class="botao" type="submit" value="Relat�rios">
	</html:form>
	
	<html:form action="/configAvaliacao.do?metodo=configAvaliacao">
		<p><input class="botao" type="submit" value="Configurar Avalia��o"/></p>
	</html:form>
	
	<p>				   
	<html:form action="/configLogin.do?metodo=encaminharConfig">
       <input class="botao" name="avaliar" type="submit"
              width="500" height="500" value="Configurar Login"/>
	</html:form>
	</p>
	
	<html:form action="/startFinish.do?metodo=voltar">
		<p><input class="botao" type="submit" value="voltar"/></p>
	</html:form>
</div>

<div class="rodape"></div>
</body>
</html:html>