package io.github.cutepet.labrador.japidocs.plugin.defaults;

import io.github.cutepet.labrador.japidocs.DocContext;
import io.github.cutepet.labrador.japidocs.IPluginSupport;
import io.github.cutepet.labrador.japidocs.doc.HtmlDocGenerator;
import io.github.cutepet.labrador.japidocs.util.CacheUtils;

/**
 * 默认方法
 */
public class DefaultPlugin implements IPluginSupport {
    @Override
    public void execute(HtmlDocGenerator docGenerator) {
        DocContext.setControllerNodeList(docGenerator.getControllerNodeList());
        docGenerator.generateDocs();
        CacheUtils.saveControllerNodes(docGenerator.getControllerNodeList());
    }
}
