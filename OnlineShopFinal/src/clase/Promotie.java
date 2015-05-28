package clase;

import exceptii.CosGolException;
import exceptii.ProcentNegativException;
import exceptii.ProcentNullException;
import exceptii.ProcentPeste100Exception;
import exceptii.PromotieException;
import exceptii.VoucherValoareNegativaException;
import exceptii.VoucherValoareNulaException;
import exceptii.VoucherValoarePesteLimitaException;

public class Promotie {
	double procent;
	
	public Promotie(double procent) throws ProcentNegativException, ProcentNullException, ProcentPeste100Exception{
		if(procent < 0) throw new ProcentNegativException();
		else if(procent == 0) throw new ProcentNullException();
		else if(procent > 100) throw new ProcentPeste100Exception();
		else this.procent = procent;
	}
	
	public void aplicareDiscount(CosCumparaturi cos) throws PromotieException{
		if(cos.produse.size() == 0) throw new CosGolException();
		else{
			cos.valoare *= (100-this.procent)/100;
			System.out.println("Dupa aplicarea discount-ului cosul are valoarea de: "+cos.valoare);
		}
	}
	
	public void scadereVoucher(CosCumparaturi cos, double valoareVoucher) throws VoucherValoareNegativaException, VoucherValoareNulaException, VoucherValoarePesteLimitaException, CosGolException{
		if(valoareVoucher < 0 ) throw new VoucherValoareNegativaException();
		else if(valoareVoucher == 0) throw new VoucherValoareNulaException();
		else if(valoareVoucher > cos.getValoareCos()) throw new VoucherValoarePesteLimitaException();
		else if(cos.produse.size() == 0) throw new CosGolException();
		else cos.valoare -= valoareVoucher;
	}
}
