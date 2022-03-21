package com.aks.projectmockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class UsingBDD {

	@Test
	void test() {
		INumbers iNumbers = mock(INumbers.class);
		//given
		given(iNumbers.numberService()).willReturn(IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toCollection(ArrayList::new)));
		
		//when
		Object[] array = new NumberServiceBusinessImpl(iNumbers).retreiveOddNumbers().toArray();
		
		int[] arr = {1,3,5,7,9};
		
		//then
		assertThat(array).usingRecursiveComparison().isEqualTo(arr);
		
	}

}
