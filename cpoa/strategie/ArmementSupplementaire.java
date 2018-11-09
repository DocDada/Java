package strategie;

public abstract class ArmementSupplementaire extends Voilier {

	private Voilier voilierDecore;

	public ArmementSupplementaire(Voilier voilierDecore) {
		this.voilierDecore = voilierDecore;
	}

	
	public String toString() {
		return voilierDecore.toString();
	}

}
