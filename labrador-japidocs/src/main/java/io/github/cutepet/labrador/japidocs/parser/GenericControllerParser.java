package io.github.cutepet.labrador.japidocs.parser;

import io.github.cutepet.labrador.japidocs.annotation.ApiDoc;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import io.github.cutepet.labrador.japidocs.util.Utils;

/**
 *
 * can apply to any java project, but you have to set the request url and method in annotation ${@link ApiDoc} by yourself.
 *
 * @author yeguozhong yedaxia.github.com
 */
public class GenericControllerParser extends AbsControllerParser {

    @Override
    protected void afterHandleMethod(RequestNode requestNode, MethodDeclaration md) {
        md.getAnnotationByName("ApiDoc").ifPresent(an -> {
            if(an instanceof NormalAnnotationExpr){
                ((NormalAnnotationExpr)an).getPairs().forEach(p -> {
                    String n = p.getNameAsString();
                    if(n.equals("url")){
                        requestNode.setUrl(Utils.removeQuotations(p.getValue().toString()));
                    }else if(n.equals("method")){
                        requestNode.addMethod(Utils.removeQuotations(p.getValue().toString()));
                    }
                });
            }
        });
    }

}
