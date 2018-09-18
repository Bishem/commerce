package com.mycommerce.client.rest.form;

import org.springframework.http.ResponseEntity;

import com.mycommerce.client.business.binder.bean.CommandeBean;

public class PageCommandeForm {

	private CommandeBean commandeBean;

	public PageCommandeForm() {

	}

	public PageCommandeForm(final ResponseEntity<CommandeBean> commandeAjoutee) {

		this.setCommandeBean(commandeAjoutee.getBody());
	}

	public CommandeBean getCommandeBean() {

		return this.commandeBean;
	}

	private void setCommandeBean(final CommandeBean commandeBean) {

		this.commandeBean = commandeBean;
	}

}
