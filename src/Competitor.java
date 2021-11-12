public class Competitor implements Comparable<Competitor> {
	int placing;

	public Competitor(int placing){
		this.placing = placing;
	}

	@Override
	public int compareTo(Competitor competitor) {
		return this.placing - competitor.placing;
	}
}
