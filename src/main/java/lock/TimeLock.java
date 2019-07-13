package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @类名: TimeLock
 * @说明: 锁申请等待限时-tryLock带时间参数
 *
 * @author   liugh
 * @Date	 2019年7月13日 下午4:42:54
 * 修改记录：
 *
 * @see
 */
public class TimeLock implements Runnable{
	public static ReentrantLock lock=new ReentrantLock();

	@Override
	public void run() {
	 
	try {
		if(lock.tryLock(5, TimeUnit.SECONDS)) {
			Thread.sleep(4000);
			System.out.println("成功");
		}else {
			System.out.println("get lock falied");
		}
	} catch (InterruptedException e) {
		e.printStackTrace();
	}finally {
		if(lock.isHeldByCurrentThread()) {
			lock.unlock();
		}
	}
		
	}
	public static void main(String[] args) {
		TimeLock lock=new TimeLock();
		Thread t1=new Thread(lock);
		Thread t2=new Thread(lock);
		t1.start();
		t2.start();
	}

}
