package com.accenture.dll.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class CusomeItemWriter<T> implements ItemWriter<T> {
	
	private DataWriterStrategy dataWriterStrategy;

	@Override
	public void write(List<? extends T> data) throws Exception {
		
		dataWriterStrategy.write(data);
		
	}

	public DataWriterStrategy getDataWriterStrategy() {
		return dataWriterStrategy;
	}

	public void setDataWriterStrategy(DataWriterStrategy dataWriterStrategy) {
		this.dataWriterStrategy = dataWriterStrategy;
	}
	
	

}
