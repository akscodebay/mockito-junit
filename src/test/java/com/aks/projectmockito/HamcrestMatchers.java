package com.aks.projectmockito;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hamcrest.text.IsEmptyString;
import org.junit.jupiter.api.Test;

public class HamcrestMatchers {

	@Test
	public void test() {
		INumbers iNumbers = mock(INumbers.class);

		//given
		given(iNumbers.numberService())
		.willReturn(IntStream.rangeClosed(1, 10).boxed().collect(
				Collectors.toCollection(ArrayList::new)));

		//when

		//then
		assertThat(iNumbers.numberService(), hasSize(10));
		assertThat(iNumbers.numberService(), hasItems(10, 2));
		assertThat(iNumbers.numberService(), everyItem(greaterThan(0)));
		assertThat(iNumbers.numberService(), everyItem(lessThan(11)));
		
		Integer[] a = {1,2,3};
		
		assertThat(a, arrayWithSize(3));
		assertThat(iNumbers.numberService(), containsInAnyOrder(3,2,4,1,5,6,7,8,9,10));
		
		assertThat("", IsEmptyString.emptyString());
		assertThat(null, IsEmptyString.emptyOrNullString());
	}

}
