package com.aks.projectmockito;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class NumberServiceTest {

	@Test
	void testNumberSeriveBusinessImpl_ResultSize() {
		INumbers iNumbers = mock(INumbers.class);
		when(iNumbers.numberService()).thenReturn(IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toList()));
		assertEquals(5, new NumberServiceBusinessImpl(iNumbers).retreiveOddNumbers().size());
	}
	
	@Test
	void testNumberSeriveBusinessImpl_ResultList() {
		INumbers iNumbers = mock(INumbers.class);
		when(iNumbers.numberService()).thenReturn(IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toCollection(ArrayList::new)));
		assertArrayEquals(Stream.of(1,3,5,7,9).toArray(), 
				new NumberServiceBusinessImpl(iNumbers).retreiveOddNumbers().toArray());
	}

}
