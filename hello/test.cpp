#define _CRT_SECURE_NO_WARNINGS 

#include<Windows.h>
#include<tchar.h>
#include <stdlib.h>
#include <string.h>
//创建窗口
static TCHAR szWindowClass[] = _T("My Class");
static TCHAR szTitle[] = _T("我的应用程序");

HINSTANCE hInst;

//handle messages that the application received from Windows when events occur.
//启用window-procedure function
LRESULT CALLBACK WindowProc(
	_In_ HWND hwnd,
	_In_ UINT uMsg,
	_In_ WPARAM wParam,
	_In_ LPARAM lParam
);
//程序入口
int CALLBACK WinMain(
	_In_ HINSTANCE hInstance,
	_In_ HINSTANCE hPrevInstance,
	_In_ LPSTR lpCmdLine,
	_In_ int nCmdShow
) {
	WNDCLASSEX wcex;
	wcex.cbSize = sizeof(WNDCLASSEX); //specifies the size of the strcture

	/*
	CS_HREDRAW:
	Redraws the entire window
	if a movement or size adjustment changes the width of the client area.
	CS_VREDRAW:
	Redraws the entire window
	if a movement or size adjustment changes the height of the client area.
	*/
	//窗口信息
	wcex.style = CS_HREDRAW | CS_VREDRAW;
	wcex.lpfnWndProc = WindowProc; //A pointer to the window procedure.
	wcex.cbClsExtra = 0; //The number of extra bytes to allocate following the window-class structure.
	wcex.cbWndExtra = 0; // The number of extra bytes to allocate following the window instance. 
	wcex.hInstance = hInstance; //A handle to the instance that contains the window procedure for the class.
	wcex.hIcon = LoadIcon(hInstance, IDI_APPLICATION); //A handle to the class icon. This member must be a handle to an icon resource. 
	wcex.hCursor = LoadCursor(NULL, IDC_ARROW); //A handle to the class cursor. This member must be a handle to a cursor resource. 
	/*
	The system automatically deletes class background brushes when the class is unregistered
	A handle to the class background brush.
	This member can be a handle to the brush to be used for painting the background,
	or it can be a color value.
	*/
	wcex.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
	wcex.lpszMenuName = NULL; // If this member is NULL, windows belonging to this class have no default menu.
	wcex.lpszClassName = szWindowClass;//If lpszClassName is a string, it specifies the window class name. 
	wcex.hIconSm = LoadIcon(wcex.hInstance, IDI_APPLICATION); //A handle to a small icon that is associated with the window class. 
	if (!RegisterClassEx(&wcex)) {
		MessageBox(NULL,
			_T("Call to RegisterClassEx failed!"),
			_T("Windows Desktop Guided Tour"),
			NULL);
		return 1;
	}

	// Store instance handle in our global variable
	hInst = hInstance;

	// The parameters to CreateWindow explained:
	// szWindowClass: the name of the application
	// szTitle: the text that appears in the title bar
	// WS_OVERLAPPEDWINDOW: the type of window to create
	// CW_USEDEFAULT, CW_USEDEFAULT: initial position (x, y)
	// 500, 100: initial size (width, length)
	// NULL: the parent of this window
	// NULL: this application does not have a menu bar
	// hInstance: the first parameter from WinMain
	// NULL: not used in this application
	//创建窗口
	HWND hWnd = CreateWindow(
		szWindowClass,
		szTitle,
		WS_OVERLAPPEDWINDOW,
		CW_USEDEFAULT, CW_USEDEFAULT,
		500, 100,
		NULL,
		NULL,
		hInstance,
		NULL
	);
	if (!hWnd)
	{
		MessageBox(NULL,
			_T("Call to CreateWindow failed!"),
			_T("Windows Desktop Guided Tour"),
			NULL);

		return 1;
	}
	// The parameters to ShowWindow explained:
	// hWnd: the value returned from CreateWindow
	// nCmdShow: the fourth parameter from WinMain

	//窗口可见
	ShowWindow(hWnd,
		nCmdShow);
	UpdateWindow(hWnd);
	// Main message loop:
	//处理消息
	MSG msg;
	while (GetMessage(&msg, NULL, 0, 0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return (int)msg.wParam;
}

LRESULT CALLBACK WindowProc(
	_In_ HWND hwnd,
	_In_ UINT uMsg,
	_In_ WPARAM wParam,
	_In_ LPARAM lParam
) {
	PAINTSTRUCT ps;
	HDC hdc;
	TCHAR greeting[] = _T("Hello World!");

	switch (uMsg)
	{
	case WM_PAINT:
		hdc = BeginPaint(hwnd, &ps);
		TextOut(hdc,
			5, 5,
			greeting, _tcslen(greeting));

		EndPaint(hwnd, &ps);
		break;
	case WM_DESTROY:
		PostQuitMessage(0);
		break;
	default:
		return DefWindowProc(hwnd, uMsg, wParam, lParam);
		break;
	}
	return 0;
}