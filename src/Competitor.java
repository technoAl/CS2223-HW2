// Simple comparable class
// Competitors are sorted by ranking
public class Competitor implements Comparable<Competitor> {
	int placing;
	String name;

	public Competitor(int placing, String name){
		this.placing = placing;
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}

	@Override
	public int compareTo(Competitor competitor) {
		return this.placing - competitor.placing;
	}
}
