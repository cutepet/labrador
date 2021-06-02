package io.github.cutepet.labrador.japidocs.util;

import io.github.cutepet.labrador.common.util.CommonUtil;
import io.github.cutepet.labrador.japidocs.Docs;
import io.github.cutepet.labrador.japidocs.DocsConfig;
import io.github.cutepet.labrador.japidocs.plugin.commonParam.CommonParamPlugin;
import io.github.cutepet.labrador.japidocs.plugin.defaults.DefaultPlugin;
import io.github.cutepet.labrador.japidocs.plugin.markdown.MarkdownDocPlugin;

public class HtmlDocsUtil {
    private final static String path = CommonUtil.getForYml("japidocs.path");
    private final static String docsPath = CommonUtil.getForYml("japidocs.docsPath");
    private final static String name = CommonUtil.getForYml("japidocs.name");
    private final static String autoGenerate = CommonUtil.getForYml("japidocs.autoGenerate");
    private final static String plugin = CommonUtil.getForYml("japidocs.plugin");
    public static void BuildHtmlDocs(){
        DocsConfig config = new DocsConfig();
        config.setProjectPath(path); // 项目根目录
        config.setProjectName(name); // 项目名称
        config.setApiVersion("apis");       // 声明该API的版本
        // 生成API 文档所在目录
        if(System.getProperty("os.name").indexOf("Windows")>0){
            config.setDocsPath(path+"\\target\\classes\\static");
        }else {
            config.setDocsPath(path+"/target/classes/static");
        }
        // 配置自动生成
        if("false".equals(autoGenerate)){
            config.setAutoGenerate(Boolean.FALSE);
        }else {
            config.setAutoGenerate(Boolean.TRUE);
        }
        //添加生成插件
        if("Markdown".equals(plugin)) {
            if(docsPath == null || "".equals(docsPath)){
                throw new RuntimeException("docPath不能为空");
            }else {
                config.setDocsPath(docsPath);
                config.addPlugin(new MarkdownDocPlugin());
            }
        }else if("CommonParam".equals(plugin)){
            config.addPlugin(new CommonParamPlugin());
        }else {
            config.addPlugin(new DefaultPlugin());
        }
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }
}
