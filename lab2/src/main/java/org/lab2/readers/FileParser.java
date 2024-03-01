package org.lab2.readers;

import java.io.InputStream;
import java.util.Map;

public interface FileParser<T, K> {
    Map<T, K> parse(InputStream inputStream);
}
