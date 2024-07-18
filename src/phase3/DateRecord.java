package phase3;

import java.time.LocalDate;

import java.util.Objects;




public class DateRecord implements Comparable<DateRecord>{

	private LocalDate date;
	private Avl_tree<MartyrRecord> martyrs;

	public DateRecord(LocalDate date) {

		this.date = date;
		this.martyrs = new Avl_tree<>();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Avl_tree<MartyrRecord> getMartyrs() {
		return martyrs;
	}

	public void setMartyrs(Avl_tree<MartyrRecord> martyrs) {
		this.martyrs = martyrs;
	}

	public String toString() {

		return " "+ date;
	}

	@Override
	public int compareTo(DateRecord o) {

		return this.date.compareTo(o.date);
	}

	@Override
	public int hashCode() {
		return this.date.hashCode();
	}



}
