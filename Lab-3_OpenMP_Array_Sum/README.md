
## Assignment 3: Develop a distributed system, to find sum of N elements in an array by distributing N/n elements to n number of processors MPI or OpenMP.


1. **Install Open MPI**:

``` bash
sudo apt update
sudo apt install openmpi-bin libopenmpi-dev build-essential
```

2. **Compile Your MPI Program**:


``` bash
mpicc sum_array.c -o sum_array
mpicc multiplication_array.c -o multiplication_array

```

3. **Run Your MPI Program**:

For Sum
``` bash
mpiexec -n 4 ./sum_array

```
For Multiplication
``` bash
mpiexec -n 4 ./multiplication_array

```
This will execute your MPI program with 4 processes (`rank 0`, `rank 1`, `rank 2`, `rank 3`), each performing its respective tasks as defined in the program.

format this much only for the readme.md