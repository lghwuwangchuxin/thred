package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @类名: ReenterLockCondition
 * @说明:重入锁的好搭档：Condition 
 *
 * @author   liugh
 * @Date	 2019年7月13日 下午5:30:38
 * 修改记录：
 *
 * @see
 */
public class ReenterLockCondition implements Runnable{
  public static ReentrantLock lock=new ReentrantLock();
  public static Condition condition=lock.newCondition();
	
	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition lockcon=new ReenterLockCondition();
		Thread t1 =new Thread();
		t1.start();
		Thread.sleep(2000);
		//通知线程t1继续执行
		lock.lock();
		condition.signal();
		lock.unlock();
		
	}
}
