/*  Starter code of Linked data structure Lab
 *  CSIT 150 
 *  This source file contains the code for  Linkedlist
 *      and  ListElement
 *
 *  Provided by C.Anderson
 *  REVISED 11-15-15
 *
 *  Revised by S Harms
 *  April 2017
 */


/**
 *
 * @author zwienerja
 */
public class LinkedList {

    private String label;
    private ListElement firstItem;

    /**
     * creates a linked list
     * @param name
     */
    public LinkedList(String name) {
        label = name;
    }

    /**
     * checks if the list is empty
     * @return boolean
     */
    public boolean isEmpty() {
        if (firstItem == null)
            return true;
        return false;
    }

    /**
     * adds a new element to the end of the list
     * @param newElementText
     * @return boolean
     */
    public boolean addElement(String newElementText) {
        ListElement newElement = new ListElement(newElementText);
        if (isEmpty()) {
            firstItem = newElement;
            return true;
        } else {
            ListElement currentElement = firstItem;
            while (currentElement.hasNext()) {
                currentElement = currentElement.getNextItem();
            }
            currentElement.setNextItem(newElement);
            return true;
        }
    }//  end add element

    /**
     * adds a new element at an index of the list
     * @param newElementText
     * @param index
     * @return boolean
     */
    public boolean addElement(String newElementText, int index) {
        if (isEmpty() && index != 0)
            return false;
        if (index > length() - 1)
            return false;
        ListElement newElement = new ListElement(newElementText);
        int counter = 0;
        ListElement currentElement = firstItem;
        do {
            currentElement = currentElement.getNextItem();
            counter++;
        }
        while (counter < index - 1);
        if (currentElement.hasNext()) {
            newElement.setNextItem(currentElement.getNextItem());
            currentElement.setNextItem(newElement);
            return true;
        } else {
            currentElement.setNextItem(newElement);
            return true;
        }
    }

    /**
     * checks to see if a string is in the list
     * @param testString
     * @return boolean
     */
    public boolean isInList(String testString) {
        ListElement currentElement = firstItem;
        if (isEmpty()) {
            return false;
        } else if (firstItem.getItemText().equals(testString)) {
            return true;
        }
        while (currentElement.hasNext()) {
            if (currentElement.getItemText().equals(testString)) {
                return true;
            }
            currentElement = currentElement.getNextItem();
        }
        return false;
    }

    /**
     * adds a element at the start of the list
     * moves other items back one spot
     * @param newElement
     * @return boolean
     */
    public boolean addElementAtHead(String newElement){
        ListElement newFirstElement = new ListElement(newElement);
        ListElement currentElement = firstItem;
        if (isEmpty()) {
            firstItem = newFirstElement;
            return true;
        }
        newFirstElement.setNextItem(currentElement);
        firstItem = newFirstElement;
        return true;
    }

    /**
     * returns the string of the first element of the list
     * removes that first element from the list
     * @return firstElement
     */
    public String pop(){
        if (isEmpty()){
            return null;
        }
        String firstElement = firstItem.getItemText();
        firstItem = firstItem.getNextItem();
        return firstElement;
    }

    /**
     * removes a certain element in the list at index
     * @param index
     * @return boolean
     */
    public boolean remove (int index){
        if (isEmpty())
            return false;
        if (index > length() - 1)
            return false;
        int counter = 0;
        ListElement currentElement = firstItem;
        do {
            currentElement = currentElement.getNextItem();
            counter++;
        }
        while (counter < index - 1);
        if (currentElement.getNextItem().hasNext()){
            ListElement temp = currentElement.getNextItem();
            currentElement.setNextItem(temp.getNextItem());
            return true;
        }
        else{
            currentElement.setNextItem(null);
            return true;
        }
    }

    /**
     * returns the length of the list
     * @return length
     */
    public int length(){
        int counter = 0;
        ListElement currentElement = firstItem;
        if (isEmpty()) {
            return counter;
        }
        else
            counter++;
        while (currentElement.hasNext()) {
            currentElement = currentElement.getNextItem();
            counter++;
        }
        return counter;
    }

    /**
     * returns entire list as a String
     * @return String
     */
    public String toString() {
        return label + "\n" + firstItem.toString();
    }

    /**
     * returns the label as a string
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * sets the label to the inputted label
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * returns the first item of the list
     * @return firstItem
     */
    public ListElement getFirstItem() {
        return firstItem;
    }

    /**
     * sets the first element to the parameter
     * @param firstItem
     */
    public void setFirstItem(ListElement firstItem) {
        this.firstItem = firstItem;
    }

// end of LinkedList class
//////////////////////////////////////////////////
//  PRIVATE CLASS  ///////////////////////////////
//////////////////////////////////////////////////

    /**
     * ListElement class
     */
    private class ListElement {

        private String itemText;
        private ListElement nextItem;

        /**
         * creates a new listElement
         * @param el
         */
        public ListElement(String el) {
            itemText = el;
        }

        /**
         * checks to see if the currentItem has a nextItem
         * @return boolean
         */
        public boolean hasNext() {
            if (nextItem == null)
                return false;
            return true;
        }

        /**
         * recursively returns the text of the elements
         * @return content
         */
        public String toString() {
            String content = itemText;
            if (hasNext())
                content += "\n" + nextItem.toString();
            return content;
        }

        /**
         * gets the next list element
         * @return nextItem
         */
        public ListElement getNextItem() {
            return nextItem;
        }

        /**
         * gets the text of the item
         * @return itemText
         */
        public String getItemText() {
            return itemText;
        }

        /**
         * sets the items text to the string parameter
         * @param itemText
         */
        public void setItemText(String itemText) {
            this.itemText = itemText;
        }

        /**
         * sets the next item to the inputted ListElement
         * @param nextItem
         */
        public void setNextItem(ListElement nextItem) {
            this.nextItem = nextItem;
        }

    }
}
