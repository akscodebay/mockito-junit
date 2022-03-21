package com.aks.projectmockito;

import java.util.List;
import java.util.stream.Collectors;

public class NumberServiceBusinessImpl {
	
	private INumbers iNumbers;

	public NumberServiceBusinessImpl(INumbers iNumbers) {
		super();
		this.iNumbers = iNumbers;
	}
	
	public List<Integer> retreiveOddNumbers(){
		return iNumbers.numberService().stream().filter(i -> i%2!=0)
				.collect(Collectors.toList());
	}
	
	public void deleteNumber(int num) {
		List<Integer> list = iNumbers.numberService();
			if (list.contains(num)) {
				iNumbers.delete(num);
			}

	}

}
