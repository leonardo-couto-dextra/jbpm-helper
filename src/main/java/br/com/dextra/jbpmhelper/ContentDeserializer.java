package br.com.dextra.jbpmhelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.drools.core.marshalling.impl.ProtobufMessages;
import org.drools.core.marshalling.impl.ProtobufMessages.Header;
import org.drools.core.marshalling.impl.ProtobufMessages.Header.StrategyIndex;
import org.jbpm.marshalling.impl.JBPMMessages;
import org.jbpm.marshalling.impl.JBPMMessages.Variable;
import org.jbpm.marshalling.impl.JBPMMessages.VariableContainer;

import com.google.protobuf.ByteString;
import com.google.protobuf.ExtensionRegistry;

public class ContentDeserializer {

	private final byte[] content;
	
	public ContentDeserializer(byte[] content) {
		this.content = content;
	}
	
	public ContentDeserializer(String base64) {
		this(DatatypeConverter.parseBase64Binary(base64));
	}

	public Map<String, Object> deserialize() {
		try {
			return unmarshall();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private Map<String, Object> unmarshall() throws IOException, ClassNotFoundException {
		Context context = new Context();

		ByteArrayInputStream stream = new ByteArrayInputStream(this.content);
		ObjectInputStream objStream = new ObjectInputStream(stream);
		
		ExtensionRegistry registry = ExtensionRegistry.newInstance();
		
		Header header = ProtobufMessages.Header.parseFrom(Utils.preload(objStream), registry);
		for (StrategyIndex strategy : header.getStrategyList()) {
			context.read(new ObjectInputStream(strategy.getData().newInput()));
		}
		
        VariableContainer parseFrom = JBPMMessages.VariableContainer.parseFrom(header.getPayload(), registry);
        Map<String, Object> value = unmarshallVariables(context, parseFrom);
        
        return value;
	}

	public Map<String, Object> unmarshallVariables(Context context, VariableContainer container) throws IOException, ClassNotFoundException {
		Map<String, Object> variables = new HashMap<String, Object>();
		if (container.getVariableCount() == 0) {
			return variables;
		}
		
		for (Variable variable : container.getVariableList()) {
			Object value = unmarshallVariable(context, variable);
			variables.put(variable.getName(), value);
		}
		
		return variables;
	}
	
    private Object unmarshallVariable(Context ctx, Variable variable) throws IOException, ClassNotFoundException {
    	ByteString value = variable.getValue();
		if(value == null || value.isEmpty()) return null;
		
		int index = Utils.byteArrayToInt(value.toByteArray());
		return ctx.data.get(index);
    }
    
}
