package entities;

public class Audio extends Multimedia implements Playable {

	private int volume;

	public Audio(String title, int duration) {
		super(title, duration);
		this.volume = 5;
	}

	@Override
	public void play() {
		System.out.println("Playing");
	}

	@Override
	public void volumeUp() {
		System.out.println("up");
	}

	@Override
	public void volumeDown() {
		System.out.println("down");
	}

}
