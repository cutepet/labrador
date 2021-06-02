package io.github.cutepet.labrador.japidocs.plugin.markdown;

import io.github.cutepet.labrador.japidocs.DocContext;
import io.github.cutepet.labrador.japidocs.IPluginSupport;
import io.github.cutepet.labrador.japidocs.Resources;
import io.github.cutepet.labrador.japidocs.doc.HtmlDocGenerator;
import io.github.cutepet.labrador.japidocs.util.Utils;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * export doc as markdown plugin
 *
 * @author yeguozhong yedaxia.github.com
 */
public class MarkdownDocPlugin implements IPluginSupport {
    private Template getDocTpl() throws IOException {
        return Resources.getFreemarkerTemplate("api-doc.md.ftl");
    }

    @Override
    public void execute(HtmlDocGenerator docGenerator) {
        FileWriter docFileWriter = null;
        try {
            final Template ctrlTemplate = getDocTpl();
            final String docFileName = String.format("%s-%s-api-docs.md",  DocContext.getDocsConfig().getProjectName(), DocContext.getDocsConfig().getApiVersion());
            final File docFile = new File(DocContext.getDocPath(), docFileName);
            docFileWriter = new FileWriter(docFile);
            Map<String, Object> data = new HashMap<>();
            data.put("controllerNodes", docGenerator.getControllerNodeList());
            data.put("currentApiVersion", DocContext.getCurrentApiVersion());
            data.put("projectName", DocContext.getDocsConfig().getProjectName());
            data.put("i18n", DocContext.getI18n());
            ctrlTemplate.process(data, docFileWriter);
        } catch (TemplateException | IOException ex) {
            ex.printStackTrace();
        } finally {
            Utils.closeSilently(docFileWriter);
        }
    }
}
