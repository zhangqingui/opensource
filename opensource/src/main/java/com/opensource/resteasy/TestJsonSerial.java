package com.opensource.resteasy;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.ValueFilter;

public class TestJsonSerial implements ObjectSerializer {

	@Override
	public void write(JSONSerializer jsonserializer, Object object, Object fieldName, Type fieldType) throws IOException {
		List<ValueFilter> v =	jsonserializer.getValueFilters();
		for(ValueFilter f:v){
			System.out.println(f);
		}
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 0);
		serializer.write(map);
		String text = out.toString();
		System.out.println(text);
	}

}
