
import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
   private ArrayList<Student> students;
   
   public MaxHeap(int capacity)
   {
      students = new ArrayList<Student>(capacity);
   }
      
   public MaxHeap(Collection<Student> collection)
   {
	      students = new ArrayList<Student>(collection);
	      for(int i = size()/2; i >= 0; i--)
	      {
	         maxHeapify(i);
	      }
	   }

   public Student getMax()
   {
      if(size() < 1)
      {
         throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
      }
      return students.get(0);
   }
   
   public Student extractMax()
   {
      Student value = getMax();
      students.set(0,students.get(size()-1));
      students.remove(size()-1);
      maxHeapify(0);
      
      return value;
   }
   
   
	public void insert(Student s) {
		students.add(s);
		s.setIndex(size()-1);
		moveUp(size()-1);
	}
  
	private void moveUp(int i) {
		
			if(students.get(i).compareTo(students.get(parent(i))) > 0) {
			swap(i,parent(i));
			moveUp(parent(i));

		}		
	}

	public void changeKey(Student s, double newGPA) {		
		int i = s.getIndex(); 
		
			students.get(i).setGPA(newGPA);
			maxHeapify(i);
			moveUp(i);	
	}

   private int parent(int index)
   {
      return (index - 1)/2;
   }
   
   private int left(int index)
   {
      return 2 * index + 1;
   }
   
   private int right(int index)
   {
      return 2 * index + 2;
   }
   
   private int size()
   {
      return students.size();
   }
   
   private void swap(int from, int to)
   {
	  if (size() >= 1) {
		  students.get(from).setIndex(from);
		  if(left(from) < size()) {
			  students.get(left(from)).setIndex(from);
		  }
		  if(right(from) < size()) {
			  students.get(right(from)).setIndex(from);
		  }
	  }
      Student val = students.get(from);
      students.set(from,  students.get(to));
      students.get(from).setIndex(from);
      students.set(to, val);
      students.get(to).setIndex(to);
   }
   
   private void maxHeapify(int index)
   {
      int left = left(index);
      int right = right(index);
      int largest = index;
    	  
		if (left < size() && students.get(left).compareTo(students.get(largest)) > 0) {
			largest = left;
		}
		if (right < size() && students.get(right).compareTo(students.get(largest)) > 0) {
			largest = right;

		}
		if (largest != index) {
			swap(index, largest);
			maxHeapify(largest);

		}
	}
}