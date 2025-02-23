package classes;


public class BoardingHouse {
	
	private Room[] boardingHouse;
	
	public BoardingHouse(int n) {
		this.boardingHouse = new Room[n];
	}
	
	public void allocate(int roomNumber, String guestName, String guestEmail) {
		Room room = new Room(roomNumber, guestName, guestEmail);
		boardingHouse[roomNumber - 1] = room;
	}
	
	public void deallocate(int roomNumber) {
		boardingHouse[roomNumber - 1] = null;
	}
	
	public Room getRoom(int roomNumber) {
		return boardingHouse[roomNumber -1];
	}
	
	public void changeRoom(int prevRoom, int newRoom) {
		Room temp = getRoom(prevRoom);
		allocate(newRoom, temp.getName(), temp.getEmail());
		deallocate(prevRoom);
		
	}
	
	public boolean checkRoom(int roomNumber) {
		return boardingHouse[roomNumber - 1].getStatus();
	}
}
