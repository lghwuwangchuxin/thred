package thred;
/**
 * 
 * @类名: CrateThread
 * @说明: 手动创建线程
 *
 * @author   liugh
 * @Date	 2019年6月2日 上午10:59:27
 * 修改记录：
 *
 * @see
 */
public class CreateThread {
	public static void main(String[] args) {
		Thread t1=new Thread() {
			@Override
			public void run() {
				System.out.println("t1");
			}

		};
		t1.start();
	}
}
