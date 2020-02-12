package bshyn.com.github.PluginTest.entities;

public class SavedCoordinate {

	private String coordDescription;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	
	public SavedCoordinate(String description, int xCoord, int yCoord, int zCoord) {
		super();
		this.coordDescription = description;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
	}
	
	public SavedCoordinate() {
		super();
	}

	@Override
	public String toString() {
		return this.coordDescription + " X: " + this.xCoord + ", Y: " + this.yCoord + ", Z: " + this.zCoord;
	}
	
	public String getCoordDescription() {
		return coordDescription;
	}
	public void setDescription(String description) {
		this.coordDescription = description;
	}
	public int getxCoord() {
		return xCoord;
	}
	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	public int getyCoord() {
		return yCoord;
	}
	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	public int getzCoord() {
		return zCoord;
	}
	public void setzCoord(int zCoord) {
		this.zCoord = zCoord;
	}
	
}
