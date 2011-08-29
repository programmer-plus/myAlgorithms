Whether two Integer arrays from same sequence
Question:
There is a list of int arrays; the next int array is the explanation of the previous one.
For example, if the first one is [1], the next int array would be [1, 1], it means the previous array has a number one, the next array would be [2, 1], means the previous array has two one, and so on.
1
1 1
2 1
1 2 1 1
1 1 1 2 2 1
3 1 2 2 1 1

So the question would be: given a two int arrays A and B, you need determine whether they are in the same sequence? 
In other word, whether you can induce from A to B, or from B to A?

Answer:
It seems that we can just induce from A, and get its next int array, and its next's next array, if one int array equals B, 
then we can return true.
But this problem is that what if B is not in same sequence of A, when we stop?
We can't know.

In this problem, we can think reversely, if we starts from A, and get A's previous array, if it equals B, we can return true, 
if not, we continue. But if not, when we stop?

The first case: we can't conclude previous array from the curry array:
Two cases:
1.	When the current int array has odd numbers, we stop, as it's impossible to get its previous array. 
The reason is simple: (a[i], b[i]) describes one item of previous array, if current array has odd numbers, (a0, b0) .. (a[n], b[n]), a[n+1], a[n+1] can't describe one item of previous array.
2.	When the current int array has even digits, but have some invalid pairs, such as (0 1). 
Another case: if we deduce from A, and get it's parent, and its parent's parent, what if we get A again, if we continue, 
it will loop for ever. So in this case, we should return false, why?

A's parent array A[p'] is unqiue, A[p']'s parent A[p''] is also unique.
..
A[p'']
A[p']
A <--
..
...
A[p'']
A[p']
A <--
So the whole array sequence would be a loop. if we search from A, and meet A again, and no B during the path. 
So B would not be in the sequence.

Also remember that if the previous process determines whether B is in front of A in one sequence, 
we still need determine whether A is in front of B in some sequence.

Site:
Please see 
http://programer-tips.blogspot.com/2011/08/is-array-successive.html
http://programer-tips.blogspot.com
https://github.com/programer-tips/myACP