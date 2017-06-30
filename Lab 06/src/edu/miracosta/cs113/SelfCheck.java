package edu.miracosta.cs113;

/** Self-Check Exercises 1-5 Section 2.5 Pg. 98
 * 1. The big-O for the single linked list get operation is:
 * 		Constant Time or O(n)
 * 		While loop = n
 *      increment = 1
 *      O(n + 1) simplifies to O(n)
 * 2. The big-O for the set operation is:
 * 		Constant Time or O(n)
 * 3. The big-O for all the add methods are:
 * 		add to the front: O(1)
 * 		add to the back: O(n)
 * 		add to the middle/after: O(n)
 * 4. (See PDF)
 * 5A. This statement will add a node to the front of the linked list and set the head reference equal to that node.
 * 5B. First sets the value of nodeRef equal to the reference of the second node in the linked list.
 * 		Then sets the value of nodeRef equal to the reference for the 4th node in the linked list.
 * 5C. First sets the value of nodeRef equal to the head reference.
 * 		Loops threw the list to the last node and sets nodeRef equal to that reference.
 * 		Finally adds a new node to the end of the linked list.
 * 5D. First sets the value of nodeRef equal to the head reference.
 * 		Loops threw the list to the last node while checking for null, and the data "Harry"
 * 		IF it finds a node with the data "Harry" stored in it, it sets that node to "Sally"
 * 		Then it creates a new node with data "Harry" in it, and places it after sally in the list.
 */