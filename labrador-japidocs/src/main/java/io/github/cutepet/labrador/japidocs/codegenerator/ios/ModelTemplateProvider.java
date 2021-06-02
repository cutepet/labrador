package io.github.cutepet.labrador.japidocs.codegenerator.ios;

import io.github.cutepet.labrador.japidocs.codegenerator.TemplateProvider;

import java.io.IOException;


public class ModelTemplateProvider {
	
	public String provideTemplateForName(String templateName) throws IOException {
		return TemplateProvider.provideTemplateForName(templateName);
    }

}
