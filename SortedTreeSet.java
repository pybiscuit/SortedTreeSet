class SortedTreeSet implements SortedTreeSetInterface{
    private Person data;
    private SortedTreeSet left;
    private SortedTreeSet right;
	private String stringOuput = "Name    Height (cm)    Weight (kg)";

	// empty constructor used for intialization.
	public SortedTreeSet() {

    }

	// constructor that sets the root node.
    public SortedTreeSet(Person data) {
        this.data = data;
    }

	// returns data jor the current node.
    @Override
    public Person getPerson() {
        return this.data;
    }

	// checks if the current node has a left reference for a node.
    @Override
    public boolean hasLeft() {
        return this.left != null;
    }

	// sets the left reference for the current node.
    @Override
    public void setLeft(SortedTreeSet left) {
        this.left = left;
    }

	// returns the left reference for the current node.
    @Override
    public SortedTreeSet getLeft() {
        return this.left;
    }

	// checks if the current node has a right reference for a node.
    @Override
    public boolean hasRight() {
        return this.right != null;
    }

	// sets the right reference for the current node.
    @Override
    public void setRight(SortedTreeSet right) {
        this.right = right;
    }

	// returns the right reference for the current node.
    @Override
    public SortedTreeSet getRight() {
        return this.right;
    }

	// adds a reference to a new node to the current node.
	// uses compareToIgnoreCase (returns a positive or negative number based on
	// the lexicographical value of the two string [alphabatizes insertion])
	// https://www.geeksforgeeks.org/java/java-string-comparetoignorecase-method/
    @Override
    public void add(Person p) {
        int compareName = p.getName().compareToIgnoreCase(data.getName());
        if (compareName < 0) {
            if (this.hasLeft()) {
                left.add(p);
            } else {
                this.setLeft(new SortedTreeSet(p));
            }
        } else if (compareName > 0) {
            if (this.hasRight()) {
                right.add(p);
            } else {
                this.setRight(new SortedTreeSet(p));
            }
        }
    }

	// Traverse the binary tree setting the output string for the toString method.
	// Implements in order traversal: https://www.geeksforgeeks.org/dsa/binary-tree-traversal/
	public void treeTraversal(SortedTreeSet root) {
		if (root == null) return;

		treeTraversal(root.left);
		
		int nameSpace = 8 - root.data.getName().length();
		int spaceCount = (root.data.getHeight() > 100) ? 10: 11;

		this.stringOuput = this.stringOuput + "\n" 
			+ root.data.getName() + " ".repeat(nameSpace)
			+ root.data.getHeight() + " ".repeat(spaceCount)
			+ root.data.getWeight();

		treeTraversal(root.right);

	}

	@Override
    public String toString() {
		this.treeTraversal(this);
		return this.stringOuput;
    }
}
