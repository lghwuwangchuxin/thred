package thred;
/**
 * 
 * @类名: StopThread
 * @说明: 终止线程
 *
 * @author   liugh
 * @Date	 2019年6月2日 上午11:08:50
 * 修改记录：
 *
 * @see
 */
public class StopThread {
	public static User u=new User();
	public static class User{
		private int id;
		private String name;
		private User() {
			id=0;
			name="0";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	public static class changeObjiectThread extends Thread{
		volatile boolean stopme=false;
		public void stopMe() {
			stopme=true;
		}
		@Override
		public void run() {
			while(true) {
				if(stopme) {
					System.out.println("exit by stop me");
					break;
				}
				synchronized (u) {
					int v=(int)(System.currentTimeMillis()/1000);
					u.setId(v);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}
				Thread.yield();
			}
			
		}
	}
	public static class ReadObjectThread extends Thread{
		@Override
		public void run() {
			while(true) {
				synchronized (u) {
					if(u.getId()!=Integer.parseInt(u.getName())) {
						System.out.println("id"+u.getId()+"name"+u.getName());
						
					}
				}
				Thread.yield();
			}
			
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		new ReadObjectThread().start();
		while(true) {
			Thread t=new changeObjiectThread();
			t.start();
			Thread.sleep(150);
			t.stop();
		}
	}
	
}
