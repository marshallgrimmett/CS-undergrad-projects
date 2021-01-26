import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeArrayList<E>
{
	// Create a ReadWriteLock object and optional Lock variables.
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();

	// Create the list.
	private final List<E> list = new ArrayList<>();
	
	//******************************************************************************
	// Adds an element into the list.
	public void set(E o)
	{
		writeLock.lock();  // Lock the
		try
		{
			list.add(o);
			System.out.println("Adding element by thread"+Thread.currentThread().getName());
	        }
		finally
		{
			writeLock.unlock();
		}
	}
	
	//******************************************************************************
	// Returns an element in the list at the position specified.
	public E get(int i)
	{
		readLock.lock();
		try
		{
                        System.out.println("Printing elements by thread"+Thread.currentThread().getName());
			return list.get(i);
		}
		finally
		{
			readLock.unlock();
		}
	}

	//******************************************************************************
	// main
	public static void main(String[] args)
	{
		// Create a new ThreadSafeArrayList object.
		ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();

		// Add elements to the list.
		threadSafeArrayList.set("1");
		threadSafeArrayList.set("2");
		threadSafeArrayList.set("3");

		// Get elements from the list and print.
		System.out.println("Printing the First Element : " + threadSafeArrayList.get(1));
	}
}
