package io.github.cutepet.labrador.japidocs.parser;

/**
 * a param node corresponds to a request parameter
 */
public class ParamNode {
	private String name;
	private String type;
	private Boolean required = Boolean.TRUE;
	private String description;
	private Boolean jsonBody = Boolean.FALSE;// when true ,the json body set to description
    public ParamNode(){}
    public ParamNode(String name,String type,String description){
        this.name=name;
        this.type=type;
        this.description=description;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getJsonBody() {
		return jsonBody;
	}

	public void setJsonBody(Boolean jsonBody) {
		this.jsonBody = jsonBody;
	}
}
