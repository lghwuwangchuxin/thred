package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @类名: FairLock
 * @说明: 公平锁
 *
 * @author   liugh
 * @Date	 2019年7月13日 下午5:15:52
 * 修改记录：
 *
 * @see
 */
public class FairLock implements Runnable{
	//true公平锁false非公平锁
	public static ReentrantLock fairLock=new ReentrantLock(false);

	@Override
	public void run() {
		while(true) {
			try {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName()+"获得锁");
			} finally {
				fairLock.unlock();
			}
		}
		
	}
	public static void main(String[] args) {
		FairLock r1=new FairLock();
		Thread t1=new Thread(r1,"Thread_t1");
		Thread t2=new Thread(r1,"Thread_t2");
		t1.start();
		t2.start();
	}
}
