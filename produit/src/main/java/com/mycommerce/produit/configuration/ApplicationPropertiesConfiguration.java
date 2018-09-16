package com.mycommerce.produit.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my-configs")
public class ApplicationPropertiesConfiguration {

	private Integer limiteDeProduits;

	public Integer getLimiteDeProduits() {

		return this.limiteDeProduits;
	}

	public void setLimiteDeProduits(final Integer limiteDeProduits) {

		this.limiteDeProduits = limiteDeProduits;
	}
}
