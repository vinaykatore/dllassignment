package com.accenture.dll.processor;

import org.springframework.batch.item.ItemProcessor;

import com.accenture.dll.exception.CustomProcessorException;

public class CustomItemProcessor<I, O> implements ItemProcessor<I, O> {
	
	private DataProcessorStrategy dataProcessorStrategy;

	@Override
	public O process(I inputData) throws CustomProcessorException {
		if(dataProcessorStrategy==null)
			throw new CustomProcessorException("dataProcessorStrategy is null");
		if(inputData==null)
			throw new CustomProcessorException("No Data Exist for process");
		O dataToWrite = null;
			dataToWrite = dataProcessorStrategy.process(inputData);
		return dataToWrite;
	}

	public DataProcessorStrategy getDataProcessorStrategy() {
		return dataProcessorStrategy;
	}

	public void setDataProcessorStrategy(DataProcessorStrategy dataProcessorStrategy) {
		this.dataProcessorStrategy = dataProcessorStrategy;
	}
	
	
}
