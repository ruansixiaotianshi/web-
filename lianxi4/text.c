#define _CRT_SECURE_NO_WARNINGS 

#include <Windows.h>
#include <tchar.h>

void * StrsCat(PTSTR buffer, PCTSTR text, ...)
{
	//1.定义一个va_list
	va_list pArgsList;
	//2.开始获取参数列表的参数信息
	va_start(pArgsList, text);
	PCTSTR txt = text;
	while (txt)
	{
		lstrcat(buffer, txt);
		txt = va_arg(pArgsList, PCTSTR);
		buffer += lstrlen(txt);
	}
	//结束遍历
	va_end(pArgsList);
}
int WinMain(HANDLE hPrevInstance, HANDLE hInstance, PSTR cmdLine, int cmdShowe)
{
	
	TCHAR buffer[1024] = _T("");
	StrsCat(buffer, _T("abcdef"), _T("ghijkl"), _T("mnopqr"), NULL);
	MessageBox(NULL, buffer, NULL, MB_CANCELTRYCONTINUE | MB_ICONERROR);
	return 0;
}