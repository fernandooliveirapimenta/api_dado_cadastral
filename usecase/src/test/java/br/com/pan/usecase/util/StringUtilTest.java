package br.com.pan.usecase.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void normalize() {
        final String valor = StringUtil.normalize("sgjgg99384ééé");
        assertEquals("99384",valor);
    }

    @Test
    public void normalizeNull() {
        final String valor = StringUtil.normalize(null);
        assertNull(valor);
    }
}