package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @类名: ReenterLock
 * @说明: 关键字synchronized的功能扩展：重入锁
 *
 * @author   liugh
 * @Date	 2019年7月7日 上午10:52:44
 * 修改记录：
 *
 * @see
 */
public class ReenterLock implements Runnable{
	public static ReentrantLock lock=new ReentrantLock();
	public static int i=0;
	@Override
	public void run() {
		for(int j=0;j<10000000;j++) {
			lock.lock();
			try {
				i++;
			} finally {
				lock.unlock();
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		ReenterLock lock=new ReenterLock();
		Thread t1=new Thread(lock);
		Thread t2=new Thread(lock);
		t1.start();t1.join();
		t2.start();t2.join();
		System.out.println(i);
	}

}
