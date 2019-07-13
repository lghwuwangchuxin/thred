package lock;

import java.util.concurrent.locks.ReentrantLock;

public class intLock implements Runnable{

	public static ReentrantLock lock1=new ReentrantLock();
	public static ReentrantLock lock2=new ReentrantLock();
	int lock;
	/**
	 * 控制加锁顺序，方便构造死锁
	 * @param lock
	 */
	public intLock(int lock) {
		this.lock=lock;
	}
	@Override
	public void run() {
		try {
			if(lock==1) {
				lock1.lockInterruptibly();
			
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
