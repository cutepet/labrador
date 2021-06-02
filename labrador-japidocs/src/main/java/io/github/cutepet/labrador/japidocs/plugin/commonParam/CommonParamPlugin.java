package io.github.cutepet.labrador.japidocs.plugin.commonParam;

import io.github.cutepet.labrador.japidocs.DocContext;
import io.github.cutepet.labrador.japidocs.IPluginSupport;
import io.github.cutepet.labrador.japidocs.doc.HtmlDocGenerator;
import io.github.cutepet.labrador.japidocs.parser.ControllerNode;
import io.github.cutepet.labrador.japidocs.parser.ParamNode;
import io.github.cutepet.labrador.japidocs.parser.RequestNode;
import io.github.cutepet.labrador.japidocs.util.CacheUtils;

import java.util.List;

/**
 * 公共Param配置类接口
 * @author cutepets
 */
public class CommonParamPlugin implements IPluginSupport {
    @Override
    public void execute(HtmlDocGenerator docGenerator) {
        //如果存在公共参数时，将公共参数加入每个接口文档中
        List<ControllerNode> controllerNodeList = docGenerator.getControllerNodeList();
        for (ControllerNode controllerNode : controllerNodeList) {
            List<RequestNode> requestNodes = controllerNode.getRequestNodes();
            for (RequestNode requestNode : requestNodes) {
                List<ParamNode> paramNodes = requestNode.getParamNodes();
                List<ParamNode> commonParamNodes = CommonParam.getParamNodeList();
                for (ParamNode commonParamNode : commonParamNodes) {
                    paramNodes.add(commonParamNode);
                }
            }
        }
        DocContext.setControllerNodeList(docGenerator.getControllerNodeList());
        docGenerator.generateDocs();
        CacheUtils.saveControllerNodes(docGenerator.getControllerNodeList());
    }
}
