package com.accenture.dll.processor;

import java.util.Map;

import com.accenture.dll.exception.CustomProcessorException;

public class DoorTogglerDataProcessorStrategy implements DataProcessorStrategy {

	@Override
	public <T, E> T process(E inputData) throws CustomProcessorException {
		
		if(inputData==null)
			throw new CustomProcessorException("No Data exist for process");
		try{
			if(inputData!=null && inputData instanceof Map<?, ?>)
			{
			Map<Integer, Integer> locks= (Map<Integer, Integer>) inputData;
			for(int i=0;i<100;i++)
			{
				int noOfIteration =100/(i+1);
				if(noOfIteration==0)
				{
					noOfIteration=1;
				}
				int multiplier=i+1;
				for(int j=1; j<=noOfIteration;j++)
				{
					int indexTOUpdate= (j*multiplier)-1;
					 if(indexTOUpdate<100)
					 {
						 Integer value=locks.get(indexTOUpdate);
						 
						 if(value==0)
						 {
							 System.out.println("Opening door at position "+(indexTOUpdate+1));
							 locks.put(indexTOUpdate, 1); 
						 }
						 else{
							 System.out.println("Closing door at position "+(indexTOUpdate+1));
							 locks.put(indexTOUpdate, 0);
						 }
					 }
				}
				System.out.println("pass "+(i+1)+" finished");
				System.out.println("=======================================================================");
			}
		}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new CustomProcessorException(e.getMessage());
		}
		catch (ClassCastException e) {
			throw new CustomProcessorException(e.getMessage());
		}
		
		return (T) inputData;
	}

}
