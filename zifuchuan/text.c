#define _CRT_SECURE_NO_WARNINGS 

#include <Windows.h>
#include <wchar.h>
long WinMain(HANDLE hPrevInstance, HANDLE hInstance, PSTR cmdLine, int cmdShowe)
{
	wchar_t *wideString = TEXT("abcdŒ“d");
	char text[128] = "";
	wsprintf(text, TEXT("%d"), wcslen(wideString));
	MessageBox(NULL, text,NULL, MB_CANCELTRYCONTINUE | MB_ICONERROR);
	return 0;
}