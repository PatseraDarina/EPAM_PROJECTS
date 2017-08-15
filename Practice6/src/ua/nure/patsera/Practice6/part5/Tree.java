package ua.nure.patsera.Practice6.part5;

public class Tree<E extends Comparable<E>> {
	public Node<E> root;

	public Tree(){
		this.root = null;
	}

	public boolean add(E element) {
		Node<E> newNode = new Node<>(element);
		if (root == null) {
			root = newNode;
			return true;
		}

		Node<E> current = root;
		Node<E> parent = null;

		while(true) {
			parent = current;
			 if (current.data.equals(element)) {
					return false;
				} else
			if (element.compareTo(current.data) < 0) {
				current = current.left;
				if (current == null){
					parent.left = newNode;
					return true;
				}
			} else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return true;
				}
			}
		}
	}

	public boolean add(E[] element) {
		for (E elem : element) {
			Node<E> newNode = new Node<>(elem);
			if (root == null) {
				root = newNode;
				return true;
			}
			Node<E> current = root;
			Node<E> parent = null;
			while(true) {
				parent = current;
				 if (current.data.equals(elem)) {
						return false;
					} else
				if (elem.compareTo(current.data) < 0) {
					current = current.left;
					if (current == null){
						parent.left = newNode;
						return true;
					}
				} else {
					current = current.right;
					if(current == null){
						parent.right = newNode;
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean remove(E element) {
		Node<E> parent = root;
		Node<E> current = root;
		boolean isLeftChild = false;

		while (!current.data.equals(element)) {
			parent = current;

			if(current.data.compareTo(element) > 0) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		if((current.left == null) && (current.right == null)) {
			if (current == root){
				root = null;
			}
			if (isLeftChild == true){
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		}
		else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if(isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if(current.left!=null && current.right!=null){
			Node<E> smallestElement = getSmallestRightElement(current);
			if (current == root) {
				root = smallestElement;
			} else if(isLeftChild) {
				parent.left = smallestElement;
			} else {
				parent.right = smallestElement;
			}
			smallestElement.left = current.left;
		}
		return true;
	}

	public Node<E> getSmallestRightElement(Node<E> deletedNode){
		Node<E> smallestElement = null;
		Node<E> smallestElementParent = null;
		Node<E> current = deletedNode.right;

		while (current != null) {
			smallestElementParent = smallestElement;
			smallestElement = current;
			current = current.left;
		}

		if (smallestElement != deletedNode.right) {
			smallestElementParent.left = smallestElement.right;
			smallestElement.right = deletedNode.right;
		}
		return smallestElement;
	}

	public void print() {

	}

	private static class Node<E> {
		E data;
		Node<E> left;
		Node<E> right;

	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	}
}
