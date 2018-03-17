
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
	private MaxHeap heap;
	Student s1, s2, s3, s4, s5, s6;

	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap(10);
		s1 = new Student("S1 Susan", 60, 3.5);
		heap.insert(s1);
		s2 = new Student("S2 Ben", 70, 3.4);
		heap.insert(s2);
		s3 = new Student("S3 Reed", 60, 3.9);
		heap.insert(s3);
		s4 = new Student("S4 Johnny", 50, 1.2);
		heap.insert(s4);
		s5 = new Student("S5 Marcus", 99, 3.0);
		heap.insert(s5);
		s6 = new Student("S6 Oscur", 70, 3.7);
		heap.insert(s6);
	}

	@Test
	public void test() {

		heap.changeKey(s1, 4.0);
		heap.changeKey(s2, 3.5);
		heap.changeKey(s2, 3.6);
		heap.changeKey(s4, 2.0);
			
		assertEquals(4.0, heap.extractMax().gpa(), .000001);
		assertEquals(3.9, heap.extractMax().gpa(), .000001);
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		
		MaxHeap heap2 = new MaxHeap(studentList);

		heap2.changeKey(s1, 4.0);
		heap2.changeKey(s2, 3.5);
		heap2.changeKey(s3, 3.6);
		heap2.changeKey(s4, 2.0);

		assertEquals(0, s1.getIndex());
		assertEquals(60, heap2.getMax().units());
		assertEquals(s1, heap2.getMax());
		assertEquals("S1 Susan", s1.getName());
		s1.setUnits(90);
		assertEquals(90, s1.units());
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
		ArrayList<Student> emptyList = new ArrayList<Student>();
		MaxHeap emptyHeap = new MaxHeap(emptyList);
		emptyHeap.getMax();
	}

}
