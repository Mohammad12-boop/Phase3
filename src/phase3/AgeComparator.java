package phase3;

import java.util.Comparator;




public class AgeComparator implements Comparator<MartyrRecord> {

	 @Override
	    public int compare(MartyrRecord m1, MartyrRecord m2) {
	        return Integer.compare(m1.getAge(), m2.getAge());
	    }
}
