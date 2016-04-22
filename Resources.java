public class Resources{
	public int id;
	public int held = 0;
	public int max = 0;
	public Resources(int id){
		this.id = id;
	}
	
	public void setHeld(int held){
		this.held = held;
	}
	
	public void setMax(int max){
		this.max = max;
	}
}