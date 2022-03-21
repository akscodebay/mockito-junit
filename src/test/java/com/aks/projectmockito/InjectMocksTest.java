package com.aks.projectmockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InjectMocksTest {

	@Mock
	INumbers iNumbers;
	
	@InjectMocks
	NumberServiceBusinessImpl sbi;
	
	@Captor
	ArgumentCaptor<Integer> argumentCaptor;
	
	@Test
	void test() {
		
		//given
		given(iNumbers.numberService())
		.willReturn(IntStream.rangeClosed(1, 10).boxed().collect(
				Collectors.toCollection(ArrayList::new)));
		
		//when
		sbi.deleteNumber(2);
//		sbi.deleteNumber(1);
//		sbi.deleteNumber(20);
//		sbi.deleteNumber(0);
		//then
		verify(iNumbers).delete(2);
		then(iNumbers).should().delete(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue()).isEqualTo(2);
	}

}
