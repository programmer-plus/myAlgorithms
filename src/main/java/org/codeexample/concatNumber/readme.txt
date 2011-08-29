Find all Concatenate Numbers - Unsorted
Question:
Given a list of positive numbers, you can concatenate them into one number in any order, how to print all unique possible numbers? 
In this question, the order of the result is not important. For example, for input 1, 2, 3, 
the output would be a list of 6 integers: 123, 132, 213, 231, 312, 321.  

Answer: This is a classical dynamic programming problems, we can divide the integer list to two parts, a0, and [a, .., an-1], 
so if we know the result of the sub list[a, .., an-1], we can compute result of the whole integer list. Take example, 
for 1, 23, 45. First, we compute the sub-result of 23, 45, the result would be [[23, 45], [45, 23]], 
then for each member of the sub-result, we add 1 to all possible positions. 
First we add 1 to all possible positions of [23, 45], we will get three integer list, [[1, 23, 45], [23, 1, 45], [23, 45, 1]], 
then we add 1 to add 1 to all possible positions of [45, 23], the result would be [1, 45, 23], [45, 1, 23], [45, 23, 1]. 
So the all possible concatenate numbers of 1, 23, 45 would be 12345, 23145, 23451, 14523, 45123, 45231.

Find all Concatenate Numbers - Sorted
In previous post, the returned results are unsorted, what we should do if we want to return these concatenate numbers 
in ascending order?
Question:
Given a unsorted list of positive numbers, you can concatenate them into one number in any order, 
how to print all unique possible numbers in ascending order? 
For example, for input 2, 3, 1(or whatever order), the output would be always a sorted list of 6 integers: 
123, 132, 213, 231, 312, 321.

Answer:
The main logic would still be same as the previous post. The main difference is how to ensure 
the returned concatenate numbers are sorted in ascending order?

One obvious way is that we sort the returned result, but this would take more time, the length of the result would be n!, 
so the time complexity would be O(n!log(n!)). This is undesired.

First we sort the parameter list in ascending order, then we assume the sub-result of a[1] to a[n-1] is sorted ascending order. 
When we add a[0] to all possible positions of previous sub result, what we need do to make the new list still sorted?

Take instance, for input, 3, 2, 1, first we sort them to 1, 2, 3, and assume the sub result of 2, 3 is sorted: [2,3], [3,2].
Now when add 1 to the zero index of [2,3], [3, 2], and we get [1,2,3], [1,3,2].
Now we loop each element, for each element, we add 1 to the possible positions from 1 to 2(length of the each element), 
so we get [2, 1, 3], [2, 3, 1], and [3, 1, 2], [3, 2, 1].

Site:
Please see 
http://programer-tips.blogspot.com/2011/08/is-array-successive.html
http://programer-tips.blogspot.com
https://github.com/programer-tips/myACP