#include <iostream>
#include <stdio.h>

using namespace std;

int main(){
    int a,b,cont=0;
    int anterior,actual,aux;
    scanf("%d",&a);
    scanf("%d",&b);
    bool x = true;
    anterior = a;
    actual = b;
    printf("%d %d",a,b);
    while(x){
        if(anterior + actual>= 10){

            aux =actual;
            actual=anterior + actual-10;

        }else{
            aux =actual;
            actual=anterior + actual;

        }

            anterior = aux;
            cont++;
            if(anterior == a && actual == b){
                x=false;
            }
            printf(" %d",actual);
    }
    printf("\n%d",cont);
    return 0;
}
