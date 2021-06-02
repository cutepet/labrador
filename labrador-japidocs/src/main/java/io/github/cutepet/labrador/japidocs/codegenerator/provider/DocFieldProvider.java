package io.github.cutepet.labrador.japidocs.codegenerator.provider;


import io.github.cutepet.labrador.japidocs.parser.ClassNode;
import io.github.cutepet.labrador.japidocs.parser.FieldNode;
import io.github.cutepet.labrador.japidocs.util.Utils;
import io.github.cutepet.labrador.japidocs.codegenerator.IFieldProvider;
import io.github.cutepet.labrador.japidocs.codegenerator.model.FieldModel;

import java.util.ArrayList;

import java.util.List;

public class DocFieldProvider implements IFieldProvider {

	@Override
	public List<FieldModel> provideFields(ClassNode respNode) {
		List<FieldNode>recordNodes = respNode.getChildNodes();
		if(recordNodes == null || recordNodes.isEmpty()){
			return null;
		}
		List<FieldModel> entryFieldList = new ArrayList<>();
		FieldModel entryField;
		for (FieldNode recordNode : recordNodes) {
			entryField = new FieldModel();
			String fieldName = DocFieldHelper.getPrefFieldName(recordNode.getName());
			entryField.setCaseFieldName(Utils.capitalize(fieldName));
			entryField.setFieldName(fieldName);
			entryField.setFieldType(DocFieldHelper.getPrefFieldType(recordNode.getType()));
			entryField.setRemoteFieldName(recordNode.getName());
			entryField.setComment(recordNode.getDescription());
			entryFieldList.add(entryField);
		}
		return entryFieldList;
	}
	
}
