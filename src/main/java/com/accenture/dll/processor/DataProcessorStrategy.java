package com.accenture.dll.processor;

import com.accenture.dll.exception.CustomProcessorException;

public interface DataProcessorStrategy {

	public <T, E> T process(E inputData) throws CustomProcessorException;
}
