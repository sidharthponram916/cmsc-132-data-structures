package BinaryTrees;

public class MyBST {
	
	private Node root; 
	private Integer size; 
	
	private class Node { 
		Integer val; 
		Node left, right; 
		
		public Node(Integer val) { 
			this.val = val; 
		}
		
		@Override 
		public String toString() { 
			return "" + this.val; 
		}
	}
	
	public MyBST() { 
		size = 0; 
	}
	
	public MyBST(int val) { 
		root = new Node(val); 
		size = 1; 
	}
	
	public Integer size() { 
		return size; 
	}
	
	public boolean contains(Integer n) { 
		return contains(root, n); 
	}
	
	private boolean contains(Node node, Integer n) { 
		if (node == null) { 
			return false; 
		}
		else if (node.val == n) { 
			return true; 
		}
		else { 
			return contains(node.left, n) || contains(node.right, n); 
		}
	}
	
	public void insert(Integer n) { 
		if (root == null) { 
			root = new Node(n); 
		}
		else { 
			root = insert(root, n);  // uses x = change(x); 
		}
	}
	
	// uses x = change(x) 
	
	private Node insert(Node node, Integer n) {
		if (node == null) { 
			System.out.println("INSERTED " + n); 
			node = new Node(n); 
		}
		else if (node.val > n) { 
			System.out.println("LEFT OF " + node.val); 
			node.left = insert(node.left, n); 
		}
		else { 
			System.out.println("RIGHT OF " + node.val); 
			node.right = insert(node.right, n); 
		}
		
		size++;     
	    return node; 
	}
	
	Integer getMax() { 
		if (this.size() == null) return null; 
		
		Node temp = root; 
		
		while (temp.right != null) { 
			temp = temp.right; 
		}
		
		return temp.val; 
	}
	
	Integer getMin() { 
		if (this.size() == null) return null; 
		
		Node temp = root; 
		
		while (temp.left != null) { 
			temp = temp.left; 
		}
		
		return temp.val; 
	}
	
	// left root right 
	
	void inOrder() { 
		 inOrder(root); 
	}
	
	private void inOrder(Node node) { 
		if (node == null) { 
			return; 
		}
		else { 
			inOrder(node.left); 
			System.out.print(node.val + " "); 
			inOrder(node.right); 
		}
	}
	
	public void print() { 		
		  print(root, 0); 
	}
	
	// In order traversal but in Reverse 
	
	private void print(Node node, int level) { 
		if (node == null) { 
			return; 
		}
		else { 
			print(node.right, level + 1); 
			
			for (int i = 0; i < (4 * level); i++) { 
				System.out.print(" ");
			}
			System.out.println(node.val); 
			print(node.left, level + 1); 
		}
	}
	
	public void delete(Integer n) { 
		delete(root, n); 
	}
	
	private void delete(Node node, Integer n) { 		
		if (n > node.val) { 
			if (node.right == null) return; 
			
			if (node.right.val == n) { 
				if (node.right.right == null && node.right.left == null) { 
					node.right = null; 
				}
				else if (node.right.right == null && node.right.left != null) { 
					node.right = node.right.left; 
				}
				else if (node.right.right != null && node.right.left == null) { 
					node.right = node.right.right; 
				}
				else if (node.right.right != null && node.right.left != null) { 
					Node temp = node.right; 
					
					while (temp.left != null) { 
						temp = temp.left; 
					}
					
					Integer deleted = temp.val; 
					
					delete(temp.val); 
					node.right.val = deleted; 
				}
			}
			else { 
				delete(node.left, n);
				delete(node.right, n);
			}
		}
		else { 
			if (node.left == null) return; 
			
			if (node.left.val == n) { 
				if (node.left.right == null && node.left.left == null) { 
					node.left = null; 
				}
				else if (node.left.right == null && node.left.left != null) { 
					node.left = node.left.left; 
				}
				else if (node.left.right != null && node.left.left == null) { 
					node.left = node.left.right; 
				}
				else if (node.left.right != null && node.left.left != null) { 
					Node temp = node.left; 
					
					while (temp.left != null) { 
						temp = temp.left; 
					}
					
					Integer deleted = temp.val; 
					
					delete(temp.val); 
					node.left.val = deleted; 
				}
			}
			else { 
				delete(node.left, n);
				delete(node.right, n);
			}
		}
	}
	
	
}
