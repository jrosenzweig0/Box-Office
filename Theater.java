// insert header here
package assignment6;

import java.util.List;
import java.util.ArrayList;
import java.util.Formatter;

public class Theater {
	/*
	 * Represents a seat in the theater
	 * A1, A2, A3, ... B1, B2, B3 ...
	 */
	static class Seat {
		private int rowNum;
		private int seatNum;

		public Seat(int rowNum, int seatNum) {
			this.rowNum = rowNum;
			this.seatNum = seatNum;
		}

		public int getSeatNum() {
			return seatNum;
		}

		public int getRowNum() {
			return rowNum;
		}

		@Override
		public String toString() {
		    String s = "";
		    int l = Integer.toString(Integer.parseInt(Integer.toString(x), 10), 26).length();
		    int count = 0;
		    int x = seatNum;
		    while (true){
		      if (l > 1 && count == l-1){
		        s = s + (char)(x%27 + 64);
		        break;
		      }
		      s = s + (char)(x%26 + 65);
		      x = x-(x%26);
		      x = x/26;
		      if(x == 0) break;
		      count++;
		    }
		    String reverse = new StringBuffer(s).reverse().toString();
		    return reverse + Integer.toString(seatNum);
		}
	}

  /*
	 * Represents a ticket purchased by a client
	 */
	static class Ticket {
		private String show;
		private String boxOfficeId;
		private Seat seat;
	  private int client;

		public Ticket(String show, String boxOfficeId, Seat seat, int client) {
			this.show = show;
			this.boxOfficeId = boxOfficeId;
			this.seat = seat;
			this.client = client;
		}

		public Seat getSeat() {
			return seat;
		}

		public String getShow() {
			return show;
		}

		public String getBoxOfficeId() {
			return boxOfficeId;
		}

		public int getClient() {
			return client;
		}

		@Override
		public String toString() {
	    	String s = "-------------------------------" + "\n";
			Formatter fmt0 = new Formatter();
			s = s + "| " + fmt0.format("%-28s", "Show: " + show) + "|\n";	
			Formatter fmt1 = new Formatter();
			s = s + "| " + fmt1.format("%-28s", "Box Office: " + boxOfficeId) + "|\n";	
			Formatter fmt2 = new Formatter();
			s = s + "| " + fmt2.format("%-28s", "Ticket: " + seat.toString()) + "|\n";	
			Formatter fmt3 = new Formatter();
			s = s + "| " + fmt3.format("%-28s", "Client: " + Integer.toString(client)) + "|\n";	
			s = s + "-------------------------------" + "\n";
			return s;

		}
	}
	public static ArrayList<Seat> BestSeat;
	public static ArrayList<Ticket> TransactionLog;
	
	public Theater(int numRows, int seatsPerRow, String show) {
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < seatsPerRow; j++) {
				BestSeat.add(new Seat(i,j));
			}
		}
	}

	/*
	 * Calculates the best seat not yet reserved
	 *
 	 * @return the best seat or null if theater is full
   */
	public Seat bestAvailableSeat() {
		Seat x = BestSeat.get(0);
		BestSeat.remove(x);
		return x;
	}

	/*
	 * Prints a ticket for the client after they reserve a seat
   * Also prints the ticket to the console
	 *
   * @param seat a particular seat in the theater
   * @return a ticket or null if a box office failed to reserve the seat
   */
	public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
		Ticket t = new Ticket("TPAB", boxOfficeId, seat, client);
		System.out.print(t);
		TransactionLog.add(t);
		return t;
	}

	/*
	 * Lists all tickets sold for this theater in order of purchase
	 *
   * @return list of tickets sold
   */
	public List<Ticket> getTransactionLog() {
		return TransactionLog;
	}
}
