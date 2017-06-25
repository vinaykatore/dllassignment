package com.accenture.dll.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.accenture.dll.exception.CustomeWriterException;

public class DoorTogglerDataWriterStrategy implements DataWriterStrategy {

	@Override
	public <E> void write(E data) throws CustomeWriterException {

		if (data != null) {
			List dataList = (List) data;
			Map<Integer, Integer> locks = (Map<Integer, Integer>) dataList
					.get(0);
			FileWriter doorStateFileWriter;
			try {
				doorStateFileWriter = new FileWriter("finalDoorStates.txt");

				for (int k = 0; k < 100; k++) {
					String doorState = null;
					if (locks.get(k) == 0) {
						doorState = "closed";
					} else {
						doorState = "opened";
					}
					doorStateFileWriter.write("Door state at postion "
							+ (k + 1) + " is " + doorState +"\n");
					
					// System.out.println(
					// "Door state at postion "+(k+1)+" is "+doorState);
				}
				doorStateFileWriter.close();
				System.out.println("Final doors state are generated in file finalDoorStates.txt");
			} catch (IOException e) {

				throw new CustomeWriterException(e.getMessage());
			}

		} else {
			throw new CustomeWriterException("No data to write..!!");
		}

	}

}
