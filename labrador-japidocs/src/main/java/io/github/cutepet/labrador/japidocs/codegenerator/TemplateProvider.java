package io.github.cutepet.labrador.japidocs.codegenerator;

import io.github.cutepet.labrador.japidocs.Resources;
import io.github.cutepet.labrador.japidocs.util.Utils;

import java.io.IOException;


public class TemplateProvider {
	public static String provideTemplateForName(String templateName) throws IOException {
		return Utils.streamToString(Resources.getCodeTemplateFile(templateName));
    }
}
