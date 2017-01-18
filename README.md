# paralleltask
Given various tasks arrival and execution times. Task should be done accordingly which task has lowest execution time. It is a periodic process. At last, we can see in every seconds information. Note: in input tasks should be given ascending order based on arrival time.

</br>

Sample Input</br>
9</br>
0 27</br>
0 1</br>
0 1</br>
3 1</br>
3 2</br>
3 3</br>
7 3</br>
7 2</br>
7 1</br>


Sample Output</br>
0th Second</br>
0 1</br>
0 27</br>
0 1</br>

1th Second</br>
0 1</br>
0 27</br>

2th Second</br>
0 27</br>

3th Second</br>
3 1</br>
3 3</br>
3 2</br>
0 26</br>

4th Second</br>
3 2</br>
3 3</br>
0 26</br>

5th Second</br>
3 1</br>
0 26</br>
3 3</br>

6th Second</br>
3 3</br>
0 26</br>

7th Second</br>
7 1</br>
3 2</br>
7 3</br>
0 26</br>
7 2</br>
