#include<stdio.h>
#include<string.h>
int bigMOD(char *a, int b){
	int len = strlen(a);
	int mod = (a[0]-'0')%b;
	int i=1;
	for(;i<len;i++){
		mod = (mod*10+(a[i]-'0'))%b;
	}
	return mod;
}
int getGCD(int a, int b){
	while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
	}
	return a;
}
int main(){
	int t;
	scanf("%d",&t);
	while(t--){
		int a;
		char str[252];
		scanf("%d ",&a);
		scanf ("%[^\n]%*c", str);
		if(a==0) printf("%s\n",str);
		else{
			int b = bigMOD(str, a);
			printf("%d\n",getGCD(a,b));
		}
	}
	return 0;
}
