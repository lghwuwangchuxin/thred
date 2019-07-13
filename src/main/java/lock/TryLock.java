package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @类名: TryLock
 * @说明: 锁申请等待限时-tryLock无参数
 *
 * @author   liugh
 * @Date	 2019年7月13日 下午4:58:13
 * 修改记录：
 *
 * @see
 */
public class TryLock implements Runnable{
	public static ReentrantLock lock1=new ReentrantLock();
	public static ReentrantLock lock2=new ReentrantLock();
	int lock;
	public TryLock(int lock) {
		this.lock=lock;
	}
	@Override
	public void run() {
		if(lock==1) {
			while(true) {
				if(lock1.tryLock()) {
					try {
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if(lock2.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId()+":My Job done");
								return;
							}finally {
								
								lock2.unlock();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
						lock1.unlock();
					}
				}
			}
		}else {
			while(true) {
				if(lock2.tryLock()) {
					try {
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if(lock1.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId()+":My Job done");
								return;
							}finally {
								
								lock1.unlock();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}finally {
						lock2.unlock();
					}
				}
			}
		}
		
	}
	public static void main(String[] args) {
		TryLock r1=new TryLock(1);
		TryLock r2=new TryLock(2);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();
		t2.start();
		
	}
}
