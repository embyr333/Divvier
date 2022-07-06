# Divvier

Program I wrote ~2015 afer wondering how to take as near as possible to half from five pieces of frozen foodstuff of unequal size. It aims to allow division of a collection of numbers into two subcollections as evenly as possible. There are probably equivalent or better tools out there, but I couldn't come up with sufficiently specific search phrasings to find them!

Dependencies: just JDK (made with version 7, recent tweak with 8, though no v8 features used).

Note re build tools etc.: While I plan to use Maven in the future, for tecnhnical reasons I am not in a position to do so yet, so am just uploading source code files here for the moment.

First commit of mid-2022 organisational tweak of 2015-written program not previously under version control.

Ever needed to divide a small number of items (e.g. pieces of fruit of random weight) into two collections, as evenly as possible? In the case of 3 items, the answer is, of course, always to divide as “biggest vs. other two”. Divvier is a small tool to take the guesswork, or tedious comparison of the various combinations, out of the situation for larger collections. Over 5 items, there is a random component to the algorithms used (not all combinations may be sampled), however the process for 6-11 is quite reliable in identifying the best split. The process used for 12 or more items is not guarenteed to do so, though the 'turbo' button can be used to increase  reliability, at the expense of speed - it cycles between 1x, 10x and 100x the default number of times that the processing algorithm loops for collections of >11. 