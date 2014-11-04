package br.com.dextra.jbpmhelper;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.jbpmhelper.ContentDeserializer;

public class TestContentDeserializer {
	
	private final String content = "rO0ABXoAAAQACgYIBRAEGABK4wcIABJIb3JnLmRyb29"
			+ "scy5jb3JlLm1hcnNoYWxsaW5nLmltcGwuU2VyaWFsaXphYmxlUGxhY2Vob2xkZXJ"
			+ "SZXNvbHZlclN0cmF0ZWd5GpQHrO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIH"
			+ "SHZnHYZ0DAAFJAARzaXpleHAAAAAKdwQAAAAKc3IADmphdmEudXRpbC5EYXRlaGq"
			+ "BAUtZdBkDAAB4cHcI///H4n9fpAB4dAAFVEVzdGV0AA5UaGlhZ28gTWVzc2lhc3Q"
			+ "ABVRlc3RldAADMTIzdAASQXZhbGlhcnNvbGljaXRhY2FvdAAIbm90YXZlaXN0ABN"
			+ "BdmFsaWFyIHNvbGljaXRhY2FvdAAFRkFDVElzcgARamF2YS51dGlsLkhhc2hNYXA"
			+ "FB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAMdwg"
			+ "AAAAQAAAACXQAB2luX2RhdGFzcgA3Y29tLmdvb2dsZS5wcm90b2J1Zi5HZW5lcmF"
			+ "0ZWRNZXNzYWdlTGl0ZSRTZXJpYWxpemVkRm9ybQAAAAAAAAAAAgACWwAHYXNCeXR"
			+ "lc3QAAltCTAAQbWVzc2FnZUNsYXNzTmFtZXQAEkxqYXZhL2xhbmcvU3RyaW5nO3h"
			+ "wdXIAAltCrPMX+AYIVOACAAB4cAAAABEKB2luX2RhdGEQABoEAAAAAHQAL29yZy5"
			+ "qYnBtLm1hcnNoYWxsaW5nLmltcGwuSkJQTU1lc3NhZ2VzJFZhcmlhYmxldAAMaW5"
			+ "fY2F0ZWdvcmlhc3EAfgAPdXEAfgATAAAAFgoMaW5fY2F0ZWdvcmlhEAAaBAAAAAF"
			+ "xAH4AFXQAB2luX25vbWVzcQB+AA91cQB+ABMAAAARCgdpbl9ub21lEAAaBAAAAAJ"
			+ "xAH4AFXQAC2luX21lbnNhZ2Vtc3EAfgAPdXEAfgATAAAAFQoLaW5fbWVuc2FnZW0"
			+ "QABoEAAAAA3EAfgAVdAAGaW5fcmRhc3EAfgAPdXEAfgATAAAAEAoGaW5fcmRhEAA"
			+ "aBAAAAARxAH4AFXQACFRhc2tOYW1lc3EAfgAPdXEAfgATAAAAEgoIVGFza05hbWU"
			+ "QABoEAAAABXEAfgAVdAAHR3JvdXBJZHNxAH4AD3VxAH4AEwAAABEKB0dyb3VwSWQ"
			+ "QABoEAAAABnEAfgAVdAAKaW5fZW1wcmVzYXNxAH4AD3VxAH4AEwAAABQKCmluX2V"
			+ "tcHJlc2EQABoEAAAACHEAfgAVdAAITm9kZU5hbWVzcQB+AA91cQB+ABMAAAASCgh"
			+ "Ob2RlTmFtZRAAGgQAAAAHcQB+ABV4eFIWCgx2YXJpYWJsZXNNYXAQAHcGGgQAAAA"
			+ "J";
	
	@Test
	public void testDeserialize() {
		ContentDeserializer deserializer = new ContentDeserializer(content);
		Map<String, Object> map = deserializer.deserialize();
		
		Assert.assertEquals(Date.class, map.get("in_data").getClass());
		Assert.assertEquals("TEste", map.get("in_categoria"));
		Assert.assertEquals("123", map.get("in_rda"));
		Assert.assertEquals("notaveis", map.get("GroupId"));
	}
}
