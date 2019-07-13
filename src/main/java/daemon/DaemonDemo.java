package daemon;

/**
 * 
 * @类名: DaemonDemo
 * @说明: 守护线程
 *
 * @author   liugh
 * @Date	 2019年6月29日 下午3:35:52
 * 修改记录：
 *
 * @see
 */
public class DaemonDemo {
	public static class DaemonT extends Thread{
		public void run(){
			while(true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t=new DaemonT();
		//必须在线程开始之前调用守护线程
		t.setDaemon(true);
		t.start();
		//两秒后自动退出
		Thread.sleep(2000);
	}
}
