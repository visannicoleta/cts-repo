package clase;

import DesignPatterns.ModPlataStrategy;

public class PlataCuCardul implements ModPlataStrategy{

	@Override
	public void plateste() {
		System.out.println("Plata efectuata cu cardul.");
		
	}

}
