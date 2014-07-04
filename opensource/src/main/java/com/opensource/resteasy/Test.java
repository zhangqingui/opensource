package com.opensource.resteasy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.serializer.BooleanSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;

public class Test {
	public static void main(String[] args) {
		StringWriter s = new StringWriter();
	    TestBean t2 =   new TestBean();
	    t2.setName("abc");
		JSONWriter jw = new JSONWriter(s);
		jw.writeStartObject();
		jw.writeKey("sss");
		jw.writeValue(t2);
		jw.writeEndObject();
		try {
			jw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.append("bb");
		s.flush();
		
		System.out.println("------"+s.toString());
	
		NameFilter filter = new NameFilter() {
		    public String process(Object source, String name, Object value) {
		        if (name.equals("id")) {
		            return "ID";
		        }
		        return name;
		    }
		};
	
		SerializeWriter out = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(out);
		serializer.getNameFilters().add(filter);
	    TestBean t =   new TestBean();
	    t.setName("abc");
	    serializer.write(t);
//	    String text = out.toString();
//	    System.out.println(text);
//	    JSONSerializer.write(out, t);
//		JSONSerializer serializers = new JSONSerializer();
		try {
			BooleanSerializer.instance.write(serializer, true, null, null);
			System.out.println("---"+serializer.getWriter().toString()+"++");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
	    	FileWriter f = new FileWriter(new File("D:\\b.txt"));
			out.writeTo(f);
			f.flush();
			out.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
	/*    try {
			JSONSerializer.write(new FileWriter(new File("D:\\a.txt")), text);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
