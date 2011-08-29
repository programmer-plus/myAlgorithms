Find Strings starting with Prefix
We are all familiar with the auto completion function provided by IDE, for example, in eclipse, if we type Collections.un, 
then eclipse would list all methods that start with "un" such as unmodifiableCollection, unmodifiableList etc.

So we have the following question:
You have a list of string, you need find all strings that starts with prefix provided repeatedly, how to do this efficiently?

Answer:
We need to preprocess the list of string, so later we can quickly search it.

One way is to sort the string list by alphabetical order, then when search with the prefix (say app), 
we binary search this list and get a lower index whose string is larger than "pp" and get a higher index 
whose string is less than "pr" then all strings between the lower index and higher index[lower index, higher index) 
are the strings that starts with the prefix.
Each query would take O(longn), n is the length of the string list.

Another better way is to create a tree from the string list, for example, for string "append", it would look like this:
  [root node(flag)]
         /
        a
       / \
     [ST] p
          \
          p -- return all strings from this sub tree
         /
         e
         \
         n
        / \
        d [Sub Tree]
       /
[leaf node(flag)]
So when we search all strings that starts with "app", it can search this tree, and get all strings of the p node, 
the time complexity depends on the length of the prefix, having nothing to do with the length of the string list. 
This is much better.


Site:
Please see 
http://programer-tips.blogspot.com/2011/08/is-array-successive.html
http://programer-tips.blogspot.com
https://github.com/programer-tips/myACP