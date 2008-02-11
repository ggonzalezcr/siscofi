package testConcorrencia;

/**
 * Este arquivo é parte do programa Siscofi
 *
 * Siscofi é um software livre; você pode redistribui-lo e/ou
 * modificá-lo dentro dos termos da Licença Pública Geral GNU como
 * publicada pela Fundação do Software Livre (FSF); na versão 3 da
 * Licença.
 *
 * Este programa é distribuído na esperança que possa ser útil,
 * mas SEM NENHUMA GARANTIA; sem uma garantia implícita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a
 * Licença Pública Geral GNU para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU
 * junto com este programa, se não, escreva para a Fundação do Software
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
		Siscofi.getInstance().registraAtendente(guiche, login);
		Siscofi.getInstance().addGuiche(ip, guiche);
	}

	@Override
	public void run() {
		try {
			ControleDAO dao = new ControleDAO();
			System.out.println(System.currentTimeMillis() + " > guich� " + guiche + " chamadando proxima senha da classe " + nomeControle);
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
