package com.sample.collections;

public class CustomSingleLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T data) {
		Node n = new Node();
		n.data = data;
		
		if(head == null) {
			head = n;
			tail = n;
		} else {
			tail.nextRef = n;
			tail = n;
		}
		n.nextRef = null;
	}
	
	public void delete() {
		if(head == null) {
			System.out.println("List already empty");
		} else {
			Node tmp = head;
			System.out.println("In delete method");
			while(tmp != null) {
				if(tmp.nextRef == tail) {
					tmp.nextRef = null;
					tail = tmp;
					System.out.println("Deleted");
				}
				tmp = tmp.nextRef;
			}
		}
	}
	
	public void show() {
		if (head != null) {
			Node tmp = head;
			System.out.println("In show method");
			while(tmp != null) {
				System.out.println(tmp.data);
				tmp = tmp.nextRef;
			}
			
		} else {
			System.out.println("List is empty");
		}
	}
	
	public static void main(String[] args) {
		CustomSingleLinkedList<Integer> list = new CustomSingleLinkedList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list.delete();
		list.show();
	}

}

class Node<T> {
	T data;
	Node nextRef;
	
	@Override
	public String toString() {
		return super.toString();
	}
}