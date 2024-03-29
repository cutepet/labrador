package io.github.cutepet.labrador.japidocs.doc;

import io.github.cutepet.labrador.japidocs.Resources;
import io.github.cutepet.labrador.japidocs.parser.ControllerNode;
import io.github.cutepet.labrador.japidocs.util.LogUtils;
import io.github.cutepet.labrador.japidocs.util.Utils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.github.cutepet.labrador.japidocs.DocContext;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Html Api docs generator
 *
 * @author yeguozhong yedaxia.github.com
 */
public class HtmlDocGenerator extends AbsDocGenerator {

    public HtmlDocGenerator() {
        super(DocContext.controllerParser(), new HtmlControllerDocBuilder());
    }

    @Override
    void generateIndex(List<ControllerNode> controllerNodeList) {
        FileWriter docFileWriter = null;
        try {
            LogUtils.info("generate index start !!!");
            final Template ctrlTemplate = getIndexTpl();
            final File docFile = new File(DocContext.getDocPath(), "index.html");
            docFileWriter = new FileWriter(docFile);
            Map<String, Object> data = new HashMap<>();
            data.put("controllerNodeList", controllerNodeList);
            data.put("currentApiVersion", DocContext.getCurrentApiVersion());
            data.put("apiVersionList", DocContext.getApiVersionList());
            data.put("projectName", DocContext.getDocsConfig().getProjectName());
            data.put("i18n", DocContext.getI18n());
            ctrlTemplate.process(data, docFileWriter);
            LogUtils.info("generate index done !!!");
        } catch (TemplateException | IOException ex) {
            LogUtils.error("generate index fail !!!", ex);
        } finally {
            Utils.closeSilently(docFileWriter);
        }
        copyCssStyle();
    }

    private void copyCssStyle() {
        try {
            String cssFileName = "style.css";
            File cssFile = new File(DocContext.getDocPath(), cssFileName);
            Utils.writeToDisk(cssFile, Utils.streamToString(Resources.getTemplateFile(cssFileName)));
        } catch (IOException e) {
            LogUtils.error("copyCssStyle fail", e);
        }

    }

    private Template getIndexTpl() throws IOException {
        return Resources.getFreemarkerTemplate("api-index.html.ftl");
    }
}
