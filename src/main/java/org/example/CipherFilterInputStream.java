package org.example;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CipherFilterInputStream extends FilterInputStream {

    private final int key;

    public CipherFilterInputStream(InputStream in, int key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (c == -1) return -1;
        return c - key; // дешифрування
    }
}
