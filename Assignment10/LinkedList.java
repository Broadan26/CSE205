// Assignment #: Arizona State University CSE205 #10
//         Name: Brandon
//    StudentID: 
//      Lecture: T/TH 4:30-5:45pm
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.

import java.util.NoSuchElementException;

public class LinkedList
{
    //The only instance variable that points to the first node
    private Node first;

    //nested class to represent a node
    private class Node
    {
        public Object data;
        public Node next;
    }

    // Constructs an empty linked list.
    public LinkedList()
    {
        first = null;
    }

    //Returns the first element in the linked list.
    public Object getFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    //Removes the first element in the linked list.
    public Object removeFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        return element;
    }

    //Adds an element to the front of the linked list.
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

    //toString() method prints the elements out from front to tail
    @Override
    public String toString()
    {
        ListIterator iterator = listIterator();
        String result  = "{ ";
        while (iterator.hasNext())
        {
           result += iterator.next() + " ";
        }
        result += "}\n";

        return result;
    }

    //size() method returns the number of nodes inside this LinkedList
    public int size()
    {
        ListIterator iterator = listIterator();
        int count = 0;
        
        while (iterator.hasNext())
        {
           count++;
           iterator.next();
        }
        
        return count;
    }

    //searchElement() method returns the index of the first occurrence of the parameter object
    //in the linked list if it exists. It returns -1 if it does not exit.
    public int searchElement(Object element)
    {
        int index = 0;
        ListIterator iterator = listIterator();

        //Loop to find the element in the LinkedList
        while(iterator.hasNext())
        {
            if(iterator.next().equals(element))
                return index;
            
            index++;
        }
        //If the loop doesn't return, send -1 for not found
        return -1;
    }

    //getElement() method returns the element at the parameter index
    //If the index is out of bounds, throw an IndexOutOfBoundsException.
    public Object getElement(int index)
    {
        try
        {
            ListIterator iterator = listIterator();

            for (int i = 0; i < index; i++)
            {
                iterator.next();
            }

            return iterator.next();
        }
        catch(IndexOutOfBoundsException e)
        {
            throw e;
        }
    }

    //setElement() method sets the parameter object at the parameter index in the linked list.
    //If the index is out of bounds, throws an IndexOutOfBoundsException
    public void setElement(int index, Object element)
    {
        try
        {
            //Setup iterator and a temporary object for location
            ListIterator iterator = listIterator();
            Object temp = null; 
            if(size() > index)
                temp = getElement(index);

            //Search for its location
            while(iterator.hasNext())
            {
                if(iterator.next().equals(temp))
                    iterator.set(element);
                iterator.next();
            }

        }
        catch(IndexOutOfBoundsException e)
        {
            throw e;
        }
    }
   
    //insertElement() method inserts the parameter object at the parameter index.
    //If the index is out of bounds, throws an IndexOutOfBoundsException
    //Note: the element can be inserted at the end, i.e. inserted at size() index/position
    public void insertElement(int index, Object element)
    {
        try
        {
            //Setup iterator and traverse it
            ListIterator iterator = listIterator();
            
            //Search for index spot
            for(int i = 0; i < index; i++)
            {
                if(iterator.hasNext())
                    iterator.next();
            }
            //
            if(iterator.hasNext())
            {
                Object temp = iterator.next();
                iterator.set(element);
                while(iterator.hasNext())
                {
                    Object temp2 = iterator.next();
                    iterator.set(temp);
                    temp = temp2;
                }
                iterator.add(temp);
            }
            else
                iterator.add(element);
        }
        catch(IndexOutOfBoundsException e)
        {
            throw e;
        }
        catch(NoSuchElementException e)
        {
            throw e;
        }
    }
   
    //removeElement()method removes and returns element at parameter index and throw
    //an IndexOutOfBoundsException if the index is out of bounds
    public Object removeElement(int index)
    {
        try
        {
            //Setup iterator and a temporary object for location
            ListIterator iterator = listIterator();
            Object temp = getElement(index);
            int count = 0;
            
            //Search for its location
            while(count <= index && iterator.hasNext())
            {
                iterator.next();
                count++;
            }
            
            //Remove the element from LinkedList
            iterator.remove();
            
            return temp;
        }
        catch(IndexOutOfBoundsException e)
        {
            throw e;
        }
    }

    //countHowMany(Object) method returns the number of occurences of the parameter object in the LinkedList
    public int countHowMany(Object searchedObject)
    {
        ListIterator iterator = listIterator();
        int count = 0;
        
        while(iterator.hasNext())
        {
            if(iterator.next().equals(searchedObject))
                count++;
        }
        return count;
    }

    //removeDuplicate() method removes all occurences of the parameter objects from the LinkedList
    public void removeDuplicate(Object removedObject)
    {
        ListIterator iterator = listIterator();
        
        while(iterator.hasNext())
        {
            if(iterator.next().equals(removedObject))
            {
                iterator.remove();
            }
        }
    }

    //insertAtFront(Object, int) method inserts the parameter object number of times at the front of the linked list
    //for example, a call of insertAtFront("A", 3) will insert string "A" three times in front of the linked list.
    public void insertAtFront(Object element, int howManyTimes)
    {
        //Create the iterator
        ListIterator iterator = listIterator();
        
        //Add element to LinkedList n number of times
        for(int i = 0; i < howManyTimes; i++)
        {
            iterator.add(element);
        }
    }

    //appendAtEnd(Object, int) method appends the parameter object number of times at the end of the linked list
    //for example, a call of appendAtEnd("B", 3) will append string "B" three times at the end of the linked list.
    public void appendAtEnd(Object element, int howManyTimes)
    {
        //Create the iterator
        ListIterator iterator = listIterator();
        
        //Shift iterator position to the end of the LinkedList
        for(int i = 0; i < size(); i++)
        {
            iterator.next();
        }
        
        //Add the element to the end n number of times
        for(int i = 0; i < howManyTimes; i++)
        {
            iterator.add(element);
        }
    }

    //insertInFront(Object element1, Object element2) method insert the
    //second parameter object, i.e. element2 immediately in front of the
    //first occurence of first parameter object - element1.
    //if element1 is not found inside the linked list, then insert element2
    //at the front/head of the linked list.
    public void insertInFront(Object element1, Object element2)
    {
        //Create dual ListIterators to track location
        ListIterator iterator = listIterator();
        ListIterator iterator2 = listIterator();
        
        //Check for existence of element1
        boolean check = false;
        Object previous = null;
        
        while(iterator.hasNext())
        {
            if(iterator.next().equals(element1))
            {
                check = true;
                break;
            }
            previous = iterator2.next();
        }
        //If element1 doesn't exist, add to front
        if(check == false)
            addFirst(element2);
        //If element1 does exist, swap nodes around
        else
        {
            previous = iterator2.next();
            iterator.set(element2);
            while(iterator.hasNext())
            {
                Object extra = iterator.next();
                iterator.set(previous);
                previous = extra;
            }
            iterator.add(previous);
        }
    }

    //appendAfter(Object element1, Object element2) method appends the second parameter object, i.e. element2 right after
    //the first occurence of first parameter object,
    //if element1 is not inside the linked list, then append element2 at the front/head of the linked list.
    public void appendAfter(Object element1, Object element2)
    {
        //Create ListIterators to track location
        ListIterator iterator = listIterator();
        
        //Check for existence of element1
        boolean check = false;
        Object previous = null;
        while(iterator.hasNext())
        {
            if(iterator.next().equals(element1))
            {
                check = true;
                break;
            }
        }
        //If element1 doesn't exist, add to front
        if(check == false)
            addFirst(element2);
        //If element1 does exist, add it behind current location
        else
        {
            iterator.add(element2);
        }
    }

    //reverse(int howMany) reverse the first parameter number of elements inside the linked list.
    //for example, if the original linked list is { A B C D E F G }, a call of reverse(3) will
    //change the linked list to { C B A D E F G }. Note #1: you need to consider the boundary value, i.e.
    //cases where howMany <= 0 or howMany > size()
    //Note #2: reverse(size()) should reverse the whole linked list
    public void reverse(int howMany)
    {
        ListIterator iterator = listIterator();
        
        if(size() > 1)
        {
            int ceiling = howMany - 1;
            int floor = 0;
            iterator.next();
            do
            {
                ListIterator iterator2 = listIterator();
                
                Object temp1 = getElement(floor);
                Object temp2 = getElement(ceiling);
                
                iterator.set(temp2);
                iterator.next();
                
                for(int i = 0; i < ceiling + 1; i++)
                {
                    iterator2.next();
                }
                iterator2.set(temp1);
                floor++;
                ceiling--;
                
            } while(ceiling > (howMany/2) - 1);
        }
    }

//***********Don't change the following LinkedListIterator class******************

    //Method creates an iterator on the current LinkedList
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    //nested class to define its iterator
    private class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous;

        // Constructs an iterator that points to the front
        // of the linked list.   of the linked list.
        public LinkedListIterator()
        {
           position = null;
           previous = null;
        }

        // Moves the iterator past the next element, and returns
        // the traversed element's data.
        public Object next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            previous = position; // Remember for remove

            if (position == null)
                position = first;
            else
                position = position.next;

            return position.data;
        }

        // Tests if there is an element after the iterator position  position
        public boolean hasNext()
        {
             if (position == null)
              return first != null;
             else
             return position.next != null;
         }

        // Adds an element after the iterator position
        // and moves the iterator to the inserted element.
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                 Node newNode = new Node();
                 newNode.data = element;
                 newNode.next = position.next;
                 position.next = newNode;
                 position = newNode;
            }
            previous = position;
        }

        // Removes the last traversed element. This method may
        // only be called after a call to the next() method.
        public void remove()
        {
            if (previous == position)
                throw new IllegalStateException();

            if (position == first)
            {
                removeFirst();
            }
            else
            {
                previous.next = position.next;
            }
            position = previous;
        }

        // Sets the last traversed element to a different value
        public void set(Object element)
        {
            if (position == null)
                 throw new NoSuchElementException();
            position.data = element;
        }
    } //Ends LinkedListIterator Class
} //Ends LinkedList Class