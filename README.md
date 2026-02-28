# A3 Iteration and Copy-Style Slicing

## Basic Information

Your name:Anastasija Radenkovic

Other students you worked with, including TAs:n/a

If anyone was particularly helpful, please give them a shout-out here:


## References

Any references or resources used besides JavaDoc and course materials:n/a

If you used generative AI, how did you use it? What role did it play in your learning?


## Questions to Answer

1. Which got slower faster as `N` increased: `get(mid)` or `add(0, x)` on `SLL`? Why?

`get(mid)` got slower faster because SLL must traverse from the head to reach the middle,
which takes O(n) time. As N increases, traversal cost increases linearly. `add(0, x)` is O(1) because it only updates the head pointer.

2. Compare `splitCopy` vs `splitTransfer` for `DynamicArray` and `SLL`: what dominates the runtime in each?

SLL
Both operations are O(n).

- splitCopy allocates new nodes and walks the tail.
- splitTransfer relinks pointers (no new nodes).
- Transfer is typically slightly faster because it avoids allocation.

DynamicArray
Both operations are O(n).

- splitCopy copies references into a new array.
- splitTransfer also copies references but additionally clears old slots.
- Array copying is better for runtime in both cases.


## Reflection

Please provide a brief reflection about your experience with this assignment. What was easiest? What was hardest? How did your understanding of iteration and cost models evolve?

The easiest part was implementing the DynamicArray iterator because it is simple index advancement. The hardest part was  implementing splitTransfer or SLL without accidentally creating new nodes.
This assignment helped clarify how representation affects cost:
- Linked lists are fast at head operations but slow at random access.
- Arrays are fast at random access but expensive for shifting.
- Even when asymptotic complexity matches, constants differ.