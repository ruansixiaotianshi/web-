#define _CRT_SECURE_NO_WARNINGS 

#include <Windows.h>
#include <tchar.h>

void * StrsCat(PTSTR buffer, PCTSTR text, ...)
{
	//1.����һ��va_list
	va_list pArgsList;
	//2.��ʼ��ȡ�����б�Ĳ�����Ϣ
	va_start(pArgsList, text);
	PCTSTR txt = text;
	while (txt)
	{
		lstrcat(buffer, txt);
		txt = va_arg(pArgsList, PCTSTR);
		buffer += lstrlen(txt);
	}
	//��������
	va_end(pArgsList);
}
int WinMain(HANDLE hPrevInstance, HANDLE hInstance, PSTR cmdLine, int cmdShowe)
{
	
	TCHAR buffer[1024] = _T("");
	StrsCat(buffer, _T("abcdef"), _T("ghijkl"), _T("mnopqr"), NULL);
	MessageBox(NULL, buffer, NULL, MB_CANCELTRYCONTINUE | MB_ICONERROR);
	return 0;
}