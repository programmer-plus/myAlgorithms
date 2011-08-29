Construct Max Number from an Integer Array
Question:
You are given a list of positive int numbers, find out the max number that can be comprised of these input int numbers. 

Example: 
For input 1, 2, 3, the max number would be 321.
For 8, 87, 896, the max number would be 896887.

Answer:
For example, if the numbers are 24, 243, 2435? The max number should be [2435][243][24].
Is there a way we can sort this array, and get a new array: [2435, 243, 24]?

When we sort this array, we can define a comparator. When it compares two numbers (say a and b), 
if the two numbers has same digit numbers, we directly compare it, if they have different digit numbers 
(say a has less digit numbers than b), for the number (a in this case) has less digit numbers, 
we would get a new int number (get a new int a0 from b) by right padding it with the original digit numbers, 
and get a new number a0, then compare a0 and b.

So when compare 24 and 2435, we would think we are actually comparing 2[424] and 2435, so in the descending sorted array, 
2535 would come before 24. 

So the descending sorted array would be [2435, 243, 24], as 2435 > 243[2] > 24[24]; 
the generated max number would be [2435][243][24], this would be exactly what we expect.

Site:
Please see 
http://programer-tips.blogspot.com/2011/08/is-array-successive.html
http://programer-tips.blogspot.com
https://github.com/programer-tips/myACP