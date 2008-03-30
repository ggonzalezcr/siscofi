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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administração</title>
<link rel="stylesheet" type="text/css" href="estilo.css">

<script type="text/javascript">
function confirmaStart(){
	var confirma = confirm("confirma a inicialização do Sistema?");
	return confirma;
	
}

function confirmaFinish(){
	var confirma = confirm("confirma a finalização do Sistema?");
	return confirma;
	
}

function abrirPainel(){
	window.open("admin/painel.html","Painel","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,fullscreen=yes");
}
</script>

</head>
<body>
<br>
<h1>Administração - SISCOFI</h1><br/><br/>
	<center><h3><font face="verdana"><c:out value="${mensagem}" /></font></h3></center>
<div id="container" align="center">
	<p>
   	<input class="botao" name="painel" type="button" onclick="abrirPainel()"
      			width="500" height="500" value="Painel de Informações"/>
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
       <input class="botao" type="submit" value="Relatórios">
	</html:form>
	
	<html:form action="/configAvaliacao.do?metodo=configAvaliacao">
		<p><input class="botao" type="submit" value="Configurar Avaliação"/></p>
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