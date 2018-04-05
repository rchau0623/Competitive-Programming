#include<stdio.h>
char type[5][6] = {{"    "},{"   |"},{"|   "},{"|  |"},{" -- "},};
char Num[10][5] = {{4,3,0,3,4},{0,1,0,1,0},{4,1,4,2,4},{4,1,4,1,4},{0,3,4,1,0},{4,2,4,1,4},{4,2,4,3,4},{4,1,0,1,0},{4,3,4,3,4},{4,3,4,1,4}};

main() {
    int n;
    char s[20];
    while(scanf("%d %s", &n, s) == 2) {
        if(n == 0)
            break;
        int a, b, c, tn;
        for(a = 0; a < 5; a++) {
            if(a == 0 || a == 2 || a == 4) tn = 1;
            else tn = n;
            while(tn--) {
                for(b = 0; s[b]; b++) {
                    if(s[b] == ' ') {putchar(' ');continue;}
                    putchar(type[Num[s[b] - '0'][a]][0]);
                    for(c = 0; c < n; c++)
                        putchar(type[Num[s[b] - '0'][a]][1]);
                    putchar(type[Num[s[b] - '0'][a]][3]);
                    if(s[b+1] != '\0') putchar(' ');
                }
                puts("");
            }
        }
        puts("");
    }
    return 0;
}