package com.accenture.dll.reader;

import java.util.HashMap;
import java.util.Map;

public class DoorLockDataGeneratorStrategy<T> implements DataGeneratorStrategy<T>{

	@Override
	public T generateData() {
		
		Map<Integer, Integer> locks = new HashMap<Integer, Integer>();
		
		for(int i=0;i<100;i++)
		{
			locks.put(i, 0);
		}
		return (T) locks;
	}

}
