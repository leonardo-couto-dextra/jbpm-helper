package br.com.dextra.jbpmhelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class Utils {
	
    public static final int byteArrayToInt(byte [] b) {
        return (b[0] << 24)
                + ((b[1] & 0xFF) << 16)
                + ((b[2] & 0xFF) << 8)
                + (b[3] & 0xFF);
    }
    
    
    public static byte[] preload(InputStream stream) throws IOException {
    	byte[] buf = new byte[4096];
    	ByteArrayOutputStream preloaded = new ByteArrayOutputStream();
    	
    	int read;
    	while((read = stream.read(buf)) != -1) {
    		preloaded.write(buf, 0, read);
    	}
    	
    	return preloaded.toByteArray();
    }

}
