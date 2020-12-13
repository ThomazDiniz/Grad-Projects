import java.util.Comparator;

public class ComparaApostadorAcertos implements Comparator<Apostador>{

	@Override
	public int compare(Apostador a1, Apostador a2) {
		return a1.getPalpitesCertos() - a2.getPalpitesCertos();
	}
}
