package io.github.cutepet.labrador.japidocs.codegenerator.java;

import io.github.cutepet.labrador.japidocs.codegenerator.TemplateProvider;

import java.io.IOException;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JavaTemplateProvider {

    public String provideTemplateForName(String templateName) throws IOException {
    	return TemplateProvider.provideTemplateForName(templateName);
    }
    
}
