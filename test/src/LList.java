/** Source code example for "A Practical Introduction to Data
 Structures and Algorithm Analysis, 3rd Edition (Java)"
 by Clifford A. Shaffer
 Copyright 2008-2011 by Clifford A. Shaffer
 */

/** Linked list implementation */
class LList<E> implements List<E> {
    private Link<E> head;         // Pointer to list header
    private Link<E> tail;         // Pointer to last element
    protected Link<E> curr;       // Access to current element

    boolean isRNA;

    boolean isDNA;
    int cnt;		      // Size of list

    /** Constructors */
    LList(int size) { this(); }   // Constructor -- Ignore size
    LList() {
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    /** Remove all elements */
    public void clear() {
        head.setNext(null);         // Drop access to links
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }

    /** Insert "it" at current position */
    public void insert(E it) {
        curr.setNext(new Link<E>(it, curr.next()));
        if (tail == curr) tail = curr.next();  // New tail
        cnt++;
    }

    /** Append "it" to list */
    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }

    /** Remove and return current element */
    public E remove() {
        if (curr.next() == null) return null; // Nothing to remove
        E it = curr.next().element();         // Remember value
        if (tail == curr.next()) tail = curr; // Removed last
        curr.setNext(curr.next().next());     // Remove from list
        cnt--;				// Decrement count
        return it;                            // Return value
    }

    /** Set curr at list start */
    public void moveToStart()
    { curr = head; }
    /** Set curr at list end */
    public void moveToEnd()
    { curr = tail; }

    /** Move curr one step left; no change if now at front */
    public void prev() {
        if (curr == head) return; // No previous element
        Link<E> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }

    /** Move curr one step right; no change if now at end */
    public void next()
    { if (curr != tail) curr = curr.next(); }

    /** @return List length */
    public int length() { return cnt; }

    /** @return The position of the current element */
    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    /** Move down list to "pos" position */
    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=cnt) : "Position out of range";
        curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
    }

    /** @return Current element value */
    public E getValue() {
        if(curr.next() == null) return null;
        return curr.next().element();
    }
// Extra stuff not printed in the book.

    /**
     * Generate a human-readable representation of this list's contents
     * that looks something like this: < 1 2 3 | 4 5 6 >.  The vertical
     * bar represents the current location of the fence.  This method
     * uses toString() on the individual elements.
     * @return The string representation of this list
     */
    public String toString()
    {
        StringBuffer out = new StringBuffer((length()));
        moveToStart();
        for (int i = 0; i < length(); i++) {
            out.append(getValue());
            next();
        }
        return out.toString();
    }

    public void setRNAture(){
        isRNA=true;
    }
    public void setRNAfalse(){
        isRNA=false;
    }
    public void setDNAtrue(){
        isRNA=true;
    }
    public void setDNAfalse(){
        isRNA=false;
    }
    public static void main(String[] args) {
        LList<Integer> list = new LList<>();
        System.out.println("Initial list: " + list);
        list.append(3);
        System.out.println("After appending 3: " + list);
        list.moveToEnd();
        System.out.println("After moving to the end: " + list);
        list.insert(8);
        System.out.println("After inserting 8: " + list);
        list.append(10);
        System.out.println("After appending 10: " + list);
        list.insert(2);
        System.out.println("After inserting 2: " + list);
        list.next();
        System.out.println("Moving to the next element");
        System.out.println(list.length());
        System.out.println("Final list: " + list);
    }




}






