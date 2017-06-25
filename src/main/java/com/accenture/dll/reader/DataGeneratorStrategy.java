package com.accenture.dll.reader;

import com.accenture.dll.exception.CustomReaderException;

public interface DataGeneratorStrategy<T> {
	
	public T generateData() throws CustomReaderException;

}
