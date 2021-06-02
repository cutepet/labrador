package io.github.cutepet.labrador.japidocs.codegenerator;

import io.github.cutepet.labrador.japidocs.parser.ClassNode;
import io.github.cutepet.labrador.japidocs.codegenerator.model.FieldModel;

import java.util.List;

public interface IFieldProvider {
	/**
	 * get response fields
	 * @param respNode
	 * @return
	 */
	List<FieldModel> provideFields(ClassNode respNode);
}
