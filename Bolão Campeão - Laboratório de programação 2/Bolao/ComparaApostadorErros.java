import java.util.Comparator;

public class ComparaApostadorErros implements Comparator<Apostador>{

	@Override
	public int compare(Apostador a1, Apostador a2) {
		return a1.getPalpitesErrados() - a2.getPalpitesErrados();
	}

}
