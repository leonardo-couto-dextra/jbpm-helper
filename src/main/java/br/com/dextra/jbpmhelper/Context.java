package br.com.dextra.jbpmhelper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

class Context {
	
    public List<Object> data = new ArrayList<Object>();

    @SuppressWarnings("unchecked")
    public void read(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        this.data = (List<Object>) ois.readObject();
    }
}
