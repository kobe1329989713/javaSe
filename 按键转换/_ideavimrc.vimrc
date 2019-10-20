

set keep-english-in-normal-and-restore-in-insert
set nowrapscan " 禁止在搜索到文件两端时重新搜索
set hlsearch " 搜索时显示高亮
set incsearch
set ignorecase
set smartcase
set showmode
set number " 显示行号
set relativenumber " 相对行号
set scrolloff=3 " 你在写时 始终有三行的位置，不会到最低和最顶
set history=10
set clipboard+=unnamed "与系统共享剪切板


" split分屏
nnoremap <Space>ws <C-W>s
nnoremap <Space>wv <C-W>v
" 移动到窗口  ##
nnoremap <Space>wj <C-W>j
nnoremap <Space>wk <C-W>k
nnoremap <Space>wh <C-W>h
nnoremap <Space>wl <C-W>l
" <c-f> <c-b> 可用idea alt+ 上下光标
nnoremap <Leader>f <C-f>
nnoremap <Leader>b <C-b>
nnoremap <Leader>d <C-d>
nnoremap <Leader>u <C-u>
" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$





" 选项卡操作
nnoremap tn gt
nnoremap tp gT





" ============= g =============
" gi  它不进行插入模式，退格是 BS
nnoremap <Space>gi :action JumpToLastChange<CR>

" <A-C-Left> 上一次编辑地方
nnoremap g; :action Back<CR>

" <A-C-Right> 下一次编辑地方
nnoremap g, :action Forward<CR>
" <C-S-V>
nnoremap gv :action PasteMultiple<CR>








" ============= 空格 ============= c d
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a

"===> a
" <C-F5>
nnoremap <Space>a :action Rerun<CR>
" 停止 
nnoremap <Space>A :action Stop<CR>

"===> b
" <C-F8>打上断点 / 取消断点  
nnoremap <Space>b :action ToggleLineBreakpoint<CR>
" <A-C-S-F8>临时断点，运行完自动删除断点
nnoremap <Space>B :action ToggleTemporaryLineBreakpoint<CR>

"===> e
" <C-S-F8> 取消所有(某些)断点和查看断点
nnoremap <Space>e :action ViewBreakpoints<CR>

"===> f
" 禁用断点(运行debug时有效)
nnoremap <Space>f :action XDebugger.MuteBreakpoints<CR>

"===> g
" <A-F10> 回到断点(无论在那里都回到执行那一步断点)
nnoremap <Space>g :action ShowExecutionPoint<CR>

"===> h
" F7 进入方法里
nnoremap <Space>h :action StepInto<CR>
" <A-S-F7> 强力进入某个方法里
nnoremap <Space>H :action ForceStepInto<CR>
"===> o
" <S-F7> tab 进入到某个特定的方法里。
nnoremap <Space>o :action SmartStepInto<CR>

"===> i
" <S-F8> 从某个方法里退出
nnoremap <Space>i :action StepOut<CR>

"===> j
" F8
nnoremap <Space>j :action StepOver<CR>

"===> k
" <A-F8>计算表达式，选中它，在按
nnoremap <Space>k :action EvaluateExpression<CR>

"===> l
" <A-F9>执行到光标所在行
nnoremap <Space>l :action RunToCursor<CR>

"===> m
" <F9> 执行到下一个断点。 
nnoremap <Space>m :action Resume<CR>

"===> n
" <C-S-F8> 编辑断点 
nnoremap <Space>n :action EditBreakpoint<CR>



"===> p
"===> q
"===> r
"===> s
"===> t
"===> u
"===> v
"===> w
"===> x
"===> y
"===> z


" 重新运行断点(降针) Drop Frame





" ============= \ ============= f d u b
"===> a
" 关闭所有标签页。
nnoremap <Leader>a :action CloseAllEditors<CR>

"===> c
" <A-C-F7>,<A-F7> 在那些地方用到它了。
" <A-C-F7>
nnoremap <Leader>c :action ShowUsages<CR>
" <A-F7>
nnoremap <Leader>C :action FindUsages<CR>

"===> e
" 关闭其它标签页。
nnoremap <Leader>e :action CloseAllEditorsButActive<CR>




"===> g
" <C-S-i>
nnoremap <Leader>g :action QuickImplementations<CR>

"===> h
" Ctrl+Shift+M 在 {} 切换
nnoremap <Leader>h :action EditorMatchBrace<CR>

"===> i
" 实现接口
nnoremap <Leader>i :action ImplementMethods<CR>

"===> j
"===> k
"===> l
"===> m
"===> n

"===> o
" 重写方法。
nnoremap <Leader>o :action OverrideMethods<CR>

"===> p
"===> q
"===> r
"===> s

"===> t
" <A-C-T> 环绕 if
nnoremap <Leader>T :action SurroundWith<CR>
" <C-F7>
nnoremap <Leader>t :action FindUsagesInFile<CR>


"===> v
"===> w

" <C-F4> 关闭当前标签页。
nnoremap <Leader>w :action CloseContent<CR>

"===> x
" 折叠之全部斩开
nnoremap <Leader>x :action ExpandAllRegions<CR>

"===> y
" <C-F9> 编译整个项目
nnoremap <Leader>y :action CompileDirty<CR>
" <C-S-F9> 编译所在的这个文件
nnoremap <Leader>Y :action Compile<CR>

"===> z
" <F9>
nnoremap <Leader>z :action ChooseDebugConfiguration<CR>
" 退出
nnoremap zq :action Exit<CR>













" ============= v ============= i a b h j k l o s w x e p r y
"====> c
" <A-Home>
vnoremap c :action ShowNavBar<CR><ESC>

" ===> d
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
vnoremap d :action Unwrap<CR><ESC>

" ===> f
" <A-C-L>格式化代码 
vnoremap f :action ReformatCode<CR><ESC>
" <C-A-O>
vnoremap F :action OptimizeImports<CR><ESC>

" ===> m
" <C-F12>
vnoremap m :action FileStructurePopup<CR><ESC>

" ===> n
" <C-S-F12> 全屏
vnoremap n :action HideAllWindows<CR><ESC>

"===> g
" <A-Ins>
vnoremap g :action Generate<CR><ESC>

"===> q 
" <C-F1>
vnoremap q :action ShowErrorDescription<CR><ESC>
" Ctrl+Alt+F12 在文件夹中显示
vnoremap Q :action ShowFilePath<CR><ESC>

"===> t 
" 转换激活终端工具窗口
vnoremap t :action ActivateTerminalToolWindow<CR><ESC>
vnoremap T :action Refactorings.QuickListPopupAction<CR><ESC>

"===> u 
" <A-Up> alt+ 上下光标 上
vnoremap U :action MethodUp<CR><ESC>
" <A-Up> alt+ 上下光标 下
vnoremap u :action MethodDown<CR><ESC>

"===> v  
" <F2>
vnoremap v :action GotoNextError<CR><ESC>
" <S-F2>
vnoremap V :action GotoPreviousError<CR><ESC>

"===> z
" <F12> 返回上一个窗口。
vnoremap z :action JumpToLastWindow<CR><ESC>