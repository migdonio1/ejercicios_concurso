#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
    int fib1=1,fib2=2,aux;
    int n;

    scanf("%d",&n);

    for(int i=2;i<n;i++){
        if(i==fib2){
            aux= fib1;
            fib1= fib2;
            fib2 = aux + fib2;
        }else {
            printf("%d ",i);
        }

    }
    return 0;
}
