import java.util.ArrayList;
import java.util.List;


public class Room {
private String roomId;
private int capacity;
private List<String> equipmentList;

public Room(String roomId, int capacity) {
    this.roomId = roomId;
    this.capacity = capacity;
    this.equipmentList = new ArrayList<>();
}

    public String getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getEquipmentList() {
        return equipmentList;
    }

    public void addEquipment(String item) {
        equipmentList.add(item);
    }
}
