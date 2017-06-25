package com.accenture.dll.writer;

import com.accenture.dll.exception.CustomeWriterException;

public interface DataWriterStrategy {
	
	public <E> void write(E data) throws CustomeWriterException;

}
