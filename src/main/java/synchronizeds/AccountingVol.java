package synchronizeds;

/**
 * 
 * @类名: AccountingVol
 * @说明: 线程安全Volatile
 *
 * @author   liugh
 * @Date	 2019年6月29日 下午4:07:14
 * 修改记录：
 *
 * @see
 */
public class AccountingVol implements Runnable{
	static AccountingVol instance=new AccountingVol();
	static volatile int i=0;
	public static void increase() {
		i++;
	}
	@Override
	public void run() {
		for(int j=0;j<10000000;j++) {
			increase();
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		//多个线程读取i两个线程读取值一样，i++都是等于1
		Thread t1=new Thread(instance);
		Thread t2=new Thread(instance);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
		
	}

}
