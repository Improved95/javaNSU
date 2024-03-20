package org.lab3.resources;

import java.io.InputStream;

public interface ResourcesView /*extends AutoCloseable*/ {
    InputStream getOpenedResource();

    void close() throws Exception;
}
