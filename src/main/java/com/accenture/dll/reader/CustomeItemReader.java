package com.accenture.dll.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.accenture.dll.exception.CustomReaderException;

public class CustomeItemReader<T> implements ItemReader<T> {
	
	private static  boolean jobState = false;
	
	private DataGeneratorStrategy dataGeneratorStrategy;


	@Override
	public T read() throws CustomReaderException {
		T generatedata = null;
			if(dataGeneratorStrategy==null)
				throw new CustomReaderException("dataGeneratorStrategy is null");
			generatedata = (T) dataGeneratorStrategy.generateData();
			if(generatedata==null)
				throw new CustomReaderException("data generation is unsuccessfull !!");
        if(jobState)
        {
        	generatedata=null;
        }
        jobState = true;
		return  generatedata;
	}

	public DataGeneratorStrategy getDataGeneratorStrategy() {
		return dataGeneratorStrategy;
	}


	public void setDataGeneratorStrategy(DataGeneratorStrategy dataGeneratorStrategy) {
		this.dataGeneratorStrategy = dataGeneratorStrategy;
	}
	
	

}
