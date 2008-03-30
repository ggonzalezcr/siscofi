/*
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
 */
 
function validaNum(total){
	if(total.value <= 0 || total.value >  500){
	    alert("O valor da senha deve estar entre 1 e 500");
		return false;
	}else if(isNaN(total.value)){
	    alert("O valor da senha deve um numero entre 1 e 500");
		return false;
	}else {  	
	  return true;	
	}  
}

function testa(){
	alert(document.EmissaoForm.action);
}

function setAction(total){
	document.EmissaoForm.action="emiteSenha.do?metodo=emiteSenha&total=" + total.value + "";
	document.EmissaoForm.action.submit(); 
}