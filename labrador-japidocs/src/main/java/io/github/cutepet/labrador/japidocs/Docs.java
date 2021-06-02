package io.github.cutepet.labrador.japidocs;

import io.github.cutepet.labrador.japidocs.doc.HtmlDocGenerator;
import io.github.cutepet.labrador.japidocs.plugin.rap.RapSupportPlugin;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *  main entrance
 */
@Component
public class Docs {
    private static final String CONFIG_FILE = "docs.com.example.test.config";
    /**
     * build html api docs
     */
    public  static void buildHtmlDocs(DocsConfig config){
        DocContext.init(config);
        HtmlDocGenerator docGenerator = new HtmlDocGenerator();

        DocsConfig docsConfig = DocContext.getDocsConfig();
        if(docsConfig.getRapProjectId() != null && docsConfig.getRapHost() != null){
            IPluginSupport rapPlugin = new RapSupportPlugin();
            rapPlugin.execute(docGenerator);
        }
        for(IPluginSupport plugin: config.getPlugins()){
            plugin.execute(docGenerator);
        }
	}

    /**
     * wrap response into a common structure,don't forget to put responseNode into map.
     *
     * default is:
     *
     * {
     *     code : 0,
     *     data: ${response}
     *     msg: 'success'
     * }
     *
     * @param responseWrapper
     */
	public  void setResponseWrapper(IResponseWrapper responseWrapper){
        DocContext.setResponseWrapper(responseWrapper);
    }

	private  DocsConfig loadProps(){
        try{
            Properties properties = new Properties();
            properties.load(new FileReader(CONFIG_FILE));
            DocsConfig config = new DocsConfig();
            config.projectPath = properties.getProperty("projectPath", null);

            if(config.projectPath == null){
                throw new RuntimeException("projectPath property is needed in the com.example.test.config file.");
            }

            config.docsPath = properties.getProperty("docsPath", null);
            config.resourcePath = properties.getProperty("resourcePath", null);
            config.mvcFramework = properties.getProperty("mvcFramework", "");
            return config;
        }catch (IOException e){
            e.printStackTrace();

            try{
                File configFile = new File(CONFIG_FILE);
                configFile.createNewFile();
            }catch (Exception ex){
                e.printStackTrace();
            }

            throw new RuntimeException("you need to set projectPath property in " + CONFIG_FILE);
        }
    }
}
