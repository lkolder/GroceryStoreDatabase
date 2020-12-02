public class GroceryStoreItem<SerialNumber, Name, Cost, Quantity, Location> {
	private SerialNumber serialnumber;
	private Name name;
	private Cost cost;
	private Quantity quantity;
	private Location location;

	public GroceryStoreItem(SerialNumber serialnumber, Name name, Cost cost, Quantity quantity, Location location) {
		this.serialnumber = serialnumber;
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.location = location;
	}

	public SerialNumber getSerialNumber() {
		return serialnumber;
	}
	
	public Name getName()
	{
		return name;
	}

	public Cost getCost() {
		return cost;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public Location getLocation() {
		return location;
	}

}
