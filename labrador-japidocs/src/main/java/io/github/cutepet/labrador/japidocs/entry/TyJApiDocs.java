package io.github.cutepet.labrador.japidocs.entry;
import io.github.cutepet.labrador.japidocs.parser.ParamNode;
import io.github.cutepet.labrador.japidocs.plugin.commonParam.CommonParam;
import io.github.cutepet.labrador.japidocs.util.HtmlDocsUtil;
import org.springframework.stereotype.Component;

/**
 * JApiDocs类
 * @author cutepets
 */
@Component
public class TyJApiDocs{
    private TyJApiDocs(){}
    public static void run(){
        HtmlDocsUtil.BuildHtmlDocs();
    }
    public  static void addParamNode(ParamNode paramNode){
        CommonParam.addParamNode(paramNode);
    }
}
