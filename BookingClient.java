// Insert header here
package assignment6;

import java.util.List;
import java.util.Map;
import java.lang.Thread;

public class BookingClient{
  /*
   * @param office maps box office id to number of customers in line
   * @param theater the theater where the show is playing
   */
	public static int clientNumber;
	public static Theater theater;
	public BookingClient(Map<String, Integer> office, Theater theater) {
		clientNumber = 0;
		this.theater = theater;
	}

  /*
   * Starts the box office simulation by creating (and starting) threads
   * for each box office to sell tickets for the given theater
   *
   * @return list of threads used in the simulation,
   *         should have as many threads as there are box offices
   */

	public List<Thread> simulate() {
		List<Thread> threads = new List<Thread>();
		for(int i = 0; i < BoxOffices.size(); i++) {
			threads.add(new Thread())
		}
	}
	class BoxOffice implements Runnable {
		public String ID;
		public int clients;
		
		public BoxOffice(String ID, int clients) {
			this.ID = ID;
			this.clients = clients;
		}
		
		public void run() {
			for(int i = 0; i < this.clients; i++) {
				new Ticket
				Thread.sleep(50);	
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
