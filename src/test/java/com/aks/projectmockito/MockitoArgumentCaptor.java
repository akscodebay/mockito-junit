package com.aks.projectmockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class MockitoArgumentCaptor {

	@Test
	void test() {
		INumbers iNumbers = mock(INumbers.class);
		
		ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
		
		//given
		given(iNumbers.numberService())
		.willReturn(IntStream.rangeClosed(1, 10).boxed().collect(
				Collectors.toCollection(ArrayList::new)));
		
		//when
		NumberServiceBusinessImpl sbi = new NumberServiceBusinessImpl(iNumbers);
		sbi.deleteNumber(2);
//		sbi.deleteNumber(1);
//		sbi.deleteNumber(20);
//		sbi.deleteNumber(0);
		//then
		verify(iNumbers).delete(2);
		then(iNumbers).should().delete(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue()).isEqualTo(2);
		
//		verify(iNumbers, never()).delete(20);
//		then(iNumbers).should(never()).delete(20);
//		
//		verify(iNumbers, never()).delete(0);
//		then(iNumbers).should(never()).delete(0);
//		
//		verify(iNumbers, times(2)).delete(anyInt());
//		
//		verify(iNumbers, atLeastOnce()).delete(anyInt());
	}

}
