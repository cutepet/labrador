package io.github.cutepet.labrador.japidocs;

import io.github.cutepet.labrador.japidocs.doc.HtmlDocGenerator;

/**
 * an plugin interface, please feel free to  to do what ever you want.
 *
 * @author yeguozhong yedaxia.github.com
 */
public interface IPluginSupport {

    /**
     *
     * @param docGenerator
     */
     void execute(HtmlDocGenerator docGenerator);
}
