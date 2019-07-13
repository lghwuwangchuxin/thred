package priority;

/**
 * 
 * @类名: PriorityDemo
 * @说明:线程优先级 
 *
 * @author   liugh
 * @Date	 2019年6月29日 下午3:48:51
 * 修改记录：
 *
 * @see
 */
public class PriorityDemo {
	public static class HightPriority extends Thread{
		static int count=0;
		public void run() {
			while(true) {
				synchronized (PriorityDemo.class) {
					count++;
					if(count>1000) {
						System.out.println("HightPriority is complete");
					}
					break;
				}
			}
		}
	}
	public static class LowPriority extends Thread{
		static int count=0;
		public void run() {
			while(true) {
				synchronized (PriorityDemo.class) {
					count++;
					if(count>1000) {
						System.out.println("LowPriority is complete");
					}
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		Thread high=new HightPriority();
		LowPriority low=new LowPriority();
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		low.start();
		high.start();
	}

}
