package phase3;



public class Avl_tree<T extends Comparable<T>> {

	private TNode<T> root;

	public TNode<T> getRoot() {
		return root;
	}

	public void setRoot(TNode<T> root) {
		this.root = root;
	}

	public boolean isEmpty() {

		return root == null;
	}

	public void insert(T data) {

		if (find(data)==null) {

			if (isEmpty())
				root = new TNode<>(data);
			else {

				TNode<T> rootNode = root;
				addEntry(data, rootNode);
				root = rebalance(rootNode);
			}

		}else {

			System.out.println("This node is already exist !\n");
		}
	}

	private void addEntry(T data, TNode<T> rootNode) {

		assert rootNode != null;

		if (data.compareTo((T) rootNode.getData()) < 0) { // right into left subtree

			if (rootNode.hasLeft()) {

				TNode<T> leftChild = rootNode.getLeft();
				addEntry(data, leftChild);
				rootNode.setLeft(rebalance(leftChild));

			} else
				rootNode.setLeft(new TNode<>(data));

		} else { // right into right subtree

			if (rootNode.hasRight()) {

				TNode<T> rightChild = rootNode.getRight();
				addEntry(data, rightChild);
				rootNode.setRight(rebalance(rightChild));

			} else
				rootNode.setRight(new TNode<>(data));

		}
	}

	public TNode<T> delete(T data) {

		TNode<T> temp = deleteN(data);
		if (temp != null) {

			TNode<T> rootNode = root;
			root = rebalance(rootNode);
		}
		return temp;
	}

	private TNode<T> deleteN(T data) {

		TNode<T> current = root;
		TNode<T> parent = root;
		boolean isLeftChild = false;

		if (isEmpty())

			return null; // tree is empty

		while (current != null && !current.getData().equals(data)) {

			parent = current;

			if (data.compareTo((T)current.getData()) < 0) {

				current = current.getLeft();

				isLeftChild = true;

			} else {

				current = current.getRight();

				isLeftChild = false;

			}

		}

		if (current == null)

			return null; // case 0: node to be deleted not found

		// case 1: node is a leaf
		if (current.isLeaf()) {

			if (current == root) // tree has only one node
				root = null;

			else if (isLeftChild)
				parent.setLeft(null);

			else
				parent.setRight(null);
		 }

		// Case 2 broken down further into 2 separate cases (has one child)
		else if (current.hasLeft() && !current.hasRight()) { // current has left child only

			if (current == root) {

				root = current.getLeft();

			} else if (isLeftChild) {

				parent.setLeft(current.getLeft());

			} else {

				parent.setRight(current.getLeft());

			}

		} else if (current.hasRight() && !current.hasLeft()) { // current has right child only

			if (current == root) {

				root = current.getRight();

			} else if (isLeftChild) {

				parent.setLeft(current.getRight());

			} else {

				parent.setRight(current.getRight());

			}

		}

		// case 3: node to be deleted has 2 children
		else {

			TNode<T> successor = getSuccessor(current);

			if (current == root)

				root = successor;

			else if (isLeftChild) {

				parent.setLeft(successor);

			} else {

				parent.setRight(successor);

			}

			successor.setLeft(current.getLeft());

		}

		return current;
	}

	private TNode<T> getSuccessor(TNode<T> node) {

		TNode<T> parentOfSuccessor = node;
		TNode<T> successor = node;
		TNode<T> current = node.getRight();

		while (current != null) {

			parentOfSuccessor = successor;
			successor = current;
			current = current.getLeft();
		}

		if (successor != node.getRight()) { // fix successor connections

			parentOfSuccessor.setLeft(successor.getRight());
			successor.setRight(node.getRight());

		}

		return successor;
	}

	public TNode<T> find(T data) {

		return find(data, root);

	}

	private TNode<T> find(T data, TNode<T> node) {

		if (node!= null) {

			int comp = node.getData().compareTo(data);

			if (comp==0)
				return node;


			else if (comp > 0 && node.hasLeft())
				return find(data, node.getLeft());

			else /*if (comp < 0 && node.hasRight())*/
				return find(data, node.getRight());

		}

		return null;
	}

	private TNode<T> rotateLeft(TNode<T> nodeN) {

		TNode<T> nodeC = nodeN.getRight();
		nodeN.setRight(nodeC.getLeft());
		nodeC.setLeft(nodeN);
		return nodeC;

	}

	private TNode<T> rotateRight(TNode<T> nodeN) {

		TNode<T> nodeC = nodeN.getLeft();
		nodeN.setLeft(nodeC.getRight());
		nodeC.setRight(nodeN);
		return nodeC;

	}

	private TNode<T> rotateRightLeft(TNode<T> nodeN) {

		TNode<T> nodeC = nodeN.getRight();
		nodeN.setRight(rotateRight(nodeC));
		return rotateLeft(nodeN);

	}

	private TNode<T> rotateLeftRight(TNode<T> nodeN) {

		TNode<T> nodeC = nodeN.getLeft();
		nodeN.setLeft(rotateLeft(nodeC));
		return rotateRight(nodeN);

	}

	private TNode<T> rebalance(TNode<T> nodeN) {

		if (nodeN==null)
			return null;

		int diff = getHeightDifference(nodeN); //left - right

		if (diff > 1) { // addition was in node's left subtree (left subtree is taller)

			if (getHeightDifference(nodeN.getLeft()) > 0) //left - left addition
				nodeN = rotateRight(nodeN);
			else
				nodeN = rotateLeftRight(nodeN); //left - right addition

		} else if (diff < -1) { // addition was in node's right subtree (right subtree is taller)

			if (getHeightDifference(nodeN.getRight()) < 0) //right - right addition
				nodeN = rotateLeft(nodeN);
			else
				nodeN = rotateRightLeft(nodeN); //right - left addition
		}
		return nodeN;
	}

	private int getHeightDifference(TNode<T> node) {

		if (node == null)
			return 0;

		return height(node.getLeft()) - height(node.getRight());

	}

	public int height() {
		return height(root);
	}

	public int height(TNode<T> node) {

		if (node == null)
			return 0;

		if (node.isLeaf())
			return 1;

		int left = 0;
		int right = 0;
		if (node.hasLeft())
			left = height(node.getLeft());

		if (node.hasRight())
			right = height(node.getRight());

		return (left > right) ? (left + 1) : (right + 1);
	}

	public int size() {

		return size(root);
	}

	private int size(TNode<T> curr) {

		if (curr == null)
			return 0;

		return 1 + size(curr.getLeft()) + size(curr.getRight());
	}

	public TNode<T> largest() {

		return largest(root);
	}

	private TNode<T> largest(TNode<T> node) {

		if(node!= null){

			if(!node.hasRight())

				return (node);

			return largest(node.getRight());

		}

		return null;
	}

	public TNode<T> smallest() {

		return smallest(root);
	}

	private TNode<T> smallest(TNode<T> node) {

		if(node!= null){

			if(!node.hasLeft())

				return (node);

			return smallest(node.getLeft());

		}

		return null;
	}

	public int countLeaves() {

		return countLeaves(root);
	}

	private int countLeaves(TNode<T> curr) {

		if (curr == null) return 0;
		if (curr.isLeaf()) return 1;
		return countLeaves(curr.getLeft()) + countLeaves(curr.getRight());
	}

	public int countParents() {

		return countParents(root);
	}

	private int countParents(TNode<T> curr) {

		if (curr == null) return 0;
		if (!curr.isLeaf()) return 1;
		return countParents(curr.getLeft()) + countParents(curr.getRight());
	}

	public void traverseInOrder() {
		traverseInOrder(root);
	}


	private void traverseInOrder(TNode<T> node) {

		if (node != null) {

			if (node.getLeft() != null)
				traverseInOrder(node.getLeft());

			System.out.print(node + " ");

			if (node.getRight() != null)
				traverseInOrder(node.getRight());
		}
	}

	public void traverseLevelOrder() {

		if (root == null) return;

		LinkedQueue<TNode<T>> queue = new LinkedQueue<>();

		queue.enqueue(root);

		while (!queue.isEmpty()) {

			TNode<T> curr = queue.dequeue();
			System.out.print(curr + " ");
			if (curr.hasLeft()) queue.enqueue(curr.getLeft());
			if (curr.hasRight()) queue.enqueue(curr.getRight());
		}
	}
}
