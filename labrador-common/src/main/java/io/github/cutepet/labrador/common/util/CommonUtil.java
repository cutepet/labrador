package io.github.cutepet.labrador.common.util;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.util.Properties;

/**
 * 公共工具类
 * @author cutepets
 */
public class CommonUtil {
    /**
     * 获取yml配置
     * @param key
     * @return
     */
    public static String getForYml(String key){
        final Resource init = new ClassPathResource("application.yml");
        final YamlPropertiesFactoryBean initYamlFactory = new YamlPropertiesFactoryBean();
        initYamlFactory.setResources(init);
        final Properties initProperties = initYamlFactory.getObject();
        final String initPath =(String) initProperties.get("spring.profiles.include");
        if(initPath == null || "".equals(initPath)){
            return (String)initProperties.get(key);
        }else {
            final Resource resource = new ClassPathResource("application-"+initPath+".yml");
            final YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            final Properties properties =  yamlFactory.getObject();
            return (String)properties.get(key);
        }
    }
}
