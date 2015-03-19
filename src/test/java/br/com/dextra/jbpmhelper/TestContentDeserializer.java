package br.com.dextra.jbpmhelper;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestContentDeserializer {
	
	private final String content = "rO0ABXoAAAFdCgYIBhACGABK3gEIABJIb3JnLmRyb29s"
			+ "cy5jb3JlLm1hcnNoYWxsaW5nLmltcGwuU2VyaWFsaXphYmxlUGxhY2Vob2xkZXJSZ"
			+ "XNvbHZlclN0cmF0ZWd5Go8BrO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZ"
			+ "nHYZ0DAAFJAARzaXpleHAAAAAFdwQAAAAFdAATQW5hbGlzYXJTb2xpY2l0YWNhb3Q"
			+ "AIEFuYWxpc2FyIHNvbGljaXRhY2FvIGRlIHRnb25jYWx2dAAGMjU2MzIxdAAEdHJ1"
			+ "ZXQACW1vZGVyYWRvcnhScgoSCghUYXNrTmFtZRAAGgQAAAAAChIKCE5vZGVOYW1lE"
			+ "AAaBAAAAAEKDQoDaWlkEAAaBAAAAAIKEwoJU2tpcHBhYmxlEAAaBAAAAAMKEQoPU3"
			+ "dpbWxhbmVBY3RvcklkChEKB0dyb3VwSWQQABoEAAAABA==";
	
	@Test
	public void testDeserialize() {
		ContentDeserializer deserializer = new ContentDeserializer(content);
		Map<String, Object> map = deserializer.deserialize();
		
		Assert.assertEquals("AnalisarSolicitacao", map.get("TaskName"));
		Assert.assertEquals("256321", map.get("iid"));
		Assert.assertEquals("moderador", map.get("GroupId"));
	}
}
