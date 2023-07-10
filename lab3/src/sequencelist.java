/*
* A sequencelist <E> class extends LList<E> class to store the DNA or RNA
* sequence. Overwrite the toString() method. Add an extra variable type T.
* which is an enum.
* */
class sequencelist<E> extends LList<E> implements List<E>  {
    private Link<E> head;         // Pointer to list header
    private Link<E> tail;         // Pointer to last element
    protected Link<E> curr;       // Access to current element

    type T=type.empty;        //The type sequence store in the list

    int cnt;		      // Size of list


    sequencelist(int size) { this(); }   // Constructor -- Ignore size
    sequencelist() {
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }


    public void clear() {
        head.setNext(null);         // Drop access to links
        curr = tail = head = new Link<E>(null); // Create header
        cnt = 0;
    }


    public void insert(E it) {
        curr.setNext(new Link<E>(it, curr.next()));
        if (tail == curr) tail = curr.next();  // New tail
        cnt++;
    }


    public void append(E it) {
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }


    public E remove() {
        if (curr.next() == null) return null; // Nothing to remove
        E it = curr.next().element();         // Remember value
        if (tail == curr.next()) tail = curr; // Removed last
        curr.setNext(curr.next().next());     // Remove from list
        cnt--;				// Decrement count
        return it;                            // Return value
    }


    public void moveToStart()
    { curr = head; }

    public void moveToEnd()
    { curr = tail; }


    public void prev() {
        if (curr == head) return; // No previous element
        Link<E> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }


    public void next()
    { if (curr != tail) curr = curr.next(); }


    public int length() { return cnt; }


    public int currPos() {
        Link<E> temp = head;
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }


    public void moveToPos(int pos) {
        assert (pos>=0) && (pos<=cnt) : "Position out of range";
        curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
    }


    public E getValue() {
        if(curr.next() == null) return null;
        return curr.next().element();
    }

   //Overwrite the toString()
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







}






