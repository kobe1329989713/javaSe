

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
set history=100000
set clipboard+=unnamed "与系统共享剪切板

nnoremap <C-a> ggVG
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






" ============= 空格 ============= 
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a

"===> a
"===> b
"===> c
"===> d
"===> e
"===> f
"===> g
"===> h
"===> i
"===> j
"===> k
"===> l
" <F12> 返回上一个窗口。
nnoremap <Space>l :action JumpToLastWindow<CR>
"===> m
"===> n
"===> o
"===> p
"===> q
"===> r
" <C-F5>
nnoremap <Space>r :action Rerun<CR>
"===> s
"===> t
"===> u
"===> v
"===> w
"===> x
"===> y
"===> z




" ============= \ ============= 
"===> a
" 关闭所有标签页。
nnoremap <Leader>a :action CloseAllEditors<CR>

"===> b
" <C-S-i>
nnoremap <Leader>b :action QuickImplementations<CR>

"===> c
" <A-C-F7>,<A-F7> 在那些地方用到它了。
" <A-C-F7>
nnoremap <Leader>c :action ShowUsages<CR>
" <A-F7>
nnoremap <Leader>C :action FindUsages<CR>

"===> d
" Ctrl+Shift+M 在 {} 切换
nnoremap <Leader>d :action EditorMatchBrace<CR>

"===> e
" 关闭其它标签页。
nnoremap <Leader>e :action CloseAllEditorsButActive<CR>

"===> f
"===> g
"===> h

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

"===> u
"===> v
"===> w

" <C-F4> 关闭当前标签页。
nnoremap <Leader>w :action CloseContent<CR>

"===> x
"===> y

"===> z
" <F9>
nnoremap <Leader>z :action ChooseDebugConfiguration<CR>
" <C-S-[> 向上，
nnoremap z[ :action EditorCodeBlockStartWithSelection<CR>
" <C-S-[> 向下
nnoremap z] :action EditorCodeBlockEndWithSelection<CR>
" 退出
nnoremap zq :action Exit<CR>














" ============= v ============= i a b h j k l o s w x e p r
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
vnoremap u :action MethodUp<CR><ESC>

"===> v  
" <F2>
vnoremap v :action GotoNextError<CR><ESC>
" <S-F2>
vnoremap V :action GotoPreviousError<CR><ESC>

"===> y 
" <A-Up> alt+ 上下光标 下
vnoremap y :action MethodDown<CR><ESC>

"===> z

