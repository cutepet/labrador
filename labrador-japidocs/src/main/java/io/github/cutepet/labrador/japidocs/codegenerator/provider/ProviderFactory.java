package io.github.cutepet.labrador.japidocs.codegenerator.provider;

import io.github.cutepet.labrador.japidocs.codegenerator.IFieldProvider;

/**
 * Created by user on 2016/12/25.
 */
public class ProviderFactory {

    public static IFieldProvider createProvider(){
        return new DocFieldProvider();
    }
}
