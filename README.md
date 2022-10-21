# Dynamic Programming Memoization "All Construct"

The function ‘allConstruct(target, wordBank, memo)‘ that takes in a
target of String, array of String and a memo map as arguments.

* the function returns a 2D array containing all the ways that the target can be constructed by concatenating elements from the wordBank array, each element of the wordBank should represent one combination that construct the target
* Using an element of the array multiple times is allowed.

# Complexity

Assume that:
m = target length
n = wordBank array length

Time Complexity is O(n^m)
Space Complexity is O(m)
