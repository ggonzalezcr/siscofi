package testConcorrencia;

/**
 * Este arquivo � parte do programa Siscofi
 * 
 * Siscofi � um software livre; voc� pode redistribui-lo e/ou
 * modific�-lo dentro dos termos da Licen�a P�blica Geral GNU como
 * publicada pela Funda��o do Software Livre (FSF); na vers�o 3 da
 * Licen�a.
 * 
 * Este programa � distribu�do na esperan�a que possa ser �til,
 * mas SEM NENHUMA GARANTIA; sem uma garantia impl�cita de ADEQUA��O a qualquer
 * MERCADO ou APLICA��O EM PARTICULAR. Veja a
 * Licen�a P�blica Geral GNU para maiores detalhes.

 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa, se n�o, escreva para a Funda��o do Software
 * Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Copyright 2007, 2008 Carlos Trajano de Oliveira, Hamon Barros Henriques, Rodrigo Lopes da Silva
 */

import java.util.TimerTask;

import javax.servlet.ServletException;

import controller.Siscofi;
import database.ControleDAO;
import database.bean.Controle;
import exceptions.NotFoundInDBException;

public class ProximaSenhaTask extends TimerTask {
	
	private final String nomeControle;
	private final String guiche;
	private final String ip;

	public ProximaSenhaTask(String nomeControle, String guiche, String ip, String login) {
		this.nomeControle = nomeControle;
		this.guiche = guiche;
		this.ip = ip;
//		Siscofi.getInstance().registraAtendente(guiche, login);
//		Siscofi.getInstance().addGuiche(ip, guiche);
	}

	@Override
	public void run() {
		try {
			ControleDAO dao = new ControleDAO();
			System.out.println(System.currentTimeMillis() + " > guich� " + guiche + " chamadando pr�xima senha da classe " + nomeControle);
			Siscofi siscofi = Siscofi.getInstance();
			Controle ctrl = siscofi.getControleClasse(nomeControle);
			ctrl.setUltimoGuiche(guiche);
			siscofi.chamarProximaSenha(ctrl.getClasse(), ip);
			siscofi.addControle(ctrl);
			dao.writeControle(ctrl);
			System.out.println(ctrl);
			siscofi.addAviso(guiche, ctrl.getSenha(), ctrl.getCor());
		} catch (NotFoundInDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
