package io.github.cutepet.labrador.japidocs.doc;

import io.github.cutepet.labrador.japidocs.parser.ControllerNode;

import java.io.IOException;

/**
 * an interface of build a controller api docs
 *
 * @author yeguozhong yedaxia.github.com
 */
public interface IControllerDocBuilder {

    /**
     * build api docs and return as string
     *
     * @param controllerNode
     * @return
     */
    String buildDoc(ControllerNode controllerNode) throws IOException;

}
