

set keep-english-in-normal-and-restore-in-insert
set nowrapscan " 禁止在搜索到文件两端时重新搜索
set hlsearch " 搜索时显示高亮
set incsearch
set ignorecase
set smartcase
set showmode
set number " 显示行号
set relativenumber " 相对行号
set scrolloff=1 " 你在写时 始终有三行的位置，不会到最低和最顶
set history=10
set clipboard+=unnamed "与系统共享剪切板



" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$






" ============= 空格 ============= hl jk sv
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
"===> a
" <C-F5>
nnoremap <Space>a :action Rerun<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a


" <C-S-F12> 全屏,与返回
nnoremap <Space>t :action HideAllWindows<CR>
" <F12> 返回上一个窗口。
nnoremap <Space>T :action JumpToLastWindow<CR>

"===> a
" 关闭所有标签页。
nnoremap <Space>A :action CloseAllEditors<CR>

" <F2>
nnoremap <Space>q :action GotoNextError<CR>
" <S-F2>
nnoremap <Space>p :action GotoPreviousError<CR>
" <C-F1>
nnoremap <Space>o :action ShowErrorDescription<CR>

" <C-E> <C-Tab>要多按下 <CR>==回车
nnoremap <Space>x :action RecentFiles<CR>
" <C-S-V>
nnoremap <Space>g :action PasteMultiple<CR>

" <C-S-BS> gi  它不进行插入模式，退格是 BS
" 上次编辑的位置，ideavim 有 :changes 说明支持 g; g, 命令了。
nnoremap <Space>i :action JumpToLastChange<CR>

" === e
" <A-Ins>
nnoremap <Space>e :action Generate<CR>
"===> e
" 关闭其它标签页。
nnoremap <Space>E :action CloseAllEditorsButActive<CR>

" === r
" <A-C-L>格式化代码
nnoremap <Space>r :action ReformatCode<CR>
" <C-A-O>
nnoremap <Space>R :action OptimizeImports<CR>
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
nnoremap <Space>D :action Unwrap<CR>




" <C-S-i>
nnoremap <Space>w :action QuickImplementations<CR>
"===> w
" <C-F4> 关闭当前标签页。
nnoremap <Space>W :action CloseContent<CR>
" <F9>
nnoremap <Space>y :action ChooseDebugConfiguration<CR>

" <C-F12>
nnoremap <Space>m :action FileStructurePopup<CR>
" <A-Up> alt+ 上下光标 下
nnoremap <Space>n :action MethodDown<CR>
" <A-Up> alt+ 上下光标 上
nnoremap <Space>z :action MethodUp<CR>




" ============= \ ============= 
" <A-C-S-S> 项目设置
nnoremap <Leader>a :action ShowProjectStructureSettings<CR>
" <A-C-S-Ins> 创建临时文件。
nnoremap <Leader>A :action NewScratchFile<CR>
" vim <C-V>
nnoremap <Leader>v <C-v>

" split分屏 
nnoremap <Leader>s <C-W>s  
nnoremap <Leader>v <C-W>v
" 移动到窗口
nnoremap <Leader>j <C-W>j
nnoremap <Leader>k <C-W>k
nnoremap <Leader>h <C-W>h
nnoremap <Leader>l <C-W>l
" 向下
nnoremap <Leader>f <C-f>
nnoremap <Leader>b <C-b>
nnoremap <Leader>d <C-d>
nnoremap <Leader>u <C-u>

" ============= g =============
" <A-C-Left> 上一次编辑地方
nnoremap g; :action Back<CR>
" <A-C-Right> 下一次编辑地方
nnoremap g, :action Forward<CR>



