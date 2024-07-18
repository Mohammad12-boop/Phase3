package phase3;



public class Main {
	public static void main(String[] args){

		Avl_tree<Integer> avl=new Avl_tree<>();

		avl.insert(55);
		avl.insert(50);
		avl.insert(65);
		avl.insert(60);
		avl.insert(75);
		avl.insert(45);

		avl.traverseInOrder();

		System.out.println("\n-------------------------");

		avl.delete(50);

		avl.traverseInOrder();

//		System.out.println(avl.find(99));
//		System.out.println(avl.find(60));


//		Avl_tree<MartyrRecord> avl=new Avl_tree<>();
//
//		avl.insert(new MartyrRecord("ahmad",35,"alquds","aram","M"));
//		avl.insert(new MartyrRecord("hani",35,"alquds","aram","M"));
//		avl.insert(new MartyrRecord("moha",35,"alquds","aram","M"));
//		avl.insert(new MartyrRecord("bara",35,"alquds","aram","M"));
//		avl.insert(new MartyrRecord("baha",35,"alquds","aram","M"));
//		avl.insert(new MartyrRecord("ahmad",35,"alquds","aram","M"));

//		avl.traverseInOrder();
	}
}
