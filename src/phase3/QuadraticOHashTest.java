package phase3;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;



public class QuadraticOHashTest {

	public static void main(String[] args) {

//		QuadraticOHash<Integer>hash=new QuadraticOHash<>(10);
//
//		hash.add(89);
//		hash.add(18);
//		hash.add(49);
//		hash.add(58);
//		hash.add(69);
//
//		hash.traverse();
//
//		System.out.println("----------------------------\n");
//
//		System.out.println(hash.find(99));
//		System.out.println(hash.find(49));

		QuadraticOHash<DateRecord>hash=new QuadraticOHash<>(11);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");


		hash.add(new DateRecord(LocalDate.parse("1/2/2004", formatter)));

		System.out.println(new DateRecord(LocalDate.parse("1/2/2004", formatter)).hashCode());
		System.out.println(new DateRecord(LocalDate.parse("1/2/2004", formatter)).hashCode());
		System.out.println(new DateRecord(LocalDate.parse("1/2/2004", formatter)).hashCode());



//		hash.add(new DateRecord(LocalDate.parse("3/5/2009", formatter)));
//
//
//		hash.add(new DateRecord(LocalDate.parse("7/26/2016", formatter)));
//
//		hash.add(new DateRecord(LocalDate.parse("12/6/2012", formatter)));
//
//		hash.add(new DateRecord(LocalDate.parse("7/26/2016", formatter)));
//
//		hash.add(new DateRecord(LocalDate.parse("1/5/2006", formatter)));
//
//		hash.add(new DateRecord(LocalDate.parse("10/3/2014", formatter)));


		System.out.println(hash.getM());
		System.out.println(hash.getSize());

		System.out.println("----------------------------\n");

		hash.traverse();

		System.out.println("----------------------------\n");

		System.out.println(hash.find(new DateRecord(LocalDate.parse("9/5/2015", formatter))));
		System.out.println(hash.find(new DateRecord(LocalDate.parse("1/2/2004", formatter))));

//		System.out.println("----------------------------\n");
//
//		System.out.println(hash.m);
//		System.out.println(hash.size);




	}

}
