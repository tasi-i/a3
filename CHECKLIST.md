# CSC 210 Data Structures
## Assignment 3 Checklist

Listed below are various aspects of the assignment.  When you turn in
your work, please indicate the status of each item

- YES: indicates that the item is fully complete
- NO: indicates that the item is not attempted
- PART: indicates that the item is attempted but not fully complete

## Grade-ability Check
Please confirm the following minimum criteria are met:

___yes__ Program compiles without errors 

___yes__ All required files included with submission (including basic readme info and completed checklist file) 

____yes_ README.md contains answers to any questions and your reflection on the assignment 

**Assignments that do not meet the above criteria cannot be graded**

## Coding Points:

___yes__ 1 pt: `SLL<T>` implements `Iterable<T>` and provides `iterator()`

_yes____ 1 pt: `DynamicArray<T>` implements `Iterable<T>` and provides `iterator()`

__yes___ 2 pt: `SLL` iterator is correct (node-walking, correct order, does not modify structure)

__yes___ 2 pt: `DynamicArray` iterator is correct (index-walking, correct order, does not modify structure)

__yes___ 1 pt: Iterator contract followed (`next()` throws `NoSuchElementException`; `iterator()` returns a fresh iterator starting at the beginning)

__yes___ 1 pt: `splitCopy(int index)` implemented for `SLL` (allocates new nodes; original unchanged)

_yes____ 1 pt: `splitCopy(int index)` implemented for `DynamicArray` (allocates new backing array; original unchanged)

___yes__ 1 pt: `splitTransfer(int index)` implemented for `SLL` (detaches/relinks existing nodes; original mutated to prefix)

__yes___ 1 pt: `splitTransfer(int index)` implemented for `DynamicArray` (moves references; original mutated to prefix)

__yes___ 1 pts: Program throws appropriate exceptions

__yes___ 1 pts: Benchmarking write-up included in README (brief observations comparing copy vs transfer and array vs linked list, based on `Timer.java` output)


## Code Hygiene (4 pts):

__yes__ 1 pt: No copy/paste near-duplicate code blocks for the same behavior (reusing your code is better for everyone!)

__yes___ 1 pt: Common logic is factored into helpers 

__yes___ 1 pt: Methods are short enough to read (no 100-line monster methods unless justified)

__yes___ 1 pt: Names communicate intent (especially for helper methods)


## General Items (6 pts):

___yes__ 1 pt: Student-written code compiles without warnings that indicate correctness problems

___yes__ 2 pts: Student-provided code runs and executes without unexpected crashing

__yes___ 2 pt: Javadoc builds without errors/warnings

___yes__ 1 pt: Indentation and other style norms are followed
