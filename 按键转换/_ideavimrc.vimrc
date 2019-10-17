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


" Ctrl+Shift+M 在 {} 切换
nnoremap z[ :action EditorMatchBrace<CR>


" 选项卡操作
nnoremap tn gt
nnoremap tp gT


" ============= 空格 ============= 
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-F5>
nnoremap <Space>r :action Rerun<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a
" <A-Up> alt+ 上下光标
nnoremap <Space>k :action MethodUp<CR>
" <A-Down>
nnoremap <Space>j :action MethodDown<CR>
" <C-S-F12> 全屏
nnoremap <Space>f :action HideAllWindows<CR>
" <F12> 返回上一个窗口。
nnoremap <Space>l :action JumpToLastWindow<CR>
" <F2>
nnoremap <Space>n :action GotoNextError<CR>
" <S-F2>
nnoremap <Space>N :action GotoPreviousError<CR>
" <C-F1>
nnoremap <Space>s :action ShowErrorDescription<CR>
" 实现接口与重写方法。
nnoremap <Space>i :action ImplementMethods<CR>
nnoremap <Space>o :action OverrideMethods<CR>



" ============= v ============= 
" <C-F12>
vnoremap m :action FileStructurePopup<CR>
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
vnoremap D :action Unwrap<CR>
" Ctrl+Alt+F12 在文件夹中显示
vnoremap fb :action ShowFilePath<CR>
" <F9>
vnoremap n :action ChooseDebugConfiguration<CR>v
" <C-F4> 关闭当前标签页。
vnoremap w :action CloseContent<CR>
" 关闭其它标签页。
vnoremap e :action CloseAllEditorsButActive<CR>


" ============= \ ============= 
" 转换激活终端工具窗口
nnoremap <Leader>c :action ActivateTerminalToolWindow<CR>
" <A-Ins>
nnoremap <Leader>i :action Generate<CR>
" <A-Home>
nnoremap <Leader>h :action ShowNavBar<CR>
" 关闭所有标签页。
nnoremap <Leader>a :action CloseAllEditors<CR>


