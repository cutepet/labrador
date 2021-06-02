package io.github.cutepet.labrador.japidocs.codegenerator.java.builder;


import io.github.cutepet.labrador.japidocs.codegenerator.ICodeBuilder;
import io.github.cutepet.labrador.japidocs.codegenerator.model.FieldModel;

/**
 * Created by Darcy https://yedaxia.github.io/
 */
public class JavaGetterBuilder implements ICodeBuilder {

    private String getterTemplate;
    private FieldModel entryFieldModel;

    public JavaGetterBuilder(String getterTemplate, FieldModel entryFieldModel) {
        this.getterTemplate = getterTemplate;
        this.entryFieldModel = entryFieldModel;
    }

    @Override
    public String build() {
        getterTemplate = getterTemplate.replace("${CASE_FIELD_NAME}",entryFieldModel.getCaseFieldName());
        getterTemplate = getterTemplate.replace("${FIELD_NAME}",entryFieldModel.getFieldName());
        getterTemplate = getterTemplate.replace("${FIELD_TYPE}",entryFieldModel.getFieldType());
        getterTemplate = getterTemplate.replace("${REMOTE_FIELD_NAME}",entryFieldModel.getRemoteFieldName());
        return getterTemplate + "\n";
    }

}
