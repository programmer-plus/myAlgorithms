Is Array Successive?
Question:
Given an unordered int list, except 0, each number can appear only once, 0 can be regarded as any number. 
Now we need determine whether the digits from the list are logically successive, 

For example, 
3, 2, 1 would be considered as successive.
0, 3, 1 also is successive, as 0 can be regarded as 2.
0, 0, 3, 1 also is successive as 0, 0 can be regarded as (0, 2), or (2, 4).

Answer:
First, simplify this question, if there can be only one 0, and can't be considered as any number. 
How we determine whether the array is successive?

In this case, we can get the maximum and minimum of this array, if (max - min) = (length of the array -1), 
then this array is considered as successive. This is very straightforward.

So back to the original problem, suppose the length of the array is n, and there is x 0, and thus n-x non-zeros, 
so we can get the inequality:  if (max - min) <= (n -1), this array is successive.
0, 3, 1 ==> (3-1) = len -1 = 2
0, 0, 3, 1 ==> (3-1) < len - 1 = 3

Site:
Please see 
http://programer-tips.blogspot.com/2011/08/is-array-successive.html
http://programer-tips.blogspot.com