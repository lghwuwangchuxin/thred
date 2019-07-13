package thred;
/**
 * 
 * @类名: CrateThreadRunnable
 * @说明: 创建线程实现Runnable接口
 *
 * @author   liugh
 * @Date	 2019年6月2日 上午10:58:36
 * 修改记录：
 *
 * @see
 */
public class CreateThreadRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Runnable");
		
	}
	public static void main(String[] args) {
		Thread t1=new Thread( new CreateThreadRunnable());
		t1.start();
	}
		
}
