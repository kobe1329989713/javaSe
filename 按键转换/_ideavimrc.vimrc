

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



" 恢复上一次操作
nnoremap U <C-r>
" 从那里复制到行尾。
nnoremap Y y$






" ============= l 开关组成命令 =============
" split分屏   s==一，v==|
nnoremap ls <C-W>s  
nnoremap lv <C-W>v
" 移动到窗口  ##
nnoremap lj <C-W>j
nnoremap lk <C-W>k
nnoremap lh <C-W>h
nnoremap tl <C-W>l
" 向下
nnoremap lf <C-f>
nnoremap lb <C-b>
nnoremap ld <C-d>
nnoremap lu <C-u>



" <C-S-F12> 全屏,与返回
nnoremap la :action HideAllWindows<CR>
" <F12> 返回上一个窗口。
nnoremap lc :action JumpToLastWindow<CR>

" <F2>
nnoremap lo :action GotoNextError<CR>
" <S-F2>
nnoremap lO :action GotoPreviousError<CR>
" <C-F1>
nnoremap lp :action ShowErrorDescription<CR>

" <C-E> <C-Tab>要多按下 <CR>==回车
nnoremap K :action RecentFiles<CR>
" <C-S-V>
nnoremap lg :action PasteMultiple<CR>

" <C-S-BS> gi  它不进行插入模式，退格是 BS
" 上次编辑的位置，ideavim 有 :changes 说明支持 g; g, 命令了。
nnoremap li :action JumpToLastChange<CR>

" === e
" <A-Ins>
nnoremap le :action Generate<CR>

" === r
" <A-C-L>格式化代码
nnoremap lr :action ReformatCode<CR>
" <C-A-O>
nnoremap lR :action OptimizeImports<CR>

" === t
" <C-S-Del> ,删除 if 循环 () {} 里面的东东。
nnoremap lt :action Unwrap<CR>
" Ctrl+Alt+F12 在文件夹中显示
nnoremap lT :action ShowFilePath<CR>


" === n
" === w
" === y
" === x
" === q
" === z
" === m






" ============= \ ============= f d u b Z
"===> a
" 关闭所有标签页。
nnoremap <Leader>a :action CloseAllEditors<CR>
"===> e
" 关闭其它标签页。
nnoremap <Leader>e :action CloseAllEditorsButActive<CR>
"===> w
" <C-F4> 关闭当前标签页。
nnoremap <Leader>w :action CloseContent<CR>


" ============= 空格 ============= c d  Z
" <C-S-F10>   加Space(空格)
nnoremap <Space>cr :action RunClass<CR>
" <S-F9>
nnoremap <Space>dr :action Debug<CR>
" <C-S-CR>
nnoremap [ :action EditorCompleteStatement<CR>a

"===> a
" <C-F5>
nnoremap <Space>a :action Rerun<CR>

" ============= g =============
" <A-C-Left> 上一次编辑地方
nnoremap g; :action Back<CR>
" <A-C-Right> 下一次编辑地方
nnoremap g, :action Forward<CR>



" ============= t 开关组成命令 ============= l
" 选项卡操作
nnoremap tn gt
nnoremap tp gT

" ============= z 开关组成命令 =============
