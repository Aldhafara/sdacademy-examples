package pl.sdacademy.tdd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Vat {

	public static void main(String[] args) {



		/*BigDecimal priceWithoutVat = new BigDecimal("9.99");
		System.out.println("Price without VAT:  " + priceWithoutVat);


		BigDecimal priceWithVat = priceWithoutVat.multiply(
			new BigDecimal("1.23"));
		System.out.println("Price with VAT:     "+ priceWithVat);*/

		BigDecimal stafraVat = new BigDecimal("1.23");
		BigDecimal index = new BigDecimal("1.0");




		List<BigDecimal> vat = new ArrayList<>();
		List<BigDecimal> kwota = new ArrayList<>();
		kwota.add(0,index);
		vat.add(0,index);
		for (int i=1; i >=0; i++) {

			vat.add(i,kwota.get(i-1).multiply(stafraVat));
			//System.out.println(kwota.get(i-1) + " : " + vat.get(i));
			kwota.add(i,kwota.get(i-1).add(index));

		}

		System.out.println(vat.toString());


	}
}
