package phase3;

public class QuadraticOHash<T extends Comparable<T>>  extends OpenAddressignHash<T> {

	public QuadraticOHash(int dataSize) {

		super(dataSize);
	}

	@Override
	public void add(T data) {


		if (this.find(data) == null) {

			if (size == m/2) rehash();

			int index = Math.abs(data.hashCode()) % m;

			int i = 0;
			for (; table[(index + i * (i++)) % m].getFlag() != "E" && i <= m; collisions++);
			if (i > m) // a loop occurred
				System.out.println("This element cannot be added");
			else {
				index = (index + (--i) * i) % m;
				table[index].setData(data);
				table[index].setFlag("F");
				++size;
			}
		}
	}

	@Override
	public HNode<T> find(T data) {

		 int index = Math.abs(data.hashCode()) % m;
		 int i = 0;
//		 String flag = table[(index + i*i) % m].getFlag();

		    while (i <= m) {

		        int probeIndex = (index + i * i) % m;
		        String flag = table[probeIndex].getFlag();

//		        if (flag.equals("D")) {
//
//		            i++;
//		            continue;
//		        }

		        if ( ( flag.equals("D") || flag.equals("F") ) && table[probeIndex].getData().compareTo(data) ==0) {

		            return table[probeIndex];
		        }
		        if (flag.equals("E")) { // Assuming "E" stands for an empty slot

//		        	return null;
		        }

		        i++;
		    }

		    return null;


//		 for (; flag.equals("D") ||
//				 flag.equals("F") && table[(index + i*i) % m].getData().compareTo(data) != 0
//					&& i <= m; // to avoid entering an infinite loop
//					flag = table[(index + (++i) * i) % m].getFlag());
//
//			if (flag.equals("F") && table[(index + i*i) % m].getData().compareTo(data) == 0)
//				return table[(index + i*i) % m];
//
//			return null;
//
	}

}