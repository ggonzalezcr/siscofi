/*
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