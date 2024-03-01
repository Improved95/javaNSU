package org.lab2.readers;

import java.io.InputStream;
import java.util.Map;

public interface FileParser {
    Map<?, ?> parse(InputStream inputStream);
}
