#include <stdio.h>
#include "mpi.h"

int main(int argc, char* argv[]) {
    int rank, size;
    int num[20]; // N = 20, n = 4

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Initialize the array with values from 1 to 20
    for (int i = 0; i < 20; i++)
        num[i] = i + 1;

    if (rank == 0) {
        int products[4]; // Array to store received products from other ranks

        printf("Distribution at rank %d\n", rank);

        // Send portions of the array to other ranks
        for (int i = 1; i < 4; i++)
            MPI_Send(&num[i * 5], 5, MPI_INT, i, 1, MPI_COMM_WORLD); // N/n i.e. 20/4=5

        // Calculate local product for rank 0
        int product = 1, local_product = 1;
        for (int i = 0; i < 5; i++)
            local_product *= num[i];

        // Receive local products from other ranks
        for (int i = 1; i < 4; i++)
            MPI_Recv(&products[i], 1, MPI_INT, i, 1, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        printf("local product at rank %d is %d\n", rank, local_product);
        
        // Compute final product by aggregating local products
        product = local_product;
        for (int i = 1; i < 4; i++)
            product *= products[i];

        printf("final product = %d\n\n", product);
    } else {
        int received_part[5]; // Array to store received elements from rank 0

        // Receive portion of the array from rank 0
        MPI_Recv(received_part, 5, MPI_INT, 0, 1, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        // Calculate local product for other ranks
        int local_product = 1;
        for (int i = 0; i < 5; i++)
            local_product *= received_part[i];

        printf("local product at rank %d is %d\n", rank, local_product);

        // Send local product back to rank 0
        MPI_Send(&local_product, 1, MPI_INT, 0, 1, MPI_COMM_WORLD);
    }

    MPI_Finalize();
    return 0;
}
