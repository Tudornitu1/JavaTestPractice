package ro.ase.acs.classes;

import ro.ase.acs.models.TrainTicket;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Utils {

	public static Stream<TrainTicket> getLongDistanceTrains(List<TrainTicket> trains , String departure) {
		return trains.stream().filter(TrainTicket ->{
			return (TrainTicket.getDeparture().equals(departure)) && (TrainTicket.getDistance()>=100);
		}).distinct();
	}
	public static Integer[] array;
	
	public static Callable<Double> lambdaOperation =() ->{
	double product = 1;
	for(int i=0;i< array.length;i++){
		product=product*array[i];
	}
	return product;
	};
}
