Peter Nie
email:jnie7@u.rochester.edu

DataItem class:
                1.one constructor method, set the iData variable
                2.getter function getKey(), return the iData variable

HashTable class:
                1.There are two variable in the class, the arraySize and the array store Data Item.
                2.HashTable(): the constructor method to set up the class.
                3.getSize() & getHashArray(): two getter method return the variable in the class.
                4.displayTable(): iterate the array and print it out
                5.hashFunction(): return the key mod array size
                6.insert(): find the position for the item from hashcode first and keep going +1 every time. until there is empty position.
                7.delete(): use hashcode to find the item and delete it.
                8.find(): use hashcode to find the item in the array
                9.rehash(): double the array size and find the next prime number be the array size. put the item back to the new array
                10.isPrime(): helper method in order make sure the number is prime number.

HashTableApp class:
                main():
                        1.create a HashTable have 17 size.
                        2.use Scanner to read the user input.
                        3.use switch to call the appropriate method according the user input.
                        4.insert(),find(),delete() need to read the usr input one more time
                        5.after each while loop check the factor load in the HashTable, if out of 0.75 we call rehash() method.