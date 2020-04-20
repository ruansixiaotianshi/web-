#define _CRT_SECURE_NO_WARNINGS 
#include<Windows.h>
#include<tchar.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

/*资源id*/
#define IDM_OPT1     301
#define IDM_OPT2     302
#define ID_OPTION3   303
static TCHAR szWindowClass[] = _T("My Class");
static TCHAR szTitle[] = _T("我的应用程序");

HMENU hRoot;//顶层菜单句柄

void createMyMenu() {
	hRoot = CreateMenu();//创建顶层菜单

	if (!hRoot) {
		printf("%s", "request for menu resource fail!");
		return;
	}

	HMENU pop1 = CreatePopupMenu();//创建弹出式菜单
	AppendMenu(hRoot, MF_POPUP, (UINT_PTR)pop1, L"操作");//往顶层菜单插入弹出式菜单
	AppendMenu(pop1, MF_STRING, IDM_OPT1, L"操作1");//往弹出式菜单插入菜单项
	AppendMenu(pop1, MF_STRING, IDM_OPT2, L"操作2");//往弹出式菜单插入菜单项

	MENUITEMINFO menuInfo;
	menuInfo.cbSize = sizeof(MENUITEMINFO);
	menuInfo.cch = 100;
	menuInfo.dwItemData = NULL;
	menuInfo.dwTypeData = (const wchar_t*)_T("操作2");
	menuInfo.fMask = MIIM_ID | MIIM_STRING | MIIM_STATE;
	menuInfo.fState = MFS_ENABLED;
	menuInfo.fType = MIIM_STRING;
	menuInfo.wID = IDM_OPT2;

	InsertMenuItem(pop1, IDM_OPT2, FALSE, &menuInfo);//往弹出式菜单插入菜单项
	InsertMenu(pop1, ID_OPTION3, MF_BYCOMMAND | MF_STRING, ID_OPTION3, L"操作3");//往弹出式菜单插入菜单项
}
LRESULT CALLBACK WindowProc(
	_In_ HWND hwnd,
	_In_ UINT uMsg,
	_In_ WPARAM wParam,
	_In_ LPARAM lParam
);

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


		
		createMyMenu();
	
		HWND hWnd = CreateWindow(
			szWindowClass,
			szTitle,
			WS_OVERLAPPEDWINDOW,
			CW_USEDEFAULT, CW_USEDEFAULT,
			500, 300,
			NULL,
			hRoot, //菜单资源
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
	ShowWindow(hWnd,
		nCmdShow);
	UpdateWindow(hWnd);
	// Main message loop:
	MSG msg;
	while (GetMessage(&msg, NULL, 0, 0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return (int)msg.wParam;


}
