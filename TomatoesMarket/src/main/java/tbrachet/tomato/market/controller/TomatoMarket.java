package tbrachet.tomato.market.controller;

public class TomatoMarket implements Comparable<TomatoMarket> {

	private long id;
	private int tomatoes;
	private String provider;
	private long timestamp;

	public long getId() {
		return id;
	}

	public TomatoMarket() {
		super();
	}

	public TomatoMarket(long id, int tomatoes, String provider, long timestamp) {
		super();
		this.id = id;
		this.tomatoes = tomatoes;
		this.provider = provider;
		this.timestamp = timestamp;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(int tomatoes) {
		this.tomatoes = tomatoes;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int compareTo(TomatoMarket o) {
		if (this.timestamp > o.timestamp) {
			return 1;
		} else if (this.timestamp < o.timestamp) {
			return -1;
		} else {
			return 0;
		}
	}

}
