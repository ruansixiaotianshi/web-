#define _CRT_SECURE_NO_WARNINGS 

#include <Windows.h>

long WinMain(HANDLE hPrevInstance, HANDLE hInstance, PSTR cmdLine, int cmdShowe)
{
	MessageBox(NULL, TEXT("Hello World!"),TEXT("result") , MB_CANCELTRYCONTINUE |MB_ICONERROR);
	return 0;
}