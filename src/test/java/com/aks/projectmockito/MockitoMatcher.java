package com.aks.projectmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class MockitoMatcher {

	@Test
	void testListMock_Size() {
		List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(2);
		assertEquals(2, list.size());
	}
	
	@Test
	void testListMockMutiple_Size() {
		List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(2).thenReturn(10);
		assertEquals(2, list.size());
		assertEquals(10, list.size());
	}
	
	@Test
	void testListMock_ListGet() {
		List<Integer> list = mock(List.class);
		when(list.get(0)).thenReturn(2).thenReturn(10);
		assertEquals(2, list.get(0));
		assertNull(list.get(1));
	}
	
	//argument matchers
	@Test
	void testListMock_ListGet_AnyMatch() {
		List<Integer> list = mock(List.class);
		when(list.get(anyInt())).thenReturn(2);
		assertEquals(2, list.get(0));
		assertEquals(2, list.get(1));
	}

}
