package io.github.cutepet.labrador.japidocs.plugin.commonParam;

import io.github.cutepet.labrador.japidocs.parser.ParamNode;

import java.util.ArrayList;
import java.util.List;

public class CommonParam {
    private static List<ParamNode> paramNodeList = new ArrayList<>();
    private CommonParam(){}
    public static void addParamNode( ParamNode paramNode){
        paramNodeList.add(paramNode);
    }
    public static List<ParamNode> getParamNodeList(){
        return paramNodeList;
    }
}
