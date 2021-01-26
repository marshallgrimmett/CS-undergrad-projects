import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ThreadSafeArrayList<E>
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
			System.out.println("Adding element by thread" + Thread.currentThread().getName());
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
                        System.out.println("Printing elements by thread" + Thread.currentThread().getName());
			return list.get(i);
		}
		finally
		{
			readLock.unlock();
		}
	}

	public void print()
	{
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("Value: " + get(i));
		}
	}
}

// MyThread
// Creates a thread that adds Strings to an ArrayList
class MyThread extends Thread
{
	private ThreadSafeArrayList<String> list;

	MyThread(ThreadSafeArrayList<String> l)
	{
		list = l;
	}

	public void run()
	{
		try
		{
			list.set("1");
			sleep(500);     // Sleep for a half second.
			list.set("2");
			sleep(500);     // Sleep for a half second.
			list.set("3");
		}
		catch (Exception ex)
		{
			System.out.println("Sleep error.");
		}
	}
}

// Main
public class ReaderWriterProblem
{
	public static void main(String[] args)
	{
		// Create a new ThreadSafeArrayList object.
		ThreadSafeArrayList<String> threadSafeArrayList = new ThreadSafeArrayList<>();

		// Creates 2 threads
		MyThread thread1 = new MyThread(threadSafeArrayList);
		MyThread thread2 = new MyThread(threadSafeArrayList);

		// Run the threads
		thread1.start();
		thread2.start();

		// Wait for the threads to finish
		try
		{
			thread1.join();
			thread2.join();
		}
		catch (Exception ex)
		{
			System.out.println("Join error.");
		}

		// Print the list
		threadSafeArrayList.print();
	}
}

// Output
/*
1 : 0
5 : 0
7 : 0
0 : 0
2 : 0
8 : 0
4 : 0
3 : 0
6 : 0
9 : 0
3 : 1
9 : 1
0 : 1
9 : 2
8 : 1
2 : 1
1 : 1
7 : 1
2 : 2
5 : 1
9 : 3
4 : 1
6 : 1
0 : 2
0 : 3
3 : 2
6 : 2
5 : 2
6 : 3
0 : 4
7 : 2
1 : 2
0 : 5
8 : 2
6 : 4
7 : 3
2 : 3
8 : 3
5 : 3
4 : 2
9 : 4
4 : 3
0 : 6
3 : 3
7 : 4
1 : 3
6 : 5
3 : 4
4 : 4
8 : 4
9 : 5
3 : 5
6 : 6
2 : 4
1 : 4
1 : 5
8 : 5
5 : 4
7 : 5
0 : 7
5 : 5
4 : 5
4 : 6
0 : 8
8 : 6
6 : 7
8 : 7
9 : 6
2 : 5
4 : 7
3 : 6
1 : 6
2 : 6
2 : 7
7 : 6
8 : 8
6 : 8
3 : 7
5 : 6
0 : 9
6 : 9
8 : 9
1 : 7
9 : 7
7 : 7
4 : 8
2 : 8
3 : 8
1 : 8
2 : 9
4 : 9
5 : 7
9 : 8
5 : 8
9 : 9
1 : 9
3 : 9
5 : 9
7 : 8
7 : 9
*/
