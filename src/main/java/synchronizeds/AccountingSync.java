package synchronizeds;

/**
 * 
 * @类名: AccountingSync
 * @说明: 线程安全synchronized,实例对象
 *
 * @author   liugh
 * @Date	 2019年7月7日 上午10:14:19
 * 修改记录：
 *
 * @see
 */
public class AccountingSync implements Runnable{
	//实例对象
	static AccountingSync instance=new AccountingSync();
	static volatile int i=0;
	public static void increase() {
		i++;
	}
	@Override
	public void run() {
		for(int j=0;j<10000000;j++) {
			synchronized (instance) {//当前实例运行，线程，其他需要等待，线程安全操作
				i++;
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		//synsynchronized用法
		//1.指定加锁对象：给对象加锁，进入同步代码前要获取给定对象的锁
	    //2.直接作用于实例方法：相对于当前实例加锁，进入同步代码前获取当前实例的锁
		//3.直接作用于静态方法：相对于对当前类加锁，进入同步代码前要获取当前类的锁
		Thread t1=new Thread(instance);
		Thread t2=new Thread(instance);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		System.out.println(i);
		
	}

}
