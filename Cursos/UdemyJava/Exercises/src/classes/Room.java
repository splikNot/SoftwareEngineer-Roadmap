package classes;

public class Room {
	
	private int roomNumber;
	private final String guestName;
	private String guestEmail;
	private boolean occupied = false;
	
	public Room(int number, String name, String email) {
		this.roomNumber = number;
		this.guestName = name;
		this.guestEmail = email;
		setStatus(true);
	}
	
	public String getName() {
		return guestName;
	}
	
	public String getEmail() {
		return guestEmail;
	}
	
	public int getNumber() {
		return roomNumber;
	}
	
	public boolean getStatus() {
		return occupied;
	}
	
	public void setNumber(int number) {
		roomNumber = number;
	}
	
	public void setEmail(String newEmail) {
		guestEmail = newEmail;
	}
	
	public void setStatus(boolean bool) {
		occupied = bool;
	}
	
}
